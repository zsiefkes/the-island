
public class EntryPoint {
	
	public EntryPoint() {
		// create two islands
		Island islandA = new Island(30, 10);
		Island islandB = new Island(60, 10);
		
		// generate a handful of rabbits to each island
		islandA.genAnimals(10);
		islandB.genAnimals(20);
		
		// add grass and water 
		islandA.genGrass(20);
		islandA.genWater(20);
		islandB.genGrass(50);
		islandB.genWater(30);
		
		// run island animations with 10 updates and report number of living rabbits at end.
		islandA.animateIsland(10);
		islandA.reportNumAnimals();
		islandB.animateIsland(10);
		islandB.reportNumAnimals();
				
	}
	
	public static void main(String[] args) {
		new EntryPoint();
	}
}
