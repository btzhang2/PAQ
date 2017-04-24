public class Ticket implements Comparable<Ticket>{
    
    //instance vars
    private int id;
    private int VIPLevel;
    private boolean isSolved;
    private String name;
    private String problem;
    private String solution;

    //overloaded constructor sets instance vars
    public Ticket(int Tid, int TVIPLevel, String Tname, String Tproblem){
	id = Tid;
	VIPLevel = TVIPLevel;
	name = Tname;
	problem = Tproblem;
    }

    //returns the VIP level (priority) of the ticket
    public int getVIPLevel(){
	return VIPLevel;
    }

    //returns true if the ticket is solved, false otherwise
    public boolean getStatus(){
	return isSolved;
    }

    //sets the VIP level of the ticket
    public void setVIPLevel(int newVIPLevel){
	VIPLevel = newVIPLevel;
    }
    
    //sets the solved status of the ticket, whether true or false
    public void setStatus(boolean status){
	isSolved = status;
    }

    //sets the solution for the ticket
    public void setSolution(String Tsolution){
	solution = Tsolution;
    }

    //compares the VIP level to another ticket to see which gets priority
    public int compareTo(Ticket referenceName){
	return VIPLevel - referenceName.getVIPLevel();
    }

    public String toString(){
	String retStr = "Ticket Number: " + id;
	retStr += "\nName: " + name;
	retStr += "\nVIPLevel: " + VIPLevel;
	retStr += "\nStatus: " + isSolved;
	retStr += "\nProblem: " + problem;
	retStr += "\nSolution: " + solution;
	return retStr;
    }	
}
