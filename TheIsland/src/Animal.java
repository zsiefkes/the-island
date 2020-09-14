
public interface Animal {
//	- move
	public void move(double direction);
	// locate
	public int getX();
	public int getY();
	
	// getters
	public char getSymbol();
	public int getEnergy();
	
	// increase and decrease energy. overloaded methods, take optional energy increase/decrase argument
	public void increaseEnergy();
	public void decreaseEnergy();
	public void increaseEnergy(int energy);
	public void decreaseEnergy(int energy);

	public String toString();
	//	- detect food
//	public void detectFood();
////	- detect water
//	public void detectWater();
////	- detect predators
//	public void detectPredators();
////	- detect prey
//	public void detectPrey();
////	- mate with creatures of the same type
//	public void mate();
}
