
public interface GeographicalFeature {
/* 	// instance attributes
	private int size; // integer value between 0 and 9.
	private char symbol; // for now the symbol is the integer representing the size
	private int x; // coordinates within world
	private int y;
	private World world; // world plant belongs to, if any
	private int id; // let's have unique identifiers, too.
*/
	// getters
	public int getX();
	public int getY();
	public char getSymbol();
	public Island getIsland();
}
