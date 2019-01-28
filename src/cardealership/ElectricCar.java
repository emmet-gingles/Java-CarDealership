
package cardealership;

// inherits functions and variables from Car() class
public class ElectricCar extends Car{
    
    public int numFuelCells;        // number of fuel cells in car
    
    // constructor that sets the initial value for class variable
    public ElectricCar(){
        this.numFuelCells = 1;
    }
    
    // function that returns the number of fuel cells
    public int getNumFuelCells(){
        return this.numFuelCells;
    }
    
    // function that sets the number of fuel cells
    public void setNumFuelCells(int numFuelCells){
        this.numFuelCells = numFuelCells;
    }
    
    // called only when file is run
    public static void main(String args[]){
        // here we create an instance of ElectricCar() and call its various functions to see how its variables change
        ElectricCar car = new ElectricCar();
        car.setColour("red");
        car.setMake("BMW");
        car.setMileage(10000);
        System.out.println(car.getColour());
        System.out.println(car.getMake());
        System.out.println(car.getMileage());
        System.out.println(car.getNumFuelCells());
        car.setNumFuelCells(2);
        System.out.println(car.getNumFuelCells());
    }
}
