/* This is a stub for the Cafe class */
public class Cafe extends Building {

    //Unique attributes of a cafe
    //Items in a cafe's inventory (coffee grounds, sugar, cream, cups)
    private int nCoffeeOunces; 
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Constructor of a cafe building
     * @param name - name of the cafe
     * @param address - address of the cafe
     * @param nFloors - floors the building has
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors); //Create a cafe building
        //Initialize the cafe inventory
        this.nCoffeeOunces = 10;
        this.nSugarPackets = 8;
        this.nCreams = 10;
        this.nCups = 12;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Overloaded constructor, allowing specific amounts of different materials
     * @param name - name of cafe
     * @param address - address of cafe
     * @param nFloors - floors of the cafe
     * @param nCoffeeOunces - amt of coffee
     * @param nSugarPackets - # of sugar packets
     * @param nCreams - # of creams
     * @param nCups - # of cups
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /**
     * Method to sell coffee
     * @param size - Size of the coffee being sold
     * @param nSugarPackets - Sugars in the coffee being sold
     * @param nCreams - Creams in the coffee being sold
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        //If there isn't enough coffee, sugar, or cream to make the coffee bought,
        if (nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams){
            //Restock the cafe
            this.restock();
            System.out.println("Restocking inventory...");
            //Re-run sell coffee with the same information
            this.sellCoffee(size, nSugarPackets, nCreams);
        } else{ //If there is enough material to make the coffee,
            //Decrease the coffee, sugar, and cream by the amount ordered
            nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            //Remove 1 cup
            this.nCups -= 1;
            System.out.println("One size " + size + " coffee with " + nSugarPackets + " sugar(s) and " + nCreams + " cream(s) sold!");
        }
    }
    
    /**
     * Restock inventory method
     */
    private void restock(){
        //Bring levels of attributes back to default levels
        this.nCoffeeOunces = 10;
        this.nSugarPackets = 8;
        this.nCreams = 10;
        this.nCups = 12;
    }

    /**
     * Overloading method restocking the Cafe to custom levels
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    public void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        System.out.println("Restocking " + this.name + "...");
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /**
     * Print inventory of the cafe
     */
    public void printInventory(){
        //Buffer line
        System.out.println("");
        //Print name of cafe
        System.out.println(name.toUpperCase() + " INVENTORY: ");
        //Print attributes/materials of the cafe
        System.out.println("Coffee Ounces: " + nCoffeeOunces);
        System.out.println("Sugar Packets: " + nSugarPackets);
        System.out.println("Creams: " + nCreams);
        System.out.println("Cups: " + nCups);
        //Buffer line
        System.out.println("");
    }

    //Overriding method showing Cafe class options
    public void showOptions(){
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee()\n + restock()\n + printInventory()\n + showOptions");
    }

    //Overriding method disallowing movement off the first floor of a cafe
    public void goToFloor(int floorNum){
        throw new RuntimeException("Employees only!");
    }

    public static void main(String[] args) {
        Cafe campusCenter = new Cafe("Campus Center Cafe", "100 Elm Street, Northampton, MA", 3);
        campusCenter.sellCoffee(3, 2, 3);
        campusCenter.sellCoffee(2, 4, 4);
        campusCenter.printInventory();
        campusCenter.sellCoffee(3, 0, 1);
        campusCenter.sellCoffee(2, 1, 3);
        campusCenter.printInventory();
        Cafe compassCafe = new Cafe("Compass Cafe", "1 Neilson Drive", 1, 20, 15, 15, 20);
        System.out.println(compassCafe);
        campusCenter.showOptions();
    }
    
}
