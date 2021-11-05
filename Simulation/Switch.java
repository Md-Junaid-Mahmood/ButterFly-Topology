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

  public void acceptMessage(String receiver,Packet p){
    char direction = receiver.charAt(0);
    receiver = receiver.substring(1);

    System.out.print("Switch Visited: ");
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

  public String toString(){
    return "(" + row + "," + column + ")";
  }
}
