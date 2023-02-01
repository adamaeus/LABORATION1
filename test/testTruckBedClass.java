import org.junit.Before;
import org.junit.After;
import org.junit. Test;


import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;


public class testTruckBedClass {

    TruckBed flak;
    TruckBed ramp;


    Volvo240 volvoTest02;
    Saab95 saabTest02;
    Deque<Car> loadedCarsTest = new ArrayDeque<>();





    @Before
    public void before(){
        flak = new TruckBed(1000, 70.0, "FLAK");
        ramp = new TruckBed(4000, 1, "RAMP");
        flak.getCurrentLoad();
        ramp.getCurrentLoad();
        volvoTest02 = new Volvo240();
        saabTest02 = new Saab95();
    }
    @After
    public void after(){
        flak = null;
        ramp = null;
    }



    /**
     * Method for get Model name
     */
    @Test
    public void testGetModelNameFlak(){
        assert(flak.getBedType() == "FLAK");
    }
    @Test
    public void testGetModelNameRamp(){
        assert(ramp.getBedType()== "RAMP");
    }



    /**
     * Test for flak carryCapacity, which in constructor is set to 1000
     */
    @Test
    public void testCarryCapacity(){
        assert(flak.getCarryCapacity() == 1000);
    }




    /**
     * Test for currentLoad, which is a method that calculates the weight of the total amount of cars loaded,
     * initially set to 0
     */
    @Test
    public void testCurrentLoad(){
       assert(flak.getCurrentLoad() == 0.0);
    }


    /**
     * TESTS FOR LOADING METHODS
     */
    @Test
    public void testLoad(){
            loadedCarsTest.push(volvoTest02);
            Car lastLoaded = loadedCarsTest.peek();
            assert (lastLoaded == volvoTest02);
        }
     @Test
     public void testLoad02(){
        loadedCarsTest.push(saabTest02);
        Car lastLoaded = loadedCarsTest.peek();
        assert (lastLoaded == saabTest02);
     }

    /**
     * TEST FOR AMOUNT OF ELEMENTS (CARS) IN THE STACK
     */
    @Test
     public void testCargoStack(){
         loadedCarsTest.push(saabTest02);
         loadedCarsTest.push(volvoTest02);
        assert (loadedCarsTest.size() == 2);
     }

    /**
     * SECOND TEST FOR AMOUNT OF CARS IN STACK.
     */
    @Test
    public void testCargoStack02(){
        loadedCarsTest.push(saabTest02);
        loadedCarsTest.push(volvoTest02);
        assert ((loadedCarsTest.size() * 700 == 1400));
    }
    @Test
    public void testCargoStack03(){
        loadedCarsTest.push(saabTest02);
        loadedCarsTest.push(volvoTest02);
       assert (saabTest02.getWeight() + volvoTest02.getWeight() == 1400);
    }


    public double testCurrentLoad;
    public double getTestCurrentLoad(){return testCurrentLoad;}
    @Test
    public void testGetCurrentLoad() {
        loadedCarsTest.push(saabTest02);
        testCurrentLoad = testCurrentLoad + saabTest02.getWeight();
        assert (testCurrentLoad  == (loadedCarsTest.size() * 700));
    }


    }







