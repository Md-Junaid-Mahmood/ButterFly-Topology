import java.util.Scanner;

public class Processor{
  private int processorID;
  int rank;
  
  private ProcessorToSwitchLink outgoing;
  private SwitchToProcessorLink incoming;

  public Processor(int id, int rank){
    this.processorID = id;
    this.rank = rank;
  }

  public void addProcessorToSwitchLink(ProcessorToSwitchLink cable){
    this.outgoing = cable;
  }

  public void addSwitchToProcessorLink(SwitchToProcessorLink cable){
    this.incoming = cable;
  }

  public String toString(){
    System.out.println("Pr  " + this.processorID);
    return "Pr  " + this.processorID;
  }

  public void send(int receiver, String message){
    String recv = new String("");
    for(int i = 1; i < this.rank; i++){
      recv = recv + "0";
    }

    int pos = rank - 2;
    boolean flag = true;
    while(receiver != 0){
      int value = receiver % 2;
      char insert = (char)(value + 48);
      
      if(flag){
        recv = recv.substring(0, pos) +
               Character.toString(insert);
        flag = false;
      }else{
        recv = recv.substring(0, pos) +
               Character.toString(insert) +
               recv.substring(pos + 1);
      }
      pos--;
      receiver = (int)(receiver / 2);
    }

    this.toString();
    System.out.println("\t" + recv);
    outgoing.transmit(recv, message);
  }

  public void receive(String message){
    this.toString();
    System.out.println(message);
  }
}