public class SwitchToProcessorLink implements Link{
  Switch outgoingEnd;
  Processor incomingEnd;

  public void transmit(String receiver, String message){
    incomingEnd.receive(message);
  }
}
