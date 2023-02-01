import java.awt.*;


public class Car extends Vehicle{


    // UPDATED 30/1.
    // WEIGHT SET IN SUPER CONSTRUCTOR
    public Car(String modelName, int nrDoors, double enginePower, Color color) {
        super(modelName, nrDoors, enginePower, color, 700);

    }


    public double getX (){return x;}
    public double getY(){return y;}

    public double speedFactor() {
        return 0;
    };
}
