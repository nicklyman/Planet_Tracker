import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;



public class App {

  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      model.put("users", User.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/users", (request, response) -> {
      String userName = request.queryParams("newUserName");
      String userEmail = request.queryParams("userEmail");
      String userTelephone = request.queryParams("userTelephone");
      String month = request.queryParams("month");
      String day = request.queryParams("day");
      String year = request.queryParams("year");
      String time = request.queryParams("time");

      User user = new User(userName, userEmail, userTelephone);
      user.save();
      user.setTime(month, day, year, time);


      response.redirect("/");
      return null;
    });

    get("users/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      User user = User.find(Integer.parseInt(request.params("id")));

      String[] planetNames = {"mars", "venus", "neptune", "uranus", "mercury", "jupiter", "saturn", "pluto"};
      ArrayList<Planet> planets = new ArrayList<Planet>();



      for(String planetName : planetNames) {
        Planet foundPlanet = Planet.find(user, planetName);
        if(foundPlanet != null){
          planets.add(foundPlanet);
        }
      }


      model.put("user", user);
      model.put("planets", planets);
      model.put("template", "templates/user.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }

}
