import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;


public class Trailer extends Truck {

    TruckBed trailerRamp = new TruckBed(4000, 1, "RAMP");

    public Trailer() {
        super("Trailer", 2, 450, Color.RED);
    }



    double trailerWeight = trailerRamp.getCarryCapacity() * 0.001;
    @Override
    public double speedFactor() {
        return (getEnginePower() * 0.01 - trailerWeight);
    }
    public double getCurrentLoad() {
        return trailerRamp.getCurrentLoad();
    }

    public void openRamp(int amount) {
        stopEngine();
        trailerRamp.openRamp(amount);
    }

    public void closeRamp() {
        trailerRamp.closeRamp();
    }

    public void getCurrentAngle() {
        trailerRamp.getCurrentAngle();
    }

    public void load(Car car) {
        if (carVicinity(car)) {
            trailerRamp.updateCoordinatesCar(getX(), getY());
            trailerRamp.load(car);
        } else {
            System.out.println("CAR NOT IN REACH");
        }
    }

    public void unLoad() {
        trailerRamp.unLoad();

    }

    public void displayCargoInformation() {
        trailerRamp.displayCargoInformation();
    }




}



