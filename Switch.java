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

  public void acceptMessage(String receiver, String message){
    if(socket6 != null){
      socket6.transmit(receiver, message);
      return;
    }

    char direction = receiver.charAt(0);
    receiver = receiver.substring(1);
    this.toString();
    System.out.println("\t" + receiver);
    if(direction == '0'){
      outgoingLeft.transmit(receiver, message);
    }else{
      outgoingRight.transmit(receiver, message);
    }
  }

  public String toString(){
    System.out.println("(" + row + "," + column + ")");
    return "(" + row + "," + column + ")";
  }


}
