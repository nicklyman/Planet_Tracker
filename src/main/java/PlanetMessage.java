import java.util.List;
import java.util.ArrayList;

public class PlanetMessage {
  private Email email;

  public PlanetMessage(String fromAddress, String fromPassword) {
    this.email = new Email(fromAddress, fromPassword);
  }

  //sending messages, doesn't know what time it is, so get the current time (rounded down)
  public void sendAutomated() {
    DateTime presentTime = new DateTime(System.currentTimeMillis());
    this.sendAutomated(presentTime.getSimpleDateTimeRoundedDown(), presentTime.getDateTimePSTRoundedDown());
  }

  //sending messages using a manual time
  public void sendAutomated(String dateTime, String localTime) {
    System.out.println("Messaging users for time: " + localTime + "PST");

    String messageToSend = textMessageBuilder(dateTime, localTime);
    System.out.println("Message:\n" + messageToSend);

    //loop through users database and send messages
    List<User> myUsers = User.all();
    List<String> myAddresses = new ArrayList<String>();
    for(User user : myUsers) {
      if(user.getSubscription()) {
        String userAddress = user.getPhone() + user.getTelephoneCarrier();
        myAddresses.add(userAddress);
      }
    }

    this.email.sendTextMessages(messageToSend, myAddresses);
  }

  //sending messages using a manual time
  public void sendAdmin(String dateTime) {
    System.out.println("Messaging users for time: " + dateTime + "UTC");

    String messageToSend = textMessageBuilder(dateTime);
    System.out.println("Message:\n" + messageToSend);

    //loop through users database and send messages
    List<User> myUsers = User.all();
    List<String> myAddresses = new ArrayList<String>();
    for(User user : myUsers) {
      if(user.getSubscription()) {
        String userAddress = user.getPhone() + user.getTelephoneCarrier();
        myAddresses.add(userAddress);
      }
    }

    this.email.sendTextMessages(messageToSend, myAddresses);
  }

  //method to send to a single user, for current system time
  public void sendToSingleUser(User user) {
    DateTime presentTime = new DateTime(System.currentTimeMillis());
    this.sendToSingleUser(user, presentTime.getSimpleDateTimeRoundedDown());
  }

  //method to send to a single user, for specific system time
  public void sendToSingleUser(User user, String dateTime) {
    System.out.println("Messaging user " + user.getUserName() + " for time: " + dateTime);


    String messageToSend = textMessageBuilder(dateTime);
    System.out.println("Message:\n" + messageToSend);

    String userAddress = user.getPhone() + user.getTelephoneCarrier();
    this.email.sendSingleTextMessage(messageToSend, userAddress);
  }


  private String textMessageBuilder(String dateTime, String localTime) {
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
    String messageToSend = localTime + "PST";
    for(Planet planet : myPlanets) {
      if(planet.getElevation() > 0) {
        messageToSend += "\n" + planet.getName().substring(0,1).toUpperCase() + planet.getName().substring(1) + " is visible: " + "\nAzimuth: " + planet.getAzimuth() + "°\nElevation: " + planet.getElevation() + "°\n";
      } else {
        messageToSend += "\n" + planet.getName().substring(0,1).toUpperCase() + planet.getName().substring(1) + " is currently below the horizon: " + "\nAzimuth: " + planet.getAzimuth() + "°\nElevation: " + planet.getElevation() + "°\n";
      }
    }

    if (messageToSend.equals(localTime + "PST")) {
      return null;
    } else {
      return messageToSend;
    }
  }

  private String textMessageBuilder(String dateTime) {
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
    String messageToSend = dateTime  + "UTC";
    for(Planet planet : myPlanets) {
      if(planet.getElevation() > 0) {
        messageToSend += "\n" + planet.getName().substring(0,1).toUpperCase() + planet.getName().substring(1) + " is visible: " + "\nAzimuth: " + planet.getAzimuth() + "°\nElevation: " + planet.getElevation() + "°\n";
      } else {
        messageToSend += "\n" + planet.getName().substring(0,1).toUpperCase() + planet.getName().substring(1) + " is currently below the horizon: " + "\nAzimuth: " + planet.getAzimuth() + "°\nElevation: " + planet.getElevation() + "°\n";
      }
    }

    if (messageToSend.equals(dateTime + "UTC")) {
      return null;
    } else {
      return messageToSend;
    }
  }
}
