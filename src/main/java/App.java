import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;



public class App {

  public static void main(String[] args) {
    //--------------------------------------------------------------------------
    //Messaging Service, uncomment when ready to begin automatic spam
    /*
    System.out.println("startup...");

    //Create Message object
    PlanetMessage myMessage = new PlanetMessage("planet.tracker123@gmail.com", args[0]);

    //Messaging Service
    System.out.println("initializing messaging service");
    //sends PlanetMessage email every 1 minute
    MessageService messageService = new MessageService(myMessage, Integer.valueOf(args[1]), 60);
    */
    //--------------------------------------------------------------------------
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      model.put("users", User.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/usersLogin", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String nameLogin = request.queryParams("nameLogin");
      String emailLogin = request.queryParams("emailLogin");
      String phoneLogin = request.queryParams("phoneLogin");

      int userExists = User.noCopiesInData(phoneLogin);
      User newUser = new User("No User Information Available", "testemail", "testPhone");

      if(userExists > 0){
        newUser = User.find(userExists);
      }
      model.put("user", newUser);
      model.put("template", "templates/user.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/userDateTime/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      User user = User.find(Integer.parseInt(request.params("id")));
      String month = request.queryParams("month");
      String day = request.queryParams("day");
      String year = request.queryParams("year");
      String time = request.queryParams("time");

      user.setTime(month, day, year, time);


      String[] planetNames = {"mars", "venus", "neptune", "uranus", "mercury", "jupiter", "saturn", "pluto"};
      ArrayList<Planet> planets = new ArrayList<Planet>();

      for(String planetName : planetNames) {
        Planet foundPlanet = Planet.find(user.getUserTime(), planetName);
        if(foundPlanet != null){
          planets.add(foundPlanet);
        }
      }
      model.put("user", user);
      model.put("planets", planets);
      model.put("template", "templates/user.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/users", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/profile.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/users", (request, response) -> {
      String userName = request.queryParams("newUserName");
      String userEmail = request.queryParams("userEmail");
      String userTelephone = request.queryParams("userTelephone");

      User user = new User(userName, userEmail, userTelephone);

      if(User.noCopiesInData(userTelephone) == 0){
        user.save();
      }
      response.redirect("/");
      return null;
    });


    get("/adminPage", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/adminPage.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/adminPage", (request, response) -> {
      String year = request.queryParams("year");
      String month = request.queryParams("month");
      String day = request.queryParams("day");
      String time = request.queryParams("time");
      String psw = request.queryParams("adminPassword");

      if(psw.equals(args[0])) {
        //Create Message object
        PlanetMessage myMessage = new PlanetMessage("planet.tracker123@gmail.com", psw);
        //Put together manual dateTime string
        String dateTime = DateTime.convertUserInput(year, month, day, time);
        //Messaging Service
        System.out.println("initializing messaging service");
        //send PlanetMessage email
        myMessage.send(dateTime);
      }
      response.redirect("/adminPage");
      return null;
    });

  }
}
