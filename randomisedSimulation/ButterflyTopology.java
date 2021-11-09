public class ButterflyTopology{
  Processor processorsArray[];
  int rank;
  int numOfProcessor;
  Switch topologySwitchs[][]; 
  
  
  public ButterflyTopology(int n){
  	numOfProcessor = n;
    rank = log2(n) + 1; // Assuming n to be the power of 2
    processorsArray = new Processor[numOfProcessor];
    topologySwitchs = new Switch[rank][numOfProcessor];
  	
    for(int i = 0; i < numOfProcessor; i++){
    	// creation of process and adding it into the array
      Processor proc = new Processor(i, rank);
      processorsArray[i] = proc;
    }
    
    
    for(int i = 0; i < rank; i++){
    	for(int j = 0; j < numOfProcessor; j++){
        // creation of switches for the entire topology
      	Switch node = new Switch(i, j);
        topologySwitchs[i][j] = node;
      }
    }
        
    setUpConnection();
    System.out.println("--------------------------------------------------");
    System.out.println("The topology has " + numOfProcessor + " Processors \nRank of the topology is " + rank);
  }
  
  public void setUpConnection(){
  	for(int i = 0; i < numOfProcessor; i++){
  		ProcessorToSwitchLink outgoingCable = new ProcessorToSwitchLink();
  		outgoingCable.incomingEnd = topologySwitchs[0][i];
  		outgoingCable.outgoingEnd = processorsArray[i];

      processorsArray[i].addProcessorToSwitchLink(outgoingCable);
      topologySwitchs[0][i].socket1 = outgoingCable;  
  		
  		
  		SwitchToProcessorLink incomingCable = new SwitchToProcessorLink();
  		incomingCable.incomingEnd = processorsArray[i];
//      System.out.println(rank);
  		incomingCable.outgoingEnd = topologySwitchs[rank - 1][i];

      processorsArray[i].addSwitchToProcessorLink(incomingCable);
      topologySwitchs[rank - 1][i].socket6 = incomingCable; 
  	}
  	
  	
  	for(int i = rank - 1; i >= 1; i--){
  		for(int j = 0; j < numOfProcessor; j++){
  			Switch node = topologySwitchs[i][j];
  			
  			int left = getLeftNode(i, j);
        int right = getRightNode(i, j);
        
        if(left > right){
          int temp = left;
          left = right;
          right = temp;
        }

        Switch leftSwitch = topologySwitchs[i - 1][left];
        Switch rightSwitch = topologySwitchs[i - 1][right];

        SwitchToSwitchLink leftCable = new SwitchToSwitchLink();
        SwitchToSwitchLink rightCable = new SwitchToSwitchLink();

        leftCable.incomingEnd = node;
        node.incomingLeft = leftCable;
        leftCable.outgoingEnd = leftSwitch;

        if(leftSwitch.outgoingLeft == null){
          leftSwitch.outgoingLeft = leftCable;
        }else{
          leftSwitch.outgoingRight = leftCable;
        }


        rightCable.incomingEnd = node;
        node.incomingRight = rightCable;
        rightCable.outgoingEnd = rightSwitch;

        if(rightSwitch.outgoingLeft == null){
          rightSwitch.outgoingLeft = rightCable;
        }else{
          rightSwitch.outgoingRight = rightCable;
        }
  		}
  	}
  }



  public static int log2(int n){
    int result = (int)(Math.log(n) / Math.log(2));
    return result;
  }


  public int getLeftNode(int row, int col){
    return col;
  }


  public int getRightNode(int row, int col){
    int msbPos = rank - row - 1;
    int number = (int)(Math.pow((double)2, (double)msbPos));

    col = col ^ number;
    return col;
  }
}

