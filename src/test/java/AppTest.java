import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;

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
    assertThat(pageSource()).contains("See What Planets Are In The Sky!!!");
  }

  @Test
  public void MakeUser() {
    goTo("http://localhost:4567");
    fill("#newUserName").with("Patrick");
    fill("#userEmail").with("p@gmail.com");
    fill("#userTelephone").with("1234567890");
    submit("button");
    assertThat(pageSource()).contains("Patrick");
  }


}
