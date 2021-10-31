public class ProcessorToSwitchLink implements Link{
  Switch incomingEnd;
  Processor outgoingEnd;

  public void transmit(String receiver, packet p){

    incomingEnd.acceptMessage(receiver,p);
  }
}
