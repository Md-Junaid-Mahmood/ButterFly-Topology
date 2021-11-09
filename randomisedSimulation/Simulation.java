import java.util.Scanner;
import java.util.Random;
import java.lang.Thread;

public class Simulation {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    int optionCount=2, tcCount=-1;

    System.out.print("Enter Number of Processor: ");
    int num = sc.nextInt();
    ButterflyTopology topology = new ButterflyTopology(num);

    int tc=0;
    while(true){
      System.out.println("----------------------------------------------------");
      System.out.println("                  TESTCASE " + (tc+1)+ "                ");
      System.out.println("----------------------------------------------------");
      
      // 0 for Unicast Message and 1 for Broadcast Message
      int action = rand.nextInt(optionCount);

      String message = "Message "+tc;

      if(action == 0){
        // sender processorID
        int sender = rand.nextInt(num);
        
        // receiver processorID
        int receiver = rand.nextInt(num);
        while(sender==receiver)
          receiver = rand.nextInt(num);

        System.out.println("Sender Processor: "+sender);
        System.out.println("Receiver Processor: "+receiver);
        System.out.println("Message: "+message+'\n');

        Packet p = new Packet(message,sender,receiver);

        topology.processorsArray[sender].send(receiver,p);
      }else if(action == 1){

        // sender processorID
        int sender = rand.nextInt(num);
        
        System.out.println("Sender Processor: "+sender);
        System.out.println("Message: "+message);

        topology.processorsArray[sender].broadcast(num, message);
        System.out.println("Finished Broadcasting\n");
      }

      // increment testcase count
      tc++;

      if(tc==tcCount){
        System.out.print("Press 0 to continue simulation and 1 to exit: ");
        int flag = sc.nextInt();
        if(flag==0){
          tc=0;
        } else {
          System.out.println("---------------------------------------------------");
          System.out.println("\nEnding Simulation");
          break;
        }
      }

      // sleep
      try{
        Thread.sleep(1000);
      } catch (Exception e){
        System.out.println(e);
      }
    }

    sc.close();
  }
}
