import java.util.ArrayList;

public class Rabbit implements Animal {
	// instance attributes
	private char symbol = 'R';
	private int x; // horizontal position
	private int y; // vertical position
	private int energy;
	private int id; // unique id
	private Island island; // island the rabbit belongs to, if any.

	// static field to store ids. don't forget it has to be static!!!
	private static ArrayList<Integer> idList = new ArrayList<Integer>();

	// overloaded constructor, takes no arguments and sets pre-defined attributes
	public Rabbit() {		
		this.x = 0;
		this.y = 0;
		this.energy = 100;
		this.island = null;
		// generate unique id based on idList size
		this.id = idList.size() + 1;
		// add id to idList
		idList.add(id);
	}

	// overloaded constructor function taking position and energy level as arguments. does not initiate with an island.
	public Rabbit(int x, int y, int energy) {
		this.x = x;
		this.y = y;
		this.energy = energy;
		this.island = null;
		// generate unique id based on idList size
		this.id = idList.size() + 1;
		// add id to idList
		idList.add(id);
	}

	// change the rabbit's position, 1 coordinate at a time, either North, East, South or West
	// takes double between 0 and 1 as direction and determines movement using quadrants
	public void move(double direction) {

		// store initial position
		int initX = this.x;
		int initY = this.y;

		// declare variables to store new position. initialize new coordinates as
		// initial coordinates.
		int newX = initX;
		int newY = initY;

		// argument direction should be between 0 and 1. if not, no movement happens
		if (direction < 0.25) {
			// move north
			newY = initY - 1;

		} else if (direction < 0.5) {
			// move east
			newX = initX + 1;

		} else if (direction < 0.75) {
			// move south
			newY = initY + 1;

		} else if (direction < 1) {
			// move west
			newX = initX - 1;
		}

		// if the rabbit belongs to a island,
		if (this.island != null) {

			// first check it did not move out of the island's borders. obtain island width and height
			int width = this.island.getWidth();
			int height = this.island.getHeight();

			// send it to the opposite side if it does! this island is a torus!
			// note that the coordinates begin at 0 and end at width - 1 and height - 1

			// check x coordinate
			if (newX < 0) {
				newX = width - 1;
			} else if (newX > width - 1) {
				newX = 0;
			}

			// check y coordinate
			if (newY < 0) {
				newY = height - 1;
			} else if (newY > height - 1) {
				newY = 0;
			}

			// next, check it did not move to a spot already occupied by another rabbit.
			if (island.isOccupied(newX, newY)) {

				// if it is, move it back to its original position
				newX = initX;
				newY = initY;
			}
		}

		// set new position
		this.x = newX;
		this.y = newY;
	}

	@Override
	public int compareTo(Rabbit otherRabbit) {
		// compareTo method fulfilling Comparable<Rabbit> interface
		// set natural ordering on rabbits using their integer id.
		return Integer.compare(getId(), otherRabbit.getId());
	}

	// Getters and setters
	public char getSymbol() {
		return symbol;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getEnergy() {
		return energy;
	}
	
	public void addEnergy(int energy) {
		this.energy = this.energy + energy;
	}
	
	public void reduceEnergy(int energy) {
		this.energy = this.energy - energy;
	}

//	public void setEnergy(int energy) {
//		this.energy = energy;
//	}

	public int getId() {
		return id;
	}

	public Island getIsland() {
		return island;
	}

	public void setIsland(Island island) {
		this.island = island;
	}

	public String toString() {
		return "Rabbit\n x: " + x + "\n y: " + y
				+ "\n energy: " + energy + "\n id: " + id + "";
	}

}
