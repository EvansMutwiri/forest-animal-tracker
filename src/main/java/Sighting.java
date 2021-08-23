import org.sql2o.*;

public abstract class Sighting {
    public int id;
    public String name;
    public String type;
    public String location;
    public String rangerName;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Sighting(int id, String name, String type, String location, String rangerName) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.location = location;
        this.rangerName = rangerName;
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (name, type, location, rangerName) VALUES (:name, :type, :location, :rangerName)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter( "type",this.type)
                    .addParameter( "location",this.location)
                    .addParameter( "rangerName",this.rangerName)
                    .executeUpdate()
                    .getKey();
        }
    }
}