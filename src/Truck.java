import java.awt.*;

public class Truck extends Vehicle {

    private static final double weight = 2000;


    public Truck(String modelName, int nrDoors, double enginePower, Color color) {
        super(modelName, nrDoors, enginePower, color, weight);
    }

    @Override
    public double speedFactor() {
        return 0;
    }


}
