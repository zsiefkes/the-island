
public class EntryPoint {
	
	public EntryPoint() {
		// create island
		Island islandA = new Island(30, 10);
		
		// generate 17 rabbits
		islandA.genRabbits(17);
		
		// run island animation with 10 updates
		islandA.animateIsland(10);
	}
	
	public static void main(String[] args) {
		new EntryPoint();
	}
}
