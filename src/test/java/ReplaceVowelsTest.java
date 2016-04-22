import java.util.HashMap;
import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;


public class ReplaceVowelsTest {

  @Test
  public void ReplaceVowels_ReturnString_true() {
    ReplaceVowels testString = new ReplaceVowels();
    String test = testString.vowelRemover("hello");
    assertEquals(true,  test instanceof String);
  }

  @Test
  public void ReplaceVowels_ReplaceAWithDash_true() {
    ReplaceVowels testString = new ReplaceVowels();
    String test = "-pple";
    assertEquals(test, testString.vowelRemover("apple"));
  }
}
