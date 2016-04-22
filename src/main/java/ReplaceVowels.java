import java.util.HashMap;
import java.util.ArrayList;

public class ReplaceVowels {

  public static String vowelRemover(String sentence){


    ArrayList<String> vowels = new ArrayList<String>();
    vowels.add("a");
    vowels.add("e");
    vowels.add("i");
    vowels.add("o");
    vowels.add("u");

    String[] sentenceArray = sentence.split("");

    for(String letter : sentenceArray){
      if(vowels.indexOf(letter) >= 0){
        sentence = sentence.replace(letter, "-");
      }
    }

    return sentence;
  }

}
