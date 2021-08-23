import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;

public class Ranger {
    public  int rangerId;
    public  String name;

    public Ranger(int rangerId, String name) {
        this.rangerId = rangerId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO ranger (id, name) VALUES (:id, :name)";
            this.rangerId = (int) con.createQuery(sql, true)
                    .addParameter("rangerId", this.rangerId)
                    .addParameter("name", this.name)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Ranger> all() {
        String sql = "SELECT * FROM ranger;";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).throwOnMappingFailure(false).executeAndFetch(Ranger.class);
        }
    }

    public int getRangerId() {
        return rangerId;
    }
}