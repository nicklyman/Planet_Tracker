import java.time.LocalDateTime;
import java.util.List;
import org.apache.commons.mail.*;



public class Email {
  private String fromEmailAddress;
  private String fromEmailPassword;

  public Email(String fromEmailAddress, String fromEmailPassword) {
    this.fromEmailAddress = fromEmailAddress;
    this.fromEmailPassword = fromEmailPassword;
  }


  public void sendSingleMailMessage(String text, String emailTo){
    try {
      SimpleEmail email = new SimpleEmail();
      email.setHostName("smtp.gmail.com");
      email.setSmtpPort(465);
      email.setAuthenticator(new DefaultAuthenticator(this.fromEmailAddress, this.fromEmailPassword));
      email.setSSLOnConnect(true);
      email.setFrom(this.fromEmailAddress, "Planet Tracker");
      email.setSubject("Planet Tracker email");
      email.setMsg(text);
      email.addTo(emailTo);
      // email.setDebug(true);
      email.send();
    } catch (Exception e) {
      System.out.println("Single Email failed to send");
    }
  }

  public void sendSingleTextMessage(String text, String emailTo){
    try {
      SimpleEmail email = new SimpleEmail();
      email.setHostName("smtp.gmail.com");
      email.setSmtpPort(465);
      email.setAuthenticator(new DefaultAuthenticator(this.fromEmailAddress, this.fromEmailPassword));
      email.setSSLOnConnect(true);
      email.setFrom(this.fromEmailAddress, "Planet Tracker");
      email.setSubject("Planet Tracker Text");
      email.setMsg(text);
      email.addTo(emailTo);
      // email.setDebug(true);  //if failing, uncomment to print out debug messages in terminal
      email.send();
    } catch (Exception e) {
      System.out.println("Single Text failed to send");
    }
  }

  public void sendTextMessages(String text, List<String> addressList){
    try {
      int totalAddresses = addressList.size();
      int loops = (int)(Math.ceil(totalAddresses / 100.0));

      //gmail SMTP emails max at 100 recipients
      for (int i = 0; i < loops; i++) {
        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(this.fromEmailAddress, this.fromEmailPassword));
        email.setSSLOnConnect(true);
        email.setFrom(this.fromEmailAddress, "Planet Tracker");
        email.setSubject("Planet Tracker Text");
        email.setMsg(text);

        if (totalAddresses >= 100) {
          for (String address : addressList.subList(i*100 , ((i+1)*100)-1)) {
            email.addBcc(address);
          }
          // email.setDebug(true);  //if failing, uncomment to print out debug messages in terminal
          email.send();
        } else {
          for (String address : addressList.subList(i*100 , (addressList.size() - 1))) {
            email.addBcc(address);
          }
          // email.setDebug(true);  //if failing, uncomment to print out debug messages in terminal
          email.send();
        }

        totalAddresses -= 100;
      }


    } catch (Exception e) {
      System.out.println("Mass text failed to send");
    }
  }

}
