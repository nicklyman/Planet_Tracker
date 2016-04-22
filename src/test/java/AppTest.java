import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  // @Test
  // public void rootTest() {
  //   goTo("http://localhost:4567/");
  //   assertThat(pageSource()).contains("Leap year detector");
  // }

  // @Test
  // public void isALeapYear() {
  //   goTo("http://localhost:4567");
  //   fill("#year").with("2004");
  //   submit(".btn");
  //   assertThat(pageSource()).contains("2004 is a leap year!");
  // }


}
