
import org.sql2o.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public DatabaseRule database = new DatabaseRule();


  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Login");
  }

  @Test
  public void NavigatetoProfileUser() {
    goTo("http://localhost:4567/");
    click("a", withText("Make a Profile"));
    assertThat(pageSource()).contains("Create a Profile");
  }

  @Test
  public void MakeUser() {
    goTo("http://localhost:4567/");
    click("a", withText("Make a Profile"));
    fill("#newUserName").with("PatMWells");
    fill("#userPassword").with("hello");
    fill("#userEmail").with("p@gmail.com");
    fill("#userTelephone").with("1234567890");
    click("option", withText("Verizon"));
    submit("#createProfile");
    assertThat(pageSource()).contains("PatMWells");
  }

  @Test
  public void UserLogIn() {
    User testUser = new User("p@gmail.com", "1234567890", "Verizon", "PatMWells", "hello");
    testUser.save();
    goTo("http://localhost:4567/");
    fill("#userNameLogin").with("PatMWells");
    fill("#passwordLogin").with("hello");
    submit("#userLogin");
    assertThat(pageSource()).contains("PatMWells");
  }

  @Test
  public void PlanetTimesAppear() {
    User testUser = new User("p@gmail.com", "1234567890", "Verizon", "PatMWells", "hello");
    testUser.save();
    goTo("http://localhost:4567/");
    fill("#userNameLogin").with("PatMWells");
    fill("#passwordLogin").with("hello");
    submit("#userLogin");
    click("option", withText("January"));
    click("option", withText("18"));
    click("option", withText("2023"));
    fill("#time").with("08:00");
    submit("#submitTime");
    assertThat(pageSource()).contains("Mars");
  }



}
