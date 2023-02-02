import java.awt.*;

public  class Truck extends Vehicle {

    // UPDATED 30/1.
    // WEIGHT SET IN SUPER CONSTRUCTOR
    public Truck(String modelName, int nrDoors, double enginePower, Color color) {
        super(modelName, nrDoors, enginePower, color, 2000);
    }


    @Override
    public double speedFactor() {
        return 0;
    }

    public boolean carVicinity(Car car){
        return Math.abs(car.getX() - getX()) <= 5.0 && (Math.abs(car.getY() - getY()) <= 5.0);

    }

    public void carUnLoadedHelper(TruckBed truckBed){
       truckBed.setY(getY());
       truckBed.setX(getX());
    }
    public void openRamp(double amount){};

    public double getX (){return x;}
    public double getY(){return y;}


}
