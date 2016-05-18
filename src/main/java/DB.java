import org.sql2o.*;

public class DB {
  private static String user = "Blake";
  private static String pass = "blake1997";

  public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/planet_tracker", user, pass);
}
