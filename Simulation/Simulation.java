import java.util.Scanner;

public class Simulation {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter Number of Processor: ");
    int num = sc.nextInt();
    ButterflyTopology topology = new ButterflyTopology(num);

    while(true){
      System.out.print("\nPress 1 for Unicast Message and 2 for Broadcast Message: ");
      int action = sc.nextInt();

      if(action == 1){
        System.out.print("Sender Processor: ");
        
        int sender;
        while(true){
          sender = sc.nextInt();
          if(sender < num)
            break;
          else
            System.out.print("(Sender id range is from 0 to " + (num - 1) + " inclusive) please reenter Sender processor: ");
        }

        System.out.print("Receiver Processor: ");
        int receiver;
        while(true){
          receiver = sc.nextInt();
          if(receiver<num)
            break;
          else
            System.out.print("(Receiver id range is from 0 to "+(num-1) +" inclusive) please reenter Receiver processor:");
        }

        System.out.print("Message: ");
        sc.nextLine();
        String message = sc.nextLine();
        Packet p = new Packet(message,sender,receiver);

        System.out.println("\n--------------------------------------------------");
        topology.processorsArray[sender].send(receiver,p);
        System.out.println("--------------------------------------------------\n");
      }else if(action == 2){
        System.out.print("Sender Processor: ");
        int sender ;
        while(true){
          sender= sc.nextInt();
          if(sender<num)
            break;
          else
            System.out.print("(Sender id range is from 0 to " + (num-1) + " inclusive) please reenter Sender processor:");
        }
        System.out.print("Message: ");
        sc.nextLine();
        String message = sc.nextLine();

        System.out.println("\n--------------------------------------------------");
        topology.processorsArray[sender].broadcast(num, message);
        System.out.println("Finished Broadcasting\n--------------------------------------------------\n");
      }

      
      System.out.print("Press 1 to Exit and Any other number to Continue: ");
      int flag = sc.nextInt();
      System.out.print("\n--------------------------------------------------");
      
      if(flag == 1){
        System.out.println("\nEnding Simulation");
        break;
      }
    }

    sc.close();
  }
}
