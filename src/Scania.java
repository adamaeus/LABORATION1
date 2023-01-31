import java.awt.*;

public class Scania extends Truck {


    TruckBed flak = new TruckBed(1000, 70.0, "FLAK");


    public Scania() {
        super("Scania 01", 2, 350, Color.BLUE);
    }

    /**
     * Var tvungen att göra getEnginePower och getCurrentSpeed från VEHICLE till static, samt parametrar.
     * antar att det är så därför att man inte skapar ett objekt av Vehicle, och därför måste de "hoppa" vidare
     * till truck, och därför vara statiska till vehicle?
     * @param amount
     */


    // Inte nöjd med denna metoden, behöver mata in flak parameter, redundant. Samt metoden finns exakt lika
    // i trailer classen, blir copy code.
    public void tiltFlak(double amount) {
        stopEngine();
        if (Scania.getCurrentSpeed() == 0) {
            flak.truckBedLiftOperator(flak, amount);
        }
    }

    public void displayCargoInformation() {
        flak.displayCargoInformation(flak);
    }


    public void load(TruckBed truckBed, Car car) {
        flak.load(truckBed, car);
    }

    public void unLoad(TruckBed truckBed) {
        flak.unLoad(truckBed);
    }

    @Override
    public double speedFactor() {
        return 0;
    }
}



