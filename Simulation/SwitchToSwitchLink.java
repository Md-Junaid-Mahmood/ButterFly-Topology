public class SwitchToSwitchLink implements Link{
  Switch incomingEnd;
  Switch outgoingEnd;

  public void transmit(String receiver, packet p){
    incomingEnd.acceptMessage(receiver, p);
  }
}
