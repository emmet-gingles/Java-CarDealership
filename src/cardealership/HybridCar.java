
package cardealership;

// inherits functions and variables from Car() class
public class HybridCar extends Car {
    
    public int numFuelCells;        // number of fuel cells in car
    public int numCylinders;        // number of cylinders in car
    
    // constructor that sets the initial values for class variables
    public HybridCar(){
        this.numFuelCells = 1;
        this.numCylinders = 1;
    }
    
    // function that returns the number of fuel cells
    public int getNumFuelCells(){
        return this.numFuelCells;
    }
    
    // function that returns the number of cylinders
    public int getNumCylinders(){
        return this.numCylinders;
    }
    
    // function that sets the number of fuel cells
    public void setNumFuelCells(int numFuelCells){
        this.numFuelCells = numFuelCells;
    }
    
    // function that sets the number of cylinders
    public void setNumCylinders(int numCylinders){
        this.numCylinders = numCylinders;
    }
    
    // called only when file is run
    public static void main(String args[]){
        // here we create an instance of HybridCar() and call its various functions to see how its variables change
        HybridCar car = new HybridCar();
        car.setColour("red");
        car.setMake("BMW");
        car.setMileage(10000);
        System.out.println(car.getColour());
        System.out.println(car.getMake());
        System.out.println(car.getMileage());
        System.out.println("fuel cells " + car.getNumFuelCells());
        System.out.println("cylinders " + car.getNumCylinders());
        car.setNumFuelCells(2);
        System.out.println("fuel cells " + car.getNumFuelCells());
        car.setNumCylinders(2);
        System.out.println("cylinders " + car.getNumCylinders());
        
    }
}
