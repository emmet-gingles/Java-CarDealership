
package cardealership;


public class Car {

    public String colour;       // colour of car
    public String make;         // make of car
    public int mileage;         // mileage of car
    
    // constructor that sets the initial values for class variables
    public Car(){
        this.colour = "";
        this.make = "";
        this.mileage = 0;
    }
    
    // function that returns the colour
    public String getColour(){
        return this.colour;
    }
    
    // function that returns the make
    public String getMake(){
        return this.make;
    }
    
    // function that returns the mileage
    public int getMileage(){
        return this.mileage;
    }
    
    // function that sets the colour
    public void setColour(String colour){
        this.colour = colour;
    }
    
    // function that sets the make
    public void setMake(String make){
        this.make = make;
    }
    
    // function that sets the mileage
    public void setMileage(int mileage){
        this.mileage = mileage;
    }
    
    // function that paints the car a new colour
    public void paint(String colour){
        this.colour = colour;
    }
    
    // function that increases the mileage by a distance
    public void drive(int distance){
        this.mileage = this.mileage + distance;
    }
    
    // called only when file is run
    public static void main(String args[]){
        // here we create an instance of Car() and call its various functions to see how its variables change
        Car car = new Car();
        car.setColour("red");
        car.setMake("BMW");
        car.setMileage(10000);
        System.out.println(car.getColour());
        System.out.println(car.getMake());
        System.out.println(car.getMileage());
        car.paint("blue");
        System.out.println(car.getColour());
        car.drive(500);
        System.out.println(car.getMileage());       
    }
}


