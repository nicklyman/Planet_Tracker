import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;

public class DateTimeTest {

  @Test
  public void DateTimeTest_InstanceOfDateTimeTest() {
    DateTime testDateTime = new DateTime(60000);
    assertTrue(testDateTime instanceof DateTime);
  }

  @Test
  public void DateTimeTest_convertUserInput() {
    DateTime testDateTime = new DateTime(60000);
    assertEquals("2017-Feb-09 05:00", DateTime.convertUserInput("2017", "Feb", "09", "05:00"));
  }

  @Test
  public void DateTimeTest_getSimpleDateTime() {
    DateTime testDateTime = new DateTime(1463604021568L);
    String time = testDateTime.getSimpleDateTime();
    assertEquals("2016-May-18 20:40", time);
  }

  @Test
  public void DateTimeTest_getSimpleDateTimeRoundedDown() {
    DateTime testDateTime = new DateTime(1463604021568L);
    String time = testDateTime.getSimpleDateTimeRoundedDown();
    assertEquals("2016-May-18 20:00", time);
  }
}
