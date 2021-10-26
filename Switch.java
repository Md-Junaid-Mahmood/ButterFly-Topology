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

  public String toString(){
    return "(" + row + "," + column + ")";
  }


}
