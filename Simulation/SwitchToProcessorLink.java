public class SwitchToProcessorLink implements Link{
  Switch outgoingEnd;
  Processor incomingEnd;

  public void transmit(String receiver, Packet p){
    
    incomingEnd.receive(p);
  }
}
