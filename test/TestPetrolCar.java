import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import cardealership.PetrolCar;         // import class

// class to test the PetrolCar class
public class TestPetrolCar {

    // instance of PetrolCar class
    PetrolCar car;
    
    // create new PetrolCar instance before each test
    @Before
    public void setUp() throws Exception {
        this.car = new PetrolCar();
    }
    
    // function that tests the colour of the car
    @Test
    public void testColour(){
        this.car.setColour("red");
        assertEquals("red", this.car.getColour());
    }
    
    // function that tests the make of the car
    @Test 
    public void testMake(){
        this.car.setMake("BMW");
        assertEquals("BMW", this.car.getMake());
    }
    
    // function that tests the mileage of the car
    @Test 
    public void testMileage(){
        this.car.setMileage(10000);
        assertEquals(10000, this.car.getMileage());
    }
    
    // function that tests the paint function to check that it changes the colour
    @Test 
    public void testPaint(){
        this.car.paint("blue");
        assertEquals("blue", this.car.getColour());
    }
    
    // function that tests the drive function to check that it changes the mileage
    @Test 
    public void testDrive(){
        this.car.drive(500);
        assertEquals(500, this.car.getMileage());
        this.car.drive(500);
        assertEquals(1000, this.car.getMileage());
    }
    
    // function that tests the number of cylinders in the car
    @Test 
    public void testNumCylinders(){
        assertEquals(1, this.car.getNumCylinders());
        this.car.setNumCylinders(2);
        assertEquals(2, this.car.getNumCylinders());
    }
}
