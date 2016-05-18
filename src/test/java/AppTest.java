
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
  public void MakeUser() {
    goTo("http://localhost:4567/");
    click("a", withText("Make a Profile"));
    fill("#userEmail").with("p@gmail.com");
    fill("#userTelephone").with("1234567890");
    click("option", withText("Verizon"));
    fill("#newUserName").with("PatMWells");
    fill("#userPassword").with("hello");
    submit("button");
    assertThat(pageSource()).contains("Patrick");
  }


}
