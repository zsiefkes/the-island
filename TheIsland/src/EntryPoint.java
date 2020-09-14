
public class EntryPoint {
	
	public EntryPoint() {
		// create two islands
		Island islandA = new Island(30, 10);
		Island islandB = new Island(60, 10);
		
		// generate a handful of rabbits to each island
		islandA.genRabbits(10);
		islandB.genRabbits(20);
		
		// add several patches of grass
		islandA.genGrass(10);
		islandB.genGrass(20);
		
		// run island animations with 10 updates and report number of living rabbits at end.
		islandA.animateIsland(10);
		islandA.reportNumAnimals();
		islandB.animateIsland(10);
		islandB.reportNumAnimals();
				
		// ### grass needs to grow with each update. check this is happening?
	}
	
	public static void main(String[] args) {
		new EntryPoint();
	}
}
