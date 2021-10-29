package de.uni.koeln.se.state;

public class Elevator {

	public static int current_Floor=5;
	int dest_Floor;
	
	private Elv_States State = new Elv_States();
	
	public Elevator (int dest_floor)
	{
		this.dest_Floor=dest_floor;
	System.out.println("*** Destination floor is: "+ dest_Floor);
	arrive_atFloor();


	}

	private void arrive_atFloor() {
		State.CurrentState=State.Idle;
		
		if(this.current_Floor>this.dest_Floor) {
			moveDown();
		}
		else if (this.current_Floor<this.dest_Floor) {
			moveUp();
		}else {
			exit();
		}
	}
	
	public void moveDown() {
		State.CurrentState=State.Moving_down;
		this.current_Floor--;
		System.out.println("Elevator is moving down");
		printFloor();
		arrive_atFloor();
	}
	
	public void moveUp() {
		State.CurrentState=State.Moving_up;
		this.current_Floor++;
		System.out.println("Elevator is moving up");
		printFloor();
		arrive_atFloor();
	}
	
	public void exit() {
		System.out.println("Elevator arrived at destination Floor.");
		System.out.println("Thanks for travelling :)");
	}
	
	public void printFloor() {
		System.out.println("Current Floor is now "+this.current_Floor);
	}
}
