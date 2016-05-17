import java.util.Timer;
import java.util.TimerTask;

public class MessageService {
  private Timer timer;

  public MessageService(PlanetMessage myMessage, int messageDelay, int messagePeriod) { //messDelay & messagePeriod in minutes
    timer = new Timer();
    OutputTask myTask = new OutputTask(myMessage);
    timer.scheduleAtFixedRate(myTask, messageDelay * 60 * 1000, messagePeriod * 60 * 1000);
  }


  class OutputTask extends TimerTask {
    private int i = 0;
    private PlanetMessage myMessage;

    public OutputTask (PlanetMessage myMessage) {
      this.myMessage = myMessage;
    }

    //MAIN LOOP FOR MESSAGING
    public void run() {
      this.myMessage.send();
    }

  }
}
