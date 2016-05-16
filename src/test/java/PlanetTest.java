import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;

public class PlanetTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Planet_InstanceOfPlanet() {
    Planet testPlanet = new Planet("mars");
    assertTrue(testPlanet instanceof Planet);
  }

  @Test
  public void Planet_FindTime() {
    Planet testPlanet = new Planet("mars");
    User newUser = new User("Pat", "pat@gmail.com", "1234567890");
    newUser.save();
    newUser.setTime("May", "16", "2016", "04:00");
    assertEquals(newUser.getUserTime(), testPlanet.find(newUser).getPlanetTime());
  }

}
