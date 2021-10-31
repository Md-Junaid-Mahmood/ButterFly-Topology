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
        
        int sender ;
        while(true){
        sender= sc.nextInt();
        if(sender<num)
        break;
        else
        System.out.println("(Sender id range is from 0 to "+(num-1) +" inclusive) please reenter Sender processor:");
        }

        System.out.print("Receiver Processor: ");
        int receiver ;
        while(true){
         receiver= sc.nextInt();
         if(receiver<num)
         break;
         else
         System.out.println("(Receiver id range is from 0 to "+(num-1) +" inclusive) please reenter Receiver processor:");
        }
        System.out.print("Message: ");
        sc.nextLine();
        String message = sc.nextLine();
        packet p=new packet(message,sender,receiver);
        topology.processorsArray[sender].send(receiver,p);
      }else if(action == 2){
        System.out.print("Sender Processor: ");
        int sender ;
         while(true){
          sender= sc.nextInt();
          if(sender<num)
          break;
          else
          System.out.println("(Sender id range is from 0 to "+(num-1) +" inclusive) please reenter Sender processor:");
         }
        System.out.print("Message: ");
        sc.nextLine();
        String message = sc.nextLine();

        topology.processorsArray[sender].broadcast(num, message);
      }

      
      System.out.print("\nPress 1 to Exit and Any other number to Continue: ");
      int flag = sc.nextInt();

      if(flag == 1){
        break;
      }
    }

    sc.close();
  }
}
