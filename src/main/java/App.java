import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.awt.Dialog;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JDialog;

import static spark.Spark.*;



public class App {

  public static void main(String[] args) {
    // //--------------------------------------------------------------------------
    // //Messaging Service, uncomment when ready to begin automatic spam
    // System.out.println("startup...");
    //
    // //Create Message object
    // PlanetMessage serviceMessage = new PlanetMessage("planet.tracker123@gmail.com", args[0]);
    //
    // //Messaging Service
    // System.out.println("initializing messaging service");
    // //sends PlanetMessage email every 1 minute
    // MessageService messageService = new MessageService(serviceMessage, Integer.valueOf(args[1]), 5);
    //--------------------------------------------------------------------------
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/usersLogin", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String userNameLogin = request.queryParams("userNameLogin");
      String passwordLogin = request.queryParams("passwordLogin");
      User user = User.userNamePasswordLookUp(userNameLogin, passwordLogin);
      model.put("user", user);
      model.put("template", "templates/user.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/users/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      User user = User.find(Integer.parseInt(request.params("id")));
      model.put("user", user);
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

    post("/users", (request, response) -> {
      String userEmail = request.queryParams("userEmail");
      String userTelephone = request.queryParams("userTelephone");
      String userTelephoneCarrier = request.queryParams("userTelephoneCarrier");
      String userName = request.queryParams("newUserName");
      String userPassword = request.queryParams("userPassword");


      User user = new User(userEmail, userTelephone, userTelephoneCarrier, userName, userPassword);
      int copyFinder = User.noCopiesInData(user);
      if(copyFinder == 0){
        user.save();
      } else {
        user = User.find(copyFinder);
      }

      String url = String.format("/users/%d", user.getId());
      response.redirect(url);
      return null;
    });

    get("/users", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/profile.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


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

    get("/delete/:id", (request, response) -> {
      User user = User.find(Integer.parseInt(request.params("id")));
      JFrame frame = new JFrame();
      frame.setAlwaysOnTop(true);
      String password = (String)JOptionPane.showInputDialog(frame, "Enter your password to delete your profile:\n", "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
      String url = String.format("/users/%d", user.getId());

      if((password != null) && (password.length() > 0)) {
        boolean passwordCheck = user.delete(password);
        if(passwordCheck){
          url = "/";
        }
      }
      response.redirect(url);
      return null;
    });

  }
}
