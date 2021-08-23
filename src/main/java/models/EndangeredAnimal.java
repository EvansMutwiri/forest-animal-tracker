package models;

import org.sql2o.Connection;
import java.util.List;

public class EndangeredAnimal extends Animal {
    private String health;
    private String age;
    private String location;

    public EndangeredAnimal(String name, String type, String age, String location, String rangerName) {
        this.health=health;
        this.age=age;
        this.name=name;
        this.location=location;
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public static String getHEALTHY() {
        return HEALTHY;
    }

    public static String getILL() {
        return ILL;
    }

    public static String getOKAY() {
        return OKAY;
    }

    public static String getNEWBORN() {
        return NEWBORN;
    }

    public static String getYOUNG() {
        return YOUNG;
    }

    public static String getADULT() {
        return ADULT;
    }

    public static final String HEALTHY = "healthy";
    public static final String ILL  = "ill";
    public static final String OKAY  = "okay";

    public static final String NEWBORN = "newborn";
    public static final String YOUNG  = "young";
    public static final String ADULT  = "adult";

    @Override
    public void save(){
        super.save();
        try(Connection connect= DB.sql2o.open()){
            String sql = "INSERT INTO animals  (name,health,age, location) VALUES (:name,:health,:age,:location)";
            connect.createQuery(sql, true)
                    .addParameter("name",this.name)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .addParameter("location", this.location)
                    .executeUpdate();
        }
    }

    public static List<EndangeredAnimal> all(){
        String sql = "SELECT * FROM animals WHERE type = 'endangered'";
        try(Connection connect= DB.sql2o.open()){
            return connect.createQuery(sql).executeAndFetch(EndangeredAnimal.class);
        }
    }
    public static EndangeredAnimal find(int id){
        try(Connection connect = DB.sql2o.open()){
            String sql = "SELECT * FROM animals WHERE id= :id;";
            EndangeredAnimal animal = connect.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            if (animal == null) {
                throw new UnsupportedOperationException("models.Animal not found");
            }
            return animal;
        }
    }
}


