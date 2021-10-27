import java.util.Scanner;

public class Simulation {
  public static void main(String[] args) {
    ButterflyTopology topology = new ButterflyTopology(8);
   
    while(true){
      Scanner sc = new Scanner(System.in);
      System.out.print("Sender Processor: ");
      int sender = sc.nextInt();

      System.out.print("Receiver Processor: ");
      int receiver = sc.nextInt();

      System.out.print("Message: ");
      String message = Integer.toString(sc.nextInt());


      topology.processorsArray[sender].send(receiver, message);
    
    }
  }
}
