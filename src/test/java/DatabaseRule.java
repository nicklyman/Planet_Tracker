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
      // String deleteMarsQuery = "DELETE FROM mars *;";
      String deleteVenusQuery = "DELETE FROM venus *;";
      String deleteSaturnQuery = "DELETE FROM saturn *;";
      String deleteNeptuneQuery = "DELETE FROM neptune *;";
      String deletePlutoQuery = "DELETE FROM pluto *;";
      String deleteJupiterQuery = "DELETE FROM jupiter *;";
      String deleteMercuryQuery = "DELETE FROM mercury *;";
      String deleteUranusQuery = "DELETE FROM uranus *;";
      String deleteUsersQuery = "DELETE FROM users *;";
      // con.createQuery(deleteMarsQuery).executeUpdate();
      con.createQuery(deleteVenusQuery).executeUpdate();
      con.createQuery(deleteSaturnQuery).executeUpdate();
      con.createQuery(deleteNeptuneQuery).executeUpdate();
      con.createQuery(deletePlutoQuery).executeUpdate();
      con.createQuery(deleteJupiterQuery).executeUpdate();
      con.createQuery(deleteMercuryQuery).executeUpdate();
      con.createQuery(deleteUranusQuery).executeUpdate();
      con.createQuery(deleteUsersQuery).executeUpdate();
    }
  }

}
