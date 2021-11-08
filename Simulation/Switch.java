public class Switch {
  public int row;
  public int column;
  
  ProcessorToSwitchLink socket1 = null;

  SwitchToSwitchLink incomingLeft = null;
  SwitchToSwitchLink incomingRight = null;
  SwitchToSwitchLink outgoingLeft = null;
  SwitchToSwitchLink outgoingRight = null;

  SwitchToProcessorLink socket6 = null;

  public Switch(int r, int c){
    row = r;
    column = c;
  }

  public void acceptMessage(String receiver, Packet p){
    char direction = receiver.charAt(0);
    receiver = receiver.substring(1);

    System.out.print("Switch Visited: ");

    for(int i = 0; i < row; i++){
      System.out.print("\t");
    }
    System.out.println(this.toString());


    // System.out.println("\t" + receiver);
    if(direction == '0'){
      outgoingLeft.transmit(receiver, p);
    }else if(direction == '1'){
      outgoingRight.transmit(receiver, p);
    }else{
      socket6.transmit(receiver, p);
      return;
    }
  }


  public void acceptMessage(Packet p){
    int size = p.broadcastReceiver.length;

    String leftReceiver[] = new String[size];
    String rightReceiver[] = new String[size];

    for(int i = 0; i < size; i++){
      if(p.broadcastReceiver[i] == null){
        leftReceiver[i] = null;
        rightReceiver[i] = null;
        continue;
      }else{
        String receiver = new String();
        receiver = p.broadcastReceiver[i];
        char direction = receiver.charAt(0);
        receiver = receiver.substring(1);

        if(direction == '0'){
          leftReceiver[i] = receiver;
          rightReceiver[i] = null;
        }else if(direction == '1'){
          rightReceiver[i] = receiver;
          leftReceiver[i] = receiver;
        }else{
          socket6.transmit(receiver, p);
          System.out.print("Switch Visited: ");
          System.out.println(this.toString());
          return;
        }
      }
    }

    System.out.print("Switch Visited: ");
    for(int i = 0; i < row; i++){
      System.out.print("\t");
    }
    System.out.println(this.toString());

    Packet leftPacket = new Packet(p.msg, p.sender, p.isBroadcast, leftReceiver);
    Packet rightPacket = new Packet(p.msg, p.sender, p.isBroadcast, rightReceiver);

    outgoingLeft.transmit(leftPacket);
    outgoingRight.transmit(rightPacket);
      // System.out.println("\t" + receiver);
  }

  public String toString(){
    return "(" + row + "," + column + ")";
  }
}
