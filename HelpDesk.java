import java.util.ArrayList;
import java.io.Console;
import java.io.IOException;

public class HelpDesk{

    //instance variables
    private int _currentID = 1;
    private PriorityQueue<Ticket> _queue = new ArrayPriorityQueue<>();
    private ArrayList<Ticket> _solved = new ArrayList<>();
    private Console _console = System.console();

    public HelpDesk(){	
    }

    public String getString(String text){
	return _console.readLine(text);
    }

    public int getInt(String text){
	boolean flag = true;
	int retInt = 0;
	while (flag){
	    try{
		retInt = Integer.parseInt(getString(text));
		flag = false;
	    }
	    catch ( Exception e ){
		System.out.println("Please enter a number.");
	    }
	}
	return retInt;
    }

    public void submitTicket(){
	System.out.println("Submit your ticket.\n");
	_queue.add(new Ticket( _currentID, getInt("VIPLevel: "), getString("Name: "), getString("Problem: ")));
	System.out.println("There are " + _currentID++ + " unsolved Tickets ahead of you.\n");
    }

    public void solveTicket(){
	if (_queue.isEmpty()){
	    System.out.println("\nThere are no unsolved Tickets at the moment.\n");
	    return;
	}

	Ticket currentTicket = _queue.peekMin();
	int choice = 4;
	System.out.println("\n" + currentTicket);
	System.out.println( "\nWhat would you like to do?\n");
	System.out.println( "1. Answer the ticket.\n" + "2. Change the VIPLevel.\n" + "3. Remove the ticket (no solution)\n" + "4. Do nothing\n");

	choice = getInt("Choice: ");
	if (choice == 1){
	    currentTicket.setSolution(getString("Describe the solution: "));
	    currentTicket.setStatus(true);
	    _solved.add(_queue.removeMin());
	    System.out.println("Your solution has been recorded, moved Ticket to solved archive\n");
	}
	else if (choice == 2){
	    currentTicket.setVIPLevel(getInt("New priority: "));
	    _queue.add(_queue.removeMin());
	    System.out.println("VIPLevel has successfully been changed");
	}
	else if (choice == 3){
	    _queue.removeMin();
	    System.out.println("Let's hope the boss doesn't notice");
	}
	else{
	    System.out.println("You lazy bum");
	}
    }

    public void viewSolvedTickets(){
	if (_solved.isEmpty()){
	    System.out.println("No tickets here, how about you go solve some?\n");
	}
	else{
	    for (Ticket t : _solved){
		System.out.println(t);
	    }
	}
    }

    public void initiateHelpDesk(){
	int choice = 0;
	while (true){
	    System.out.println("What would you like to do?\n");
	    System.out.println("1. Submit a ticket.\n" + "2. Solve a ticket.\n" + "3. Browse solutions to previous tickets.\n" + "4. Leave.\n");

	    choice = getInt("Choice: ");
	    if (choice == 1){
		submitTicket();
	    }
	    else if (choice == 2){
		solveTicket();
	    }
	    else if (choice == 3){
		viewSolvedTickets();
	    }
	    else{
		System.out.println("Thank you for coming\n");
		System.exit(0);
	    }
	}
    }
	    

    public static void main(String[] args){
	HelpDesk Helper = new HelpDesk();

	Helper.initiateHelpDesk();
    }
}

    
