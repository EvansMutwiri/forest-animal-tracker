import org.sql2o.Connection;

import java.util.List;

public class Ranger {
    public  int id;
    public  String name;

    public Ranger(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Object find(int rangerId) {
        return rangerId;
    }

    public String getName() {
        return name;
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO ranger (name,contact,badgeNumber) VALUES (:name,:contact,:badgeNumber)";
            this.id = (int) con.createQuery(sql, true)
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
        return id;
    }
}