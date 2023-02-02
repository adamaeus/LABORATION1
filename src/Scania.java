import java.awt.*;

public class Scania extends Truck {


    TruckBed scaniaFlak = new TruckBed(1000, 70.0, "FLAK");


    public Scania() {
        super("Scania 01", 2, 350, Color.BLUE);
    }

    /**
     * Var tvungen att göra getEnginePower och getCurrentSpeed från VEHICLE till static, samt parametrar.
     * antar att det är så därför att man inte skapar ett objekt av Vehicle, och därför måste de "hoppa" vidare
     * till truck, och därför vara statiska till vehicle?
     *
     * @param amount
     */

    double trailerWeight = scaniaFlak.getCarryCapacity() * 0.001;

    @Override
    public double speedFactor() {
        return (getEnginePower() * 0.01 - trailerWeight);
    }

    public void openRamp(double amount) {
        stopEngine();
        if (Scania.getCurrentSpeed() == 0) {
            scaniaFlak.openRamp(amount);
        }
    }

    public void displayCargoInformation() {
        scaniaFlak.displayCargoInformation();
    }

    public void load(Car car) {
        scaniaFlak.load(car);
    }

    public void unLoad() {
        scaniaFlak.unLoad();}
}



