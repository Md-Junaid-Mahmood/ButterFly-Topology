public class Packet {
    String msg;
    int sender;
    int receiver;


    boolean isBroadcast = false;
    String broadcastReceiver[];


    public Packet(String msg, int sender, int receiver){
        this.msg = msg;
        this.sender = sender;
        this.receiver = receiver;
    }
    

    public Packet(String msg, int sender, boolean isBroadcast, String array[]){
        this.msg = msg;
        this.sender = sender;
        isBroadcast = true;

        int size = array.length;
        broadcastReceiver = new String[size];
        for(int i = 0; i < size; i++){
            broadcastReceiver[i] = array[i];
        }
    }
}
