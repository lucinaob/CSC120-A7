import java.util.ArrayList;

import javax.management.RuntimeErrorException;

import java.lang.Math;

public class House extends Building {

  //Attributes of houses
  ArrayList<String> residents; //Array list of resident names
  public boolean hasDiningRoom; //Whether or not a house has a dining room
  public boolean hasElevator; //Whether or not a house has an elevator

  /**
   * House constructor
   * @param name - name of the house
   * @param address - address of the house
   * @param nFloors - floors the house
   * @param hasDiningRoom - whether or not the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors); //creating a house building
    this.hasDiningRoom = hasDiningRoom; 
    this.hasElevator = hasElevator;
    this.residents = new ArrayList<>();
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Overloading meethod allowing for up to 4 students to be on the roster automatically
   * @param name
   * @param address
   * @param nFloors
   * @param hasDiningRoom
   * @param hasElevator
   * @param studentOne
   * @param studentTwo
   * @param studentThree
   * @param studentFour
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator, String studentOne, String studentTwo, String studentThree, String studentFour){
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    this.residents = new ArrayList<>();
    residents.add(studentOne);
    residents.add(studentTwo);
    residents.add(studentThree);
    residents.add(studentFour);
  }

  /**
   * Overloaded constructor for House, using only name and address
   * @param name - name of the house
   * @param address - address of the house
   */
  public House(String name, String address){
    super(name, address); //creating a building using only the name and address
    //Super will default to 1 floor when none is given
    //Booleans default to false
    this.hasDiningRoom = false;
    this.hasElevator = false;
    this.residents = new ArrayList<>(); //residents in the house
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Method to move in a resident
   * @param s - student name
   */
  public void moveIn(String s){
    //If the person already is in the resident list,
    if (this.residents.contains(s)){
      //Print an error message
      System.out.println(s + " is already in " + this.name + ".");
    } else{ //If they do not live in the house,
      //Add the person to the list of residents
      this.residents.add(s);
      //Print a confirmation message
      System.out.println(s + " has moved into " + this.name + "!");
    }
  }

  /**
   * Method to move a student out 
   * @param s - student to move out
   */
  public void moveOut(String s){
    //If a student lives in the house, 
    if (this.residents.contains(s)){
      //Remove the student from the resident array list
      this.residents.remove(s);
      //Print an confirmation message
      System.out.println(s + " has moved out of " + this.name + ".");
    } else { //If they don't live in the house
      //Print error message
      System.out.println(s + " does not live in " + this.name + "and cannot be removed.");
    }
  }

  /**
   * Method to check if a student is a resident
   * @param s - student name
   * @return - true or false if the student is a resident of the house
   */
  public boolean isResident(String s){
    //If the student is a resident of the house,
    if (this.residents.contains(s)){
      //Print that they are a resident
      System.out.println(s + " is a resident of " + this.name + '.');
      return true;
    } else{ //If they are not,
      //Print that they are not a resident
      System.out.println(s + " is NOT a resident of " + this.name + '.');
      return false;
    }
  }

  /**
   * Getter to check if a house has a dining room
   * @return - boolean if a house has a dining room 
   */
  public boolean getHasDiningRoom(){
    //If a house has a dining room,
    if (this.hasDiningRoom){
      //Print that it has a dining room
      System.out.println(this.name + " has a dining room.");
    } else{ //If not,
      //Print that it does not have a dining room
      System.out.println(this.name + " does not have a dining room.");
    }
    //Return boolean
    return this.hasDiningRoom;
  }

  /**
   * Method to get the number of residents in a house
   * @return - int of the number of residents
   */
  public int nResidents(){
    //Print and return the number of residents
    System.out.println(this.name + " has " + this.residents.size() + " residents.");
    return this.residents.size();
  }

  /**
   * Overriding method to move up/down
   */
  @Override
  public void goToFloor(int floorNum) {
    //If not in building,
    if (this.activeFloor == -1) {
      //Display error message
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) { //If input is not a floor,
      //Display error message
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    //If floor is one above/below,
    if (Math.abs(this.activeFloor - floorNum) == 1){
      //Go to floor
      System.out.println("You are now on floor #" + floorNum + " of " + this.name + ".");
      this.activeFloor = floorNum;
    } else{ //If not,
      //and the building has an elevator... 
      if (this.hasElevator){
        //Use the elevator to go up/down
        System.out.println("Entering " + this.name + "'s elevator...");
        System.out.println("You are now on floor #" + floorNum + " of " + this.name + ".");
        this.activeFloor = floorNum;
      } else{ //If not,
        //Throw an exception
        throw new RuntimeException("Take the stairs!");
      }
    }
  }

    /**
     * Overriding method for showOptions() to show House-specific methods
     */
    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + moveIn()\n + moveOut()\n + isResident()\n + getDiningRoom()\n + nResidents()\n + showOptions()");
  }

  public static void main(String[] args) {
    House duckettHouse = new House("Duckett House", "41 Elm Street, Northampton, MA", 4, true, true); //Create a house
    System.out.println(duckettHouse); //Print information about Duckett House
    //Move in residents
    duckettHouse.moveIn("Lucy");
    duckettHouse.moveIn("Hala");
    duckettHouse.moveIn("Nellie");
    duckettHouse.moveIn("Becca");
    duckettHouse.moveIn("Amber");
    //Print number of residents
    duckettHouse.nResidents();
    //Print if Duckett has a dining room
    duckettHouse.getHasDiningRoom();
    //Check if Becca is a resident
    duckettHouse.isResident("Becca");
    //Move out Hala
    duckettHouse.moveOut("Hala");
    //Check number of residents
    duckettHouse.nResidents();
    //Check if Hala is a resident
    duckettHouse.isResident("Hala");
    duckettHouse.enter();
    duckettHouse.goToFloor(3);
    
  }

}