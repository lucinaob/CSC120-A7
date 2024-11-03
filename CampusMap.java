import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        //Creating a campus map
        CampusMap myMap = new CampusMap();
        //Creating various houses and buildings
        House duckettHouse = new House("Duckett House", "41 Elm Street, Northampton, MA", 4, true, true);
        myMap.addBuilding(duckettHouse);
        //Cromwell A is built with a new overloaded method, including students' names
        myMap.addBuilding(new House("Cromwell A", "73 Paradise Road, Northampton, MA", 1, false, false, "Sydney", "Talia", "Veta", "Tucker"));
        //Gardiner is built with a new overloaded method, with no floors specified
        myMap.addBuilding(new House("Gardiner House", "1 Paradise Road, Northampton, MA"));
        myMap.addBuilding(new Building("Seelye Hall", "2 Seelye Drive, Northampton, MA"));
        myMap.addBuilding(new Building("Dewey Hall", "4 Neilson Drive, Northampton, MA"));
        Library neilsonLibrary = new Library("Neilson Library", "7 Neilson Drive, Northampton, MA", 4);
        myMap.addBuilding(neilsonLibrary);
        myMap.addBuilding(new Library("Hillyer Library", "22 Elm Street, Northampton, MA", 2));
        //Josten is built with an overloaded method that doesn't require nFloors
        myMap.addBuilding(new Library("Josten Library", "122 Green Street, Northampton, MA"));
        //The CC is built with an overloaded method that specifies inventory levels
        myMap.addBuilding(new Cafe("Campus Center Cafe", "100 Elm Street, Northampton, MA", 3, 25, 20, 20, 30));
        Cafe compassCafe = new Cafe("Compass Cafe", "7 Neilson Drive, Northampton, MA", 1);
        myMap.addBuilding(compassCafe);
        System.out.println(myMap);
        //Entering Duckett
        duckettHouse.enter();
        //Overriding method showing House class options
        duckettHouse.showOptions();
        //Using elevator to go to the 3rd floor
        duckettHouse.goToFloor(3);
        //Going down stairs
        duckettHouse.goDown();
        duckettHouse.goDown();
        //Exit house
        duckettHouse.exit();
        //Enter library
        neilsonLibrary.enter();
        //Show library class options
        neilsonLibrary.showOptions();
        //Use elevator to go to 4th floor
        neilsonLibrary.goToFloor(4);
        //Add books to the collection, print collection
        neilsonLibrary.addTitle("Confederates in the Attic by Tony Horowitz");
        neilsonLibrary.addTitle("Invisible Hands by Kim Phillips-Fein");
        neilsonLibrary.printCollection();
        //Check out book
        neilsonLibrary.checkOut("Confederates in the Attic by Tony Horowitz");
        //Print collection using overloaded method to show avaliability
        neilsonLibrary.printCollection(true);
        //Go down using the elevator
        neilsonLibrary.goToFloor(1);
        //Exit library
        neilsonLibrary.exit();
        //Enter cafe
        compassCafe.enter();
        //Show Cafe class options
        compassCafe.showOptions();
        //Print compass inventory
        compassCafe.printInventory();
        //Use overloaded restock method
        compassCafe.restock(20, 18, 18, 20);
        //Print invetnory again to confirm restock
        compassCafe.printInventory();
        
    }
    
}
