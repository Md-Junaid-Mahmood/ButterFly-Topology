public class SwitchToProcessorLink implements Link{
  Switch outgoingEnd;
  Processor incomingEnd;

  public void transmit(String receiver, packet p){
    
    incomingEnd.receive(p);
  }
}
