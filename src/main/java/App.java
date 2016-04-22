import java.util.HashMap;
import java.util.ArrayList;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;



public class App {

  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap model = new HashMap();

      model.put("template", "templates/home.vtl");
      
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/results", (request, response) -> {
      HashMap model = new HashMap();
      ReplaceVowels newReplace = new ReplaceVowels();
      String userInput = request.queryParams("vowelGame");

      model.put("userInput", userInput);
      model.put("gameString", newReplace.vowelRemover(userInput));
      model.put("template", "templates/results.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

}
