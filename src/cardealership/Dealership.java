
package cardealership;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dealership {
    // a hashmap to store the number of each car available for rent
    Map<String, Integer> cars_for_rent = new HashMap<>();
    // a hashmap to store the number of each car currently on rent
    Map<String, Integer> cars_on_rent = new HashMap<>();
    // array of car makes
    String[] makes = new String[]{"BMW", "Toyota", "Ford", "Hyundai", "Audi", "Mercedes"};
    // array of car colours
    String[] colours = new String[]{"blue", "red", "yellow", "grey", "black", "green"};
    
    public Dealership(){
        // populate the hashmap with the numbers for each car
        this.cars_for_rent.put("Petrol", 24);
        this.cars_for_rent.put("Diesel", 8);
        this.cars_for_rent.put("Electric", 4);
        this.cars_for_rent.put("Hybrid", 4);
        
        // poplate the hashmap with the default value of zero for each car
        this.cars_on_rent.put("Petrol", 0);
        this.cars_on_rent.put("Diesel", 0);
        this.cars_on_rent.put("Electric", 0);
        this.cars_on_rent.put("Hybrid", 0);
    }
    
    // function to return the total number of cars for rent
    public int getTotalCars(){
        return cars_for_rent.get("Petrol") + cars_for_rent.get("Diesel") +
                cars_for_rent.get("Electric") + cars_for_rent.get("Hybrid");
    }
    
    // function to return the total number of cars for rent, for a car type 
    public int getTotalCarsByType(String carType){
        return cars_for_rent.get(carType);
    }
    
    // function that returns an array of car makes
    public String[] getMakes(){
        return this.makes;
    }
    
    // function that returns an array of colours
    public String[] getColours(){
        return this.colours;
    }
    
    // function that return a carType depending on the input parameter
    public Car getCar(String carType){
        switch (carType) {
            case "Petrol":
                return new PetrolCar();
            case "Diesel":
                return new DieselCar();
            case "Electric":
                return new ElectricCar();
            default:
                return new HybridCar();
        }
    }
    
    // function that returns that checks whether or not a car can be rented
    public boolean rentCar(int numCars, String carType){
        // boolean that determines the return value of function
        boolean rent = true;
        // switch statement that check that there are enough cars of the input cartype to satisfy the rent
        switch (carType) {
            case "Petrol":
                // calls the function to check the total Petrol cars, if numCars is greater then function returns false
                if(numCars > this.getTotalCarsByType("Petrol")){
                    System.out.println("Not enough cars available");
                    rent = false;
                }
                // otherwise there are enough Petrol cars so update the value of the key in both hashmaps
                else{
                    this.cars_on_rent.put("Petrol", cars_on_rent.get("Petrol") + numCars);
                    this.cars_for_rent.put("Petrol", this.cars_for_rent.get("Petrol") - numCars);
                }   
                break;
            case "Diesel":
                if(numCars > this.getTotalCarsByType("Diesel")){
                    System.out.println("Not enough cars available");
                    rent = false;
                }
                else{
                    this.cars_on_rent.put("Diesel", cars_on_rent.get("Diesel") + numCars);
                    this.cars_for_rent.put("Diesel", this.cars_for_rent.get("Diesel") - numCars);
                }   
                break;
            case "Electric":
                if(numCars > this.getTotalCarsByType("Electric")){
                    System.out.println("Not enough cars available");
                    rent = false;
                }
                else{
                    this.cars_on_rent.put("Electric", cars_on_rent.get("Electric") + numCars);
                    this.cars_for_rent.put("Electric", this.cars_for_rent.get("Electric") - numCars);
                }   
                break;
            default:
                if(numCars > this.getTotalCarsByType("Hybrid")){
                    System.out.println("Not enough cars available");
                    rent = false;
                }
                else{
                    this.cars_on_rent.put("Hybrid", cars_on_rent.get("Hybrid") + numCars);
                    this.cars_for_rent.put("Hybrid", this.cars_for_rent.get("Hybrid") - numCars);
                }   
                break;
        }
        // return boolean
        return rent;
    }
    
    // function that returns a rented car
    public String returnCar(String carType){
        // check the value of the key on the hashmap, if greater than zero then update the value of the key in both hashmaps
        if(this.cars_on_rent.get(carType) > 0){
            this.cars_on_rent.put(carType, this.cars_on_rent.get(carType) - 1);
            this.cars_for_rent.put(carType, this.cars_for_rent.get(carType) + 1);
            // message output to user telling them car has been returned
            return carType + " car returned";
        }
        // else no cars of that type are out on rental so inform the user
        else{
            return "No " + carType + " cars currently out on rental";
        }
    }
  
    // called only when file is run
    public static void main(String args[]){
        // create instance of Dealership class
        Dealership dealer = new Dealership();
        // instance of Scanner, used for reading user input
        Scanner sc = new Scanner(System.in);
        // continuous loop unless it encounters a break
        while (true){
            System.out.println("Would you like to rent a car? Y/N");
            // read in user input and convert to upper case
            String response = sc.next().toUpperCase();
            // if input is "Y" or "YES" then proceed
            if(response.equals("Y") || response.equals("YES")){
                // call function to return the total number of cars
                int cars_available = dealer.getTotalCars();
                System.out.println(cars_available + " cars available for rent");
                // if cars are available 
                if(cars_available > 0){
                    String carType;     // the type of car selected
                    int numCars;        // the number of cars avialble for that type
                    OUTER:              // used for breaking out of while loop from within switch statement
                    while (true) {
                        System.out.println("What type of engine? " + "\n" + "1. Petrol " + "\n" + "2. Diesel " +
                                "\n" + "3. Electric " + "\n" + "4. Hybrid ");
                        try {
                            int option = Integer.parseInt(sc.next());
                            // depending on the input, use switch to check stock
                            switch (option) {
                                case 1:
                                    // get the number of Petrol cars
                                    numCars = dealer.getTotalCarsByType("Petrol");
                                    // if number is greater than zero then set the carType
                                    if (numCars > 0) {
                                        System.out.println("We have " + numCars + " Petrol cars avialable");
                                        carType = "Petrol";
                                        // break out of loop, not switch
                                        break OUTER;
                                    } else {
                                        System.out.println("Sorry no Petrol cars available");
                                    }
                                    // break out of switch
                                    break;
                                case 2:
                                    numCars = dealer.getTotalCarsByType("Diesel");
                                    if (numCars > 0) {
                                        System.out.println("We have " + numCars + " Diesel cars avialable");
                                        carType = "Diesel";
                                        break OUTER;
                                    } else {
                                        System.out.println("Sorry no Diesel cars available");
                                    }
                                    break;
                                case 3:
                                    numCars = dealer.getTotalCarsByType("Electric");
                                    if (numCars > 0) {
                                        System.out.println("We have " + numCars + " Electric cars avialable");
                                        carType = "Electric";
                                        break OUTER;
                                    } else {
                                        System.out.println("Sorry no Electric cars available");
                                    }
                                    break;
                                case 4:
                                    numCars = dealer.getTotalCarsByType("Hybrid");
                                    if (numCars > 0) {
                                        System.out.println("We have " + numCars + " Hybrids cars avialable");
                                        carType = "Hybrid";
                                        break OUTER;
                                    } else {
                                        System.out.println("Sorry no Hybrid cars available");
                                    }
                                    break;
                                default:
                                    System.out.println("Please enter a number between 1 and 4");
                                    break;
                            }
                        }
                        catch(Exception e){
                            System.out.println("Non-numeric input");                          
                        }
                    }   // end while
                    
                    // call function to create an instance of the carType
                    Car car = dealer.getCar(carType);
                    // continue looping until break
                    while(true){
                        // inside this loop we set the car make
                        System.out.println("What make of car would you like?");
                        // call function to get an array of car makes
                        String[] makes = dealer.getMakes();
                        // loop through array and display each car make
                        for(int i=0;i< makes.length;i++){
                            // array is zero based but we want to show option numbers starting from 1
                            int next = i+1;
                            System.out.println(next + ". " + makes[i]);
                        }
                        // use try/catch to parse input to an integer
                        try{
                            int option = Integer.parseInt(sc.next());
                            // check that number is between 1 and the length of array
                            if(option > 0 && option <= makes.length){
                                // get the value of the array index
                                String make = makes[option-1];
                                System.out.println("You have selected " + make);
                                // call function to set the make of the car
                                car.setMake(make);
                                // break out of loop
                                break;
                            }
                            // else number is outside range so inform user
                            else{
                                System.out.println("Please enter a number between 1 and " + makes.length);
                            }
                        }
                        catch(Exception e){
                            System.out.println("");
                        }
                    }   // end while
                    
                    // continue looping until break
                    while(true){
                        // inside this loop we set the colour of the car
                        System.out.println("What colour would you like?");
                        // call function to get an array of colours
                        String[] colours = dealer.getColours();
                        // loop through array and display each colour
                        for(int i=0;i< colours.length;i++){
                            // array is zero based but we want to show option numbers starting from 1
                            int next = i+1;
                            System.out.println(next + ". " + colours[i]);
                        }
                        // use try/catch to parse input to an integer
                        try{
                            int option = Integer.parseInt(sc.next());
                            // check that number is between 1 and the length of the array
                            if(option > 0 && option <= colours.length){
                                // get the value of the array index
                                String colour = colours[option-1];
                                System.out.println("You have selected " + colour);
                                // call function to set the colour of the car
                                car.setColour(colour);
                                // break out of loop
                                break;
                            }
                            // else number is outside the range so inform user
                            else{
                                System.out.println("Please enter a number between 1 and " + colours.length);
                            }
                        }
                        catch(Exception e){
                            System.out.println("");
                        }
                    }   // end while
                   
                    // contine looping until break
                    while(true){
                        // in this loop we set the number of cars
                        System.out.println("Available: " + numCars);
                        System.out.println("How many would you like?");
                        // use try/catch to parse input to integer
                        try{
                            int amount = Integer.parseInt(sc.next());
                            // check that it is greater than zero then proceed
                            if(amount > 0){
                                // call function to rent car passing the car type and the amount
                                if(dealer.rentCar(amount, carType)){
                                    // output message to user with details of the car
                                    if(amount == 1){
                                        System.out.println("You have rented a " + car.getColour() + " " + 
                                                car.getMake() + " with a " + carType + " engine");
                                    }
                                    else{
                                        System.out.println("You have rented " + amount + " " + 
                                                car.getColour() + " " + car.getMake() + " with " + carType + " engines");
                                    }
                                    // break out of loop
                                    break;
                                }                               
                            }   // end if
                            // else number is less than 1 so inform user
                            else{
                                System.out.println("Amount must be greater than zero");
                            }
                        }   
                        catch(Exception e){
                            System.out.println("Please enter a number");
                        }
                    }   // end while
                    
                }   // end if cars available
                // else no cars are available 
                else{
                    System.out.println("Out of stock, come back later");
                    break;
                }
            }   // end if response equals "Yes"
            
            // else if input is "N" or "NO"
            else if(response.equals("N") || response.equals("NO")){
                // continue looping until break
                while(true){                   
                    System.out.println("Would you like to return a car? Y/N");
                    // read in user input and convert to upper case
                    response = sc.next().toUpperCase();
                    // if input is "Y" or "YES" then process
                    if(response.equals("Y") || response.equals("YES")){
                        // menu displayed to user
                        System.out.println("What type of car are you returning? " + "\n" + "1. Petrol " + "\n" + "2. Diesel " +
                            "\n" + "3. Electric " + "\n" + "4. Hybrid "); 
                        // use try/catch to parse input to integer
                        try{
                            int option = Integer.parseInt(sc.next());
                            // switch statement to determine the type of car
                            // for each case call the returnCar function with the appropriate carType
                            switch (option) {
                                case 1:
                                    // System.out.println("Returning Petrol car");
                                    System.out.println(dealer.returnCar("Petrol"));
                                    break;
                                case 2:
                                    // System.out.println("Returning Diesel car");
                                    System.out.println(dealer.returnCar("Diesel"));
                                    break;
                                case 3:
                                    // System.out.println("Returning Electric car");
                                    System.out.println(dealer.returnCar("Electric"));
                                    break;
                                case 4:
                                    // System.out.println("Returning Hybrid car");
                                    System.out.println(dealer.returnCar("Hybrid"));
                                    break;
                                default:
                                    System.out.println("Please enter a number between 1 and 4");
                                    break;
                            }   // end switch
                            
                        } 
                        catch(Exception e){
                            System.out.println("Non-numeric input");
                        }
                    }   // end if 
                    
                    // else if input is "N" or "NO", exit the loop
                    else if(response.equals("N") || response.equals("NO")){                      
                        break;
                    }
                }   // end while
                
                System.out.println("Do you require additional services? Y/N");
                response = sc.next().toUpperCase();
                // if input is "N" or "NO" then exit loop and terminate program
                if(response.equals("N") || response.equals("NO")){
                    System.out.println("Goodbye");
                    break;
                }   
            }   // end if
            
        }   // end outer while
        
        // close scanner
        sc.close();
        
    }   // end main   
    
}   // end Dealership class
