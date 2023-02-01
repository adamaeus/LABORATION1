import java.awt.*;


public class Trailer extends Truck {

    TruckBed trailerRamp = new TruckBed(4000,  1, "RAMP");

    public Trailer() {
        super("Trailer", 2, 450, Color.RED);
    }


    public double getCurrentLoad() {
        return trailerRamp.getCurrentLoad();
    }

    public void openRamp (int amount) {
        stopEngine();
        trailerRamp.openRamp(amount);
        }

    public void closeRamp(){
        trailerRamp.closeRamp();
    }
    public void getCurrentAngle(){
        trailerRamp.getCurrentAngle();
    }
    public void load(Car car) {
        if (carVicinity(car)) {
            trailerRamp.load(car);
            carCoordinatesTruck(car);
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

    public void carCoordinatesTruck(Car car) {
        car.setY(getY());
        car.setX(getX());
    }





}



