import org.junit.Before;
import org.junit.After;
import org.junit. Test;


import java.awt.*;

public class testTruckClass {


    Scania scaniaTest = new Scania();

    Trailer trailerTest = new Trailer();



    @Before
    public void before(){
        scaniaTest = new Scania();
        trailerTest = new Trailer();

    }
    @After
    public void after(){
        trailerTest = new Trailer();
        scaniaTest = null;
    }



    /**
     * Test method for getWeight for a truck, final set to 2000
     */
    @Test
    public void testTruckGetWeight(){
        assert(scaniaTest.getWeight() == 2000);
    }

    /**
     * Test for an object of class Truck to acces getEnginePower method
     */
    @Test
    public void testTruckGetEnginePower(){
        assert(scaniaTest.getEnginePower() == 350);
    }



}
