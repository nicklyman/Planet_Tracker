import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  @Override
  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/planet_tracker_test", null, null);
  }

  @Override
  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String deletePlanetsQuery = "DELETE FROM planets *;";
      String deleteUsersQuery = "DELETE FROM users *;";
      con.createQuery(deletePlanetsQuery).executeUpdate();
      con.createQuery(deleteUsersQuery).executeUpdate();
    }
  }

}