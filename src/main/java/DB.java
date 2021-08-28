import org.sql2o.*;

public class DB {
//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "moringa", "moringa");
//public static Sql2o sql2o = new Sql2o("jdbc:postgres://szormzlolohdmk:7116b0bf289662ddd418a073affd054eb3ebd3205318e7d3882889abaa79bbfa@ec2-18-235-45-217.compute-1.amazonaws.com:5432/damgl33uc56qj6\n", "moringa", "moringa");
static String connectionString = "jdbc:postgresql://ec2-18-235-45-217.compute-1.amazonaws.com:5432/damgl33uc56qj6"; //!
    static Sql2o sql2o = new Sql2o(connectionString, "szormzlolohdmk", "7116b0bf289662ddd418a073affd054eb3ebd3205318e7d3882889abaa79bbfa"); //!
}