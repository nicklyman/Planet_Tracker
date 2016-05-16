import org.sql2o.*;

public class DB {
////REEEEEMMMMMMMMMMMOOOOOOOOVEEEEEE
public static String user = "Blake";
public static String pass = "blake1997";
///THIIIIIIIIIIIIISSSSSSSSSS^^^^^^^^^
  public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/planet_tracker", user, pass);
}
