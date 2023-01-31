import java.awt.*;

public class Truck extends Vehicle {

    // UPDATED 30/1.
    // WEIGHT SET IN SUPER CONSTRUCTOR
    public Truck(String modelName, int nrDoors, double enginePower, Color color) {
        super(modelName, nrDoors, enginePower, color, 2000);
    }

    @Override
    public double speedFactor() {
        return 0;
    }


}
