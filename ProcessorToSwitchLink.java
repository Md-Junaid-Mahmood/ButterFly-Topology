public class ProcessorToSwitchLink implements Link{
  Switch incomingEnd;
  Processor outgoingEnd;

  public void transmit(String receiver, String message){
    incomingEnd.acceptMessage(receiver, message);
  }
}
