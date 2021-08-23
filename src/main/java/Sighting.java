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
}