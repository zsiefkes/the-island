import java.util.ArrayList;

public class Island {
	// height and width
	private int width;
	private int height;

	// fields for storing and animals and geographicalFeatures.
	ArrayList<Animal> animals = new ArrayList<Animal>();
	ArrayList<GeographicalFeature> geographicalFeatures = new ArrayList<GeographicalFeature>();
	ArrayList<Grass> grassPatches = new ArrayList<Grass>();

	// constructor taking width and height
	public Island(int width, int height) {
			this.width = width;
			this.height = height;
		}

	// check if a grass patch is the coordinate in argument and return the Grass object if so
	public Grass hasGrass(int x, int y) {
		
		// Grass to return
		Grass grass = null;
		
		// loop through all grass patches
		for (Grass g : grassPatches) {
			
			// check if grass' position matches input arguments
			if (g.getX() == x && g.getY() == y) {
				
				// set grass in variable and break out of loop
				grass = g;
				break;
			}
		}
		
		// return grass
		return grass;
	}
	
//	// check if any other animal is residing in a certain position and return a boolean indicating so.
//	public boolean hasWater(int x, int y) {
//		
//		// boolean to return
//		boolean isOccupied = false;
//		
//		// loop through all animals
//		for (Animal b : this.animals) {
//			
//			// check if animal's position matches input arguments
//			if (b.getX() == x && b.getY() == y) {
//				
//				// set boolean to true and break out of loop
//				isOccupied = true;
//				break;
//			}
//		}
//		
//		// return boolean
//		return isOccupied;
//	}
	
	
	// check if any other animal is residing in a certain position and return a boolean indicating so.
	public boolean isOccupied(int x, int y) {

		// boolean to return
		boolean isOccupied = false;

		// loop through all animals
		for (Animal b : this.animals) {
			
			// check if animal's position matches input arguments
			if (b.getX() == x && b.getY() == y) {
				
				// set boolean to true and break out of loop
				isOccupied = true;
				break;
			}
		}

		// return boolean
		return isOccupied;
	}
	
//	// randomly generate a specified number of geographicalFeatures
//	public void genGeographicalFeatures(int numGeographicalFeatures) {
//		
//		for (int i = 0; i < numGeographicalFeatures; i++) {
//			
//			// randomly pick a size between 0 and 9
//			int size = (int) (Math.random() * 9);
//			
//			// randomly pick coordinates within island boundaries
//			int x = (int) (Math.random() * this.width);
//			int y = (int) (Math.random() * this.height);
//			
//			// check position is not already occupied and try again until one is found. or,
//			// give up after 20 tries
//			int count = 0;
//			while (isOccupied(x, y) || count > 20) {
//				x = (int) (Math.random() * width);
//				y = (int) (Math.random() * height);
//				count++;
//			}
//			
//			// set default geographicalFeature symbol for now
//			char symbol = '+';
//			
//			// create geographicalFeature
//			GeographicalFeature geographicalFeature = new GeographicalFeature(size, symbol, x, y);
//			
//			// set island on geographicalFeature to this island
//			geographicalFeature.setIsland(this);
//			
//			// add geographicalFeature to list of geographicalFeatures
//			this.geographicalFeatures.add(geographicalFeature);
//		}
//	}
	// randomly generate a specified number of patches of grass
	public void genGrass(int numGrass) {

		for (int i = 0; i < numGrass; i++) {

			// randomly pick a size between 0 and 9
			int size = (int) (Math.random() * 9);

			// randomly pick coordinates within island boundaries
			int x = (int) (Math.random() * this.width);
			int y = (int) (Math.random() * this.height);

			// check position is not already occupied and try again until one is found. or, give up after 20 tries
			int count = 0;
			while (isOccupied(x, y) || count > 20) {
				x = (int) (Math.random() * width);
				y = (int) (Math.random() * height);
				count++;
			}
			// create grass
			Grass grass = new Grass(size, x, y);

			// set island on grass to this island
			grass.setIsland(this);

			// add grass to list of geographical features and grass patches
			this.geographicalFeatures.add(grass);
			this.grassPatches.add(grass);
		}
	}

//	// randomly generate a specified number of animals
//	public void genAnimals(int numAnimals) {
//		
//		for (int i = 0; i < numAnimals; i++) {
//			
//			// randomly pick position. note that positions run from 0 to width - 1 and 0 to
//			// height - 1
//			int x = (int) (Math.random() * width);
//			int y = (int) (Math.random() * height);
//			
//			// check position is not already occupied and try again until one is found. or,
//			// give up after 20 tries
//			int count = 0;
//			while (isOccupied(x, y) || count > 20) {
//				x = (int) (Math.random() * width);
//				y = (int) (Math.random() * height);
//				count++;
//			}
//			
//			// randomly pick energy level from 5 through 30.
//			int energy = (int) (Math.random() * 25 + 5);
//			
//			animal = new Rabbit(x, y, energy);
//			
//			// add animal to this island's list of animals, and to animal's island attribute
//			this.animals.add(animal);
//			animal.setIsland(this);
//		}
//	}
	
