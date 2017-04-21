//Ticket
import cs1.Keyboard;

public class Ticket{
    
    //instance vars
    private int id;
    private int VIPLevel;
    private String problem;
    private boolean isSolved;
    private String name;
    private String solution;

    public Ticket(){
	System.out.println("How important is your request?");
	int inputVIPLevel = Keyboard.readInt();
	VIPLevel = inputVIPLevel;
    }

}
