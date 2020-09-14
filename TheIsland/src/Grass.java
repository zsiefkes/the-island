import java.util.ArrayList;

public class Grass implements GeographicalFeature {

	// instance attributes
	private int size;
	private char symbol = '#'; 
	private int x; 
	private int y;
	private Island island; // island grass belongs to, if any
	private int id; // let's have unique identifiers, too.

	// static field to store ids
	private static ArrayList<Integer> idList = new ArrayList<Integer>();
	
	// constructor
	public Grass(int size,  int x, int y) {
		this.size = size;
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

	public int getSize() {
		return size;
	}

	// increase and decrease size. overloaded methods - optional increment argument.
	public void increaseSize() {
		this.size++;
	}
	public void decreaseSize() {
		this.size--;
	}
	public void increaseSize(int increment) {
		this.size = this.size + increment;
	}
	public void decreaseSize(int increment) {
		this.size = this.size - increment;
	}

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

	@Override
	public String toString() {
		return "Grass [size=" + size + ", symbol=" + symbol + ", x=" + x + ", y=" + y + ", island=" + island + ", id="
				+ id + "]";
	}
	
	
}
