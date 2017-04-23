public class Ticket implements Comparable<Ticket>{
    
    //instance vars
    private int id;
    private int VIPLevel;
    private boolean isSolved;
    private String name;
    private String problem;
    private String solution;

    public Ticket(int Tid, int TVIPLevel, String Tname, String Tproblem){
	id = Tid;
	VIPLevel = TVIPLevel;
	name = Tname;
	problem = Tproblem;
    }

    public int getVIPLevel(){
	return VIPLevel;
    }

    public boolean getStatus(){
	return isSolved;
    }

    public void setVIPLevel(int newVIPLevel){
	VIPLevel = newVIPLevel;
    }
    
    public void setStatus(boolean status){
	isSolved = status;
    }

    public void setSolution(String Tsolution){
	solution = Tsolution;
    }

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
