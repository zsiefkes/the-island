import java.util.ArrayList;

public class Water implements GeographicalFeature {
	// instance attributes
	private char symbol = '~'; 
	private int x; 
	private int y;
	private Island island; // island water belongs to, if any
	private int id; 

	// static field to store ids
	private static ArrayList<Integer> idList = new ArrayList<Integer>();
	
	// constructor
	public Water(int x, int y) {
		this.x = x;
		this.y = y;
		// set island to null by default
		this.island = null;
		// create unique id based on idList size, beginning at id = 1 (not 0).
		this.id = idList.size() + 1;
		// add id to idList
		idList.add(id);
	}
	
	// getters and setters


	public char getSymbol() {
		return symbol;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}


	public Island getIsland() {
		return island;
	}

	public void setIsland(Island island) {
		this.island = island;
	}

	public int getId() {
		return id;
	}

}
