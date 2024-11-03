/* This is a stub for the Library class */

import java.util.Enumeration;
import java.util.Hashtable;

public class Library extends Building {

  //Unique attributes of a library
  private Hashtable<String, Boolean> collection; //Collection hashtable

  //Library constructor
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors); //Create a building 
    this.collection = new Hashtable<>(); //Creates collection
    System.out.println("You have built a library: 📖");
  }

  /**
   * Overloading constructor if no floors are given
   * @param name - Name of the library
   * @param address - Address of the library
   */
  public Library(String name, String address){
    super(name, address); //Constructor, sets nfloors = 1 by default
    this.collection = new Hashtable<>(); //Creates collection
    System.out.println("You have built a library: 📖");
  }

  /**
   * Method to add a title
   * @param title - The book being added to the collection
   */
  public void addTitle(String title){
    //If the book is already in the collection,
    if (containsTitle(title)){
      //Print that the book is already in the collection
      System.out.println(title + " is already in the collection and cannot be added.");
    } else{ //If the book isn't,
      //Add it to the Hashtable and print a confirmation method
      collection.put(title, true);
      System.out.println(title + " has been added to the collection!");
    }
  }

  /**
   * Method to remove a title
   * @param title - the book to be removed
   */
  public void removeTitle(String title){
    //If the collection contains the title,
    if (containsTitle(title)){
      //Remove the title and print confirmation
      collection.remove(title);
      System.out.println(title + " has been removed from the collection.");
    } else{ //If the title is not in the collection,
      //Print an error message
      System.out.println(title + " is not in the collection and cannot be removed.");
    }
  }

  /**
   * Method to check out a book
   * @param title - title of the book to be checked out
   */
  public void checkOut(String title){
    //If the book is in the collection,
    if (containsTitle(title)){
      //Check if the book is avaliable
      if (isAvaliable(title)){
        //Change boolean of avaliability from true to false
        collection.replace(title, true, false);
        System.out.println(title + " has been checked out.");
      } else{ //If book is not avaliable
        //Print error message
        System.out.println(title + " is currently checked out.");
      }
    } else{ //If book is not in collection
      //Print error message
      System.out.println(title + " is not in the collection, and cannot be checked out.");
    }
  }

  /**
   * Method to return a book
   * @param title - title of the book to be returned
   */
  public void returnBook(String title){
    //If book is in the collection,
    if (containsTitle(title)){
      //Check if book is checked out
      if (!isAvaliable(title)){ //If it is
        //Change boolean of avaliability from false to true
        collection.replace(title, false, true);
        //Print confirmation method
        System.out.println(title + " has been checked in.");
      } else { //If book is not checked out
        //Print error message
        System.out.println(title + " was not checked out and cannot be checked back in.");
      } } else { //If book is not in collection
        //Print error message
        System.out.println(title + " is not in the collection and cannot be returned.");
    }
  }

  /**
   * Overriding method for the goToFloor() method
   */
  @Override
    public void goToFloor(int floorNum) {
      //If not in building,
      if (this.activeFloor == -1) {
          //Display error message
          throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
      }
      if (floorNum < 1 || floorNum > this.nFloors) { //If input is out of floor range
        //Display error message
          throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
      }
      //If inputted floor number is more than 1 away from the current floor number,
      if (Math.abs(this.activeFloor - floorNum) > 1){
        //Move up/down using the elevator
        System.out.println("You are now entering the " + this.name + " elevator...");
      } else{ //If not,
        //Use the stairs
        System.out.println("You are now entering the " + this.name + " stairwell...");
      }
      //Display new floor number and store it
      System.out.println("You are now on floor #" + floorNum + " of " + this.name + ".");
      this.activeFloor = floorNum;
    }

  /**
   * Method to check if book is in collection
   * @param title - title of book
   * @return - boolean indicating if book is in the collection
   */
  public boolean containsTitle(String title){
    return collection.containsKey(title);
  }

  /**
   * Method to check if book is avaliable
   * @param title - title of book
   * @return - boolean indicating if book is avaliable
   */
  public boolean isAvaliable(String title){
    //Check value of Hashtable for given key (title)
    return this.collection.get(title).booleanValue();
  }

  /**
   * Overloading method to show avaliability books when collection is printed
   * @param showAvaliability 
   */
  public void printCollection(boolean showAvaliability){
    //Print buffer line
    System.out.println("");
    //Print title of collection
    System.out.println(name.toUpperCase() + "'S COLLECTION: ");
    //Create enumeration of keys in the hashtable
    Enumeration<String> collectionList = collection.keys();
    if (collection.isEmpty()){ //Print message if collection is empty
        System.out.println("There are no books in the collection");
    } else{
        int i = 0;
        String status;
        while(collectionList.hasMoreElements()) { //For each item in the hashtable collection
          i += 1;
          String element = collectionList.nextElement();
          if(isAvaliable(element)){
            status = " (avaliable)";
          } else{
            status = " (checked out)";
          }
          System.out.println(i + ". " + element + status); //print the book key
      } 
    }
    System.out.println(""); //Print buffer line
  }

  /**
   * Method to print the library's collection
   */
  public void printCollection(){
    //Print buffer line
    System.out.println("");
    //Print title of collection
    System.out.println(name.toUpperCase() + "'S COLLECTION: ");
    //Create enumeration of keys in the hashtable
    Enumeration<String> collectionList = collection.keys();
    if (collection.isEmpty()){ //Print message if collection is empty
        System.out.println("There are no books in the collection");
    } else{
        int i = 0;
        while(collectionList.hasMoreElements()) { //For each item in the hashtable collection
          i += 1;
          System.out.println(i + ". " + collectionList.nextElement()); //print the book key
      } 
    }
    System.out.println(""); //Print buffer line
  }

  //Overriding method with library options
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + addTitle()\n + removeTitle()\n + checkOut()\n + returnBook()\n + containsTitle()\n + isAvaliable()\n + printCollection()\n + showOptions()");
  }


  public static void main(String[] args) {
    Library neilson = new Library("Neilson Library", "7 Neilson Drive, Northampton, MA", 5);
    neilson.addTitle("Free Food for Millionaires by Min Jin Lee");
    neilson.addTitle("Science Studies During the Cold War and Beyond by Elena Aronova");
    neilson.addTitle("Stone Fruit by Lee Lai");
    neilson.addTitle("The Cholera Years by Charles Rosenberg");
    neilson.addTitle("White Horizon by Jen Hill");
    neilson.printCollection();
    neilson.checkOut("Station Eleven by Emily St. John Mandel");
    neilson.checkOut("Stone Fruit by Lee Lai");
    neilson.removeTitle("The Cholera Years by Charles Rosenberg");
    neilson.printCollection(true);
    neilson.showOptions();
  }
  
  }