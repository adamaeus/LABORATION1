import java.awt.*;




public class Trailer extends Truck {


    TruckBed ramp = new TruckBed(4000,  1, "RAMP");

    public Trailer() {
        super("Trailer", 2, 450, Color.RED);
    }


    public void openRamp (int amount) {
        stopEngine();
        if (Trailer.getCurrentSpeed() == 0) {
            ramp.truckBedLiftOperator(ramp, amount);
        }
    }

    public void load(TruckBed truckBed, Car car) {
        ramp.load(truckBed, car);
    }

    public void unLoad(TruckBed truckBed) {
        ramp.unLoad(truckBed);
    }

    public void displayCargoInformation() {
        ramp.displayCargoInformation(ramp);
    }




}



