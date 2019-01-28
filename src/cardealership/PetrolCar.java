
package cardealership;

// inherits functions and variables from Car() class
public class PetrolCar extends Car {
    
    public int numCylinders;        // number of cylinders in car
    
    // constructor that sets the initial value for class variable
    public PetrolCar(){
        this.numCylinders = 1;
    }
    
    // function that returns the number of cylinders
    public int getNumCylinders(){
        return this.numCylinders;
    }
    
    // function that sets the number of cylindes
    public void setNumCylinders(int numCylinders){
        this.numCylinders = numCylinders;
    }
    
    // called only when file is run
    public static void main(String args[]){
        // here we create an instance of PetrolCar() and call its various functions to see how its variables change
        PetrolCar car = new PetrolCar();
        car.setColour("red");
        car.setMake("BMW");
        car.setMileage(10000);
        System.out.println(car.getColour());
        System.out.println(car.getMake());
        System.out.println(car.getMileage());
        System.out.println(car.getNumCylinders());
        car.setNumCylinders(2);
        System.out.println(car.getNumCylinders());
    }
}
