import java.util.List;
import java.util.ArrayList;

public class PlanetMessage {
  private Email email;

  public PlanetMessage(String fromAddress, String fromPassword) {
    this.email = new Email(fromAddress, fromPassword);
  }

  //sending messages, doesn't know what time it is, so get the current time (rounded down)
  public void send() {
    DateTime presentTime = new DateTime(System.currentTimeMillis());
    this.send(presentTime.getSimpleDateTimeRoundedDown());
  }

  //sending messages using a manual time
  public void send(String dateTime) {
    System.out.println("Messaging users for time: " + dateTime);

    String[] planetNames = {"mercury", "venus", "mars", "jupiter", "saturn", "uranus", "neptune", "pluto"};
    ArrayList<Planet> myPlanets = new ArrayList<Planet>();

    //create planet objects based on what dateTime it is
    for(String planetName : planetNames) {
      Planet foundPlanet = Planet.find(dateTime, planetName);
      if(foundPlanet != null){
        myPlanets.add(foundPlanet);
      }
    }

    //gets planet info and creates string for emailing/text
    String messageToSend = dateTime;
    for(Planet planet : myPlanets) {
      messageToSend += "\n" + planet.getName().substring(0,1).toUpperCase() + planet.getName().substring(1) + " is visible: " + "\nAzimuth: " + planet.getAzimuth() + "°\nElevation: " + planet.getElevation() + "°\n";
    }

    //loop through users database and send messages
    List<User> myUsers = User.all();
    for(User user : myUsers) {
      //get user address from database
      String userAddress = user.getPhone() + user.getTelephoneCarrier();
      this.email.sendTextMessage(messageToSend, userAddress);
    }

  }
}
