public class Processor{
  private int processorID;
  
  private ProcessorToSwitchLink outgoing;
  private SwitchToProcessorLink incoming;

  public Processor(int id){
    processorID = id;
  }

  public void addProcessorToSwitchLink(ProcessorToSwitchLink cable){
    outgoing = cable;
  }

  public void addSwitchToProcessorLink(SwitchToProcessorLink cable){
    incoming = cable;
  }

  public String toString(){
    return "Pr  " + processorID;
  }
}