import java.awt.*;


public class Car extends Vehicle{

    private static final double weight = 700;

    public Car(String modelName, int nrDoors, double enginePower, Color color) {
        super(modelName, nrDoors, enginePower, color, weight);
    }

    public double speedFactor() {
        return 0;
    };
}
