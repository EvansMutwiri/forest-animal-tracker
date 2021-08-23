import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Animal extends Sighting{
    public int id;
    public String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object otherAnimal) {
        if (!(otherAnimal instanceof Animal)) {
            return false;
        } else {
            Animal newAnimal = (Animal) otherAnimal;
            return this.getName().equals(newAnimal.getName());
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (id, name) VALUES (:id, :name)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("id", this.id)
                    .addParameter( "name",this.name)
                    .executeUpdate()
                    .getKey();
        }
    }

}