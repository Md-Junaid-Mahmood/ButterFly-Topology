public class ProcessorToSwitchLink implements Link{
  Switch incomingEnd;
  Processor outgoingEnd;

  public void transmit(String receiver, Packet p){

    incomingEnd.acceptMessage(receiver,p);
  }
}
