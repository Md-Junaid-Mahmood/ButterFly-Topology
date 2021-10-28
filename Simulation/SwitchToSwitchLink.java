public class SwitchToSwitchLink implements Link{
  Switch incomingEnd;
  Switch outgoingEnd;

  public void transmit(String receiver, String message){
    incomingEnd.acceptMessage(receiver, message);
  }
}
