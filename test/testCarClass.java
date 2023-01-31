import org.junit.Before;
import org.junit.After;
import org.junit. Test;


import java.awt.*;


public class testCarClass {

    Volvo240 volvoTest;
    Saab95 saabTest;


    @Before
    public void before(){
        volvoTest = new Volvo240();
        saabTest = new Saab95();
    }

    @After
    public void after(){
        volvoTest = null;
        saabTest = null;
    }
    /**
     * Test for method getWeight method defined in Vehicle class. This case of an object of type Car (set to 700)
     */
    @Test
    public void testCarGetWeight(){
        assert (volvoTest.getWeight() == 700);
    }

    /**
     * Test for an object of class car to access getEnginePower method
     */
    @Test
    public void testCarGetEnginePower(){
        assert(volvoTest.getEnginePower() == 100);
    }


}
