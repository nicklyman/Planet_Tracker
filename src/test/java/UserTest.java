import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;

public class UserTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void User_UserInstanceOfUser() {
    User testUser = new User("p@gmail.com", "1234567890", "Verizon", "PatMWells", "hello");
    assertTrue(testUser instanceof User);
  }

  @Test
  public void User_UserGetId() {
    User testUser = new User("p@gmail.com", "1234567890", "Verizon", "PatMWells", "hello");
    testUser.save();
    assertEquals(testUser.getId(), User.find(testUser.getId()).getId());
  }

  @Test
  public void User_UserGetAllUsers() {
    User testUser = new User("p@gmail.com", "1234567890", "Verizon", "PatMWells", "hello");
    testUser.save();
    assertEquals(1, User.all().size());
  }

  @Test
  public void User_UserGetUserTime() {
    User testUser = new User("p@gmail.com", "1234567890", "Verizon", "PatMWells", "hello");
    testUser.save();
    testUser.setTime("January", "1", "2016", "04:00");
    assertEquals("2016-January-1 04:00", User.find(testUser.getId()).getUserTime());
  }
}
