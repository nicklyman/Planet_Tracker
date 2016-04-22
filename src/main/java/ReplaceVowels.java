import java.util.HashMap;
import java.util.ArrayList;

public class ReplaceVowels {

  public static String vowelRemover(String sentence){

    String newSentence = sentence.toLowerCase();

    ArrayList<String> vowels = new ArrayList<String>();
    vowels.add("a");
    vowels.add("e");
    vowels.add("i");
    vowels.add("o");
    vowels.add("u");

    String[] sentenceArray = newSentence.split("");

    for(String letter : sentenceArray){
      if(vowels.indexOf(letter) >= 0){
        sentence = sentence.replace(letter, "-");
        sentence = sentence.replace(letter.toUpperCase(), "-");
      }
    }

    return sentence;
  }

}
