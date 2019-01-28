import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import cardealership.*;         // import all classes from package

// class to test the Dealership class
public class TestDealership {

    // instance of Dealership class
    Dealership dealer;

    // create new Dealership object before each test 
    @Before
    public void setUp() throws Exception {
        this.dealer = new Dealership();
    }
    
    // test that checks the total number of cars is correct
    @Test
    public void testTotalCars(){
        assertEquals(40, this.dealer.getTotalCars());
    }
    
    // test that checks the total number of cars is correct for each type
    @Test
    public void testTotalCarsByType(){
        assertEquals(24, this.dealer.getTotalCarsByType("Petrol"));
        assertEquals(8, this.dealer.getTotalCarsByType("Diesel"));
        assertEquals(4, this.dealer.getTotalCarsByType("Electric"));
        assertEquals(4, this.dealer.getTotalCarsByType("Hybrid"));
    }
    
    // test that check that the array of car makes returned by function is correct
    @Test
    public void testMakes(){
        assertArrayEquals(new String[]{"BMW", "Toyota", "Ford", "Hyundai", "Audi", "Mercedes"}, this.dealer.getMakes());
    }
    
    // test that checks that the array of colours returned by function is correct
    @Test
    public void testColours(){
        assertArrayEquals(new String[]{"blue", "red", "yellow", "grey", "black", "green"}, this.dealer.getColours());
    }
    
    // function that checks that function returns a Petrol Car and then tests its class functions
    @Test
    public void testPetrolCar(){
        PetrolCar car = (PetrolCar) this.dealer.getCar("Petrol");
        car.setMake("Toyota");
        car.setColour("red");       
        assertEquals("Toyota", car.getMake());
        assertEquals("red", car.getColour());
        assertEquals(0, car.getMileage());
        assertEquals(1, car.getNumCylinders());
    }
    
    // function that checks that function returns a Diesel Car and then tests its class functions
    @Test
    public void testDieselCar(){
        DieselCar car = (DieselCar) this.dealer.getCar("Diesel");
        car.setMake("Toyota");
        car.setColour("red");       
        assertEquals("Toyota", car.getMake());
        assertEquals("red", car.getColour());
        assertEquals(0, car.getMileage());
        assertEquals(1, car.getNumCylinders());
    }
    
    // function that checks that function returns a Electric Car and then tests its class functions
    @Test
    public void testElectricCar(){
        ElectricCar car = (ElectricCar) this.dealer.getCar("Electric");
        car.setMake("Toyota");
        car.setColour("red");       
        assertEquals("Toyota", car.getMake());
        assertEquals("red", car.getColour());
        assertEquals(0, car.getMileage());
        assertEquals(1, car.getNumFuelCells());
    }
    
    // function that checks that function returns a Hybrid Car and then tests its class functions
    @Test
    public void testHybridCar(){
        HybridCar car = (HybridCar) this.dealer.getCar("Hybrid");
        car.setMake("Toyota");
        car.setColour("red");       
        assertEquals("Toyota", car.getMake());
        assertEquals("red", car.getColour());
        assertEquals(0, car.getMileage());
        assertEquals(1, car.getNumCylinders());
        assertEquals(1, car.getNumFuelCells());
    }
    
    // function that test the rentCar function for both in stock and out of stock
    @Test
    public void testRentCar(){
        assertTrue(this.dealer.rentCar(1, "Diesel"));
        assertEquals(7, this.dealer.getTotalCarsByType("Diesel"));
        this.dealer.rentCar(2, "Electric");
        this.dealer.rentCar(2, "Electric");
        assertEquals(0, this.dealer.getTotalCarsByType("Electric"));
        assertFalse(this.dealer.rentCar(1, "Electric"));
        assertEquals(0, this.dealer.getTotalCarsByType("Electric"));
    }
    
    // function that tests the returnCar function for both on rental and not on rental
    @Test
    public void testReturnCar(){
        assertEquals("No Petrol cars currently out on rental", this.dealer.returnCar("Petrol"));
        this.dealer.rentCar(1, "Petrol");
        assertEquals(23, this.dealer.getTotalCarsByType("Petrol"));
        assertEquals("Petrol car returned", this.dealer.returnCar("Petrol"));
        assertEquals(24, this.dealer.getTotalCarsByType("Petrol"));
    }
}

