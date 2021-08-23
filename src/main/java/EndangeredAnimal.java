import org.sql2o.Connection;
import java.util.List;

public class EndangeredAnimal extends Animal {
    private String health;
    private String age;


    public static final String HEALTHY = "healthy";
    public static final String ILL  = "ill";
    public static final String OKAY  = "okay";

    public static final String NEWBORN = "newborn";
    public static final String YOUNG  = "young";
    public static final String ADULT  = "adult";

    public EndangeredAnimal(String name, String health, String age) {
        this.health=health;
        this.age=age;
        this.name=name;
    }

    @Override
    public void save(){
        super.save();
        try(Connection connect= DB.sql2o.open()){
            String sql = "INSERT INTO animals  (name,health,age) VALUES (:name,:health,:age)";
            connect.createQuery(sql, true)
                    .addParameter("name",this.name)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .executeUpdate();
        }
    }

    public static List<EndangeredAnimal> all(){
        String sql = "SELECT * FROM animals;";
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
                throw new UnsupportedOperationException("Animal not found");
            }
            return animal;
        }
    }
}