	// randomly generate a specified number of rabbits
	public void genRabbits(int numRabbits) {

		for (int i = 0; i < numRabbits; i++) {

			// randomly pick position. note that positions run from 0 to width - 1 and 0 to height - 1
			int x = (int) (Math.random() * width);
			int y = (int) (Math.random() * height);

			// check position is not already occupied and try again until one is found. or, give up after 20 tries
			int count = 0;
			while (isOccupied(x, y) || count > 20) {
				x = (int) (Math.random() * width);
				y = (int) (Math.random() * height);
				count++;
			}

			// randomly pick energy level from 5 through 30.
			int energy = (int) (Math.random() * 25 + 5);

			Rabbit rabbit = new Rabbit(x, y, energy);

			// add rabbit to this island's list of rabbits, set rabbit's island to this island
			this.animals.add(rabbit);
			rabbit.setIsland(this);
		}
	}

	// print list of animals
	public void printAnimalInfo() {
		for (Animal a : this.animals) {
			System.out.println(a.toString());
		}
	}

	// print list of geographicalFeatures
	public void printGeographicalFeatureInfo() {
		for (GeographicalFeature p : this.geographicalFeatures) {
			System.out.println(p.toString());
		}
	}

	// print out text rendering of island including all animals at their locations as represented by their symbols.
	public void drawIsland() {

		// draw top border
		System.out.print('|');
		for (int i = 0; i < width; i++) {
			System.out.print('-');
		}
		System.out.println('|');

		// draw each row. using y as counter to match coordinate position
		for (int y = 0; y < height; y++) {

			// draw left border
			System.out.print('|');

			// iterate through the columns
			for (int x = 0; x < width; x++) {

				// flag whether this position is occupied
				boolean hasObject = false;

				// loop through all animals to check if position matches
				for (Animal b : this.animals) {

					// check if animal is in this position. at most one animal will be as we are
					// preventing multiple objects from occupying the same position
					if (b.getX() == x && b.getY() == y) {

						// set flag to true
						hasObject = true;

						// draw animal's symbol
						System.out.print(b.getSymbol());

						// break out of checking animals loop
						break;
					}
				}

				// if a animal is not in this position,
				if (!hasObject) {

					// loop through all geographicalFeatures to check if position matches
					for (GeographicalFeature p : this.geographicalFeatures) {

						// check if animal is in this position. at most one animal will be as we are
						// preventing multiple objects from occupying the same position
						if (p.getX() == x && p.getY() == y) {

							// set flag to true
							hasObject = true;

							// draw geographicalFeature's symbol
							System.out.print(p.getSymbol());

							// break out of checking geographical features loop
							break;
						}
					}
				}

				// if no animal or geographical feature was in this position, print an empty space
				if (!hasObject) {
					System.out.print(" ");
				}

			}

			// draw right border and move onto the next line
			System.out.printf("|%n");
		}

		// draw bottom border
		System.out.print('|');
		for (int i = 0; i < width; i++) {
			System.out.print('-');
		}
		System.out.println('|');

	}

	// randomly moves (or doesn't move) all the animals in the island. if a animal tries to move to a spot occupied by another animal, the move method will put it back in its original position and no move will occur.
	public void updateIsland() {

		// list of animals that die this turn
		ArrayList<Animal> deadAnimals = new ArrayList<Animal>();
		
		// loop over all animals
		for (Animal a : this.animals) {

			// check if the animal is on a patch of grass, and if its energy level is below 10.
			Grass grass = hasGrass(a.getX(), a.getY());
			
			// if so, have animal feed on the grass for this iteration
			if (grass != null && a.getEnergy() < 10) {
				grass.decreaseSize(4);
				a.increaseEnergy(10);
				
			} else {
				// otherwise, move the animal randomly. generate random number between 0 and 1 and attempt to move the animal in that direction.
				a.move(Math.random());
			}
			
			// reduce all animal's energy level by default amount
			a.decreaseEnergy();
			
			// if the animal's energy has reduced to 0, add to list of dead.
			if (a.getEnergy() == 0) {
				deadAnimals.add(a);
			}
		}
		
		// remove dead animals from island (no feeding on dead bodies here...)
		for (Animal d : deadAnimals) {
			this.animals.remove(d);
		}
		
		// list of plants to remove if they've been eaten away. just grass for now
		ArrayList<Grass> deadGrass = new ArrayList<Grass>();
		
		for (Grass g : grassPatches) {
			// check if any grass patches have had their size reduce to 0 from being eaten
			if (g.getSize() == 0) {
				deadGrass.add(g);
			} else {
				// otherwise, grow that grass
				g.increaseSize();
			}
		}
		
		// for testing purposes, show me the details of the rabbits and grasses:
//		printAnimalInfo();
//		printGeographicalFeatureInfo();
	}

	// run animation of island, updating and redrawing a specified number of times. update island with a thread sleep in between
	public void animateIsland(int numUpdates) {
		for (int i = 0; i < numUpdates; i++) {
			this.updateIsland();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.drawIsland();
		}
	}

	// Getters and Setters. Note no setter for animals arrayList but has addAnimal and removeAnimal methods instead

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public ArrayList<Animal> getAnimals() {
		return animals;
	}

	public void addAnimal(Animal animal) {
		// check incoming animal's position is not already occupied before adding to island
		if (!isOccupied(animal.getX(), animal.getY())) {
			this.animals.add(animal);
		}
	}

	public void removeAnimal(Animal animal) {
		this.animals.remove(animal);
	}

	public void reportNumAnimals() {
		// tally up the number of each surviving animal and print.
		int numRabbits = 0;
		for (Animal a : animals) {
			if (a instanceof Rabbit) {
				numRabbits++;
			}
		}
		System.out.println("There are " + numRabbits + " surviving rabbits.");
	}
}
