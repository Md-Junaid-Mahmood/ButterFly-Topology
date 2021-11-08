public class SwitchToSwitchLink implements Link{
  Switch incomingEnd;
  Switch outgoingEnd;

  public void transmit(String receiver, Packet p){
    incomingEnd.acceptMessage(receiver, p);
  }

  public void transmit(Packet p){
    incomingEnd.acceptMessage(p);
  }
}
