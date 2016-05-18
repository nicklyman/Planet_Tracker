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
  public void Planet_getName() {
    Planet testPlanet = new Planet("mars");
    assertEquals("mars", testPlanet.getName());
  }

  @Test
  public void Planet_getPlanetTime() {
    Planet testPlanet = new Planet("mars");
    User testUser = new User("p@gmail.com", "1234567890", "Verizon", "PatMWells", "hello");
    testUser.save();
    testUser.setTime("January", "1", "2016", "04:00");
    Planet foundPlanet = Planet.find(testUser.getUserTime(), "mars");
    assertEquals("2016-January-1 04:00", foundPlanet.getPlanetTime());
  }

  @Test
  public void Planet_getAzimuth() {
    Planet testPlanet = new Planet("mars");
    User testUser = new User("p@gmail.com", "1234567890", "Verizon", "PatMWells", "hello");
    testUser.save();
    testUser.setTime("Jun", "02", "2016", "04:00");
    Planet foundPlanet = Planet.find(testUser.getUserTime(), "mars");
    assertTrue(136.0883 == foundPlanet.getAzimuth());
  }

  @Test
  public void Planet_getElevation() {
    Planet testPlanet = new Planet("mars");
    User testUser = new User("p@gmail.com", "1234567890", "Verizon", "PatMWells", "hello");
    testUser.save();
    testUser.setTime("Jun", "02", "2016", "04:00");
    Planet foundPlanet = Planet.find(testUser.getUserTime(), "mars");
    assertTrue(10.6238 == foundPlanet.getElevation());
  }

  @Test
  public void Planet_FindTime() {
    Planet testPlanet = new Planet("mars");
    User newUser = new User("p@gmail.com", "1234567890", "Verizon", "PatMWells", "hello");
    newUser.save();
    newUser.setTime("Nov", "12", "2016", "01:00");
    assertEquals(newUser.getUserTime(), testPlanet.find(newUser.getUserTime(), "mars").getPlanetTime());
  }

}
