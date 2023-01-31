import java.lang.String;
import java.util.ArrayDeque;
import java.util.Deque;


/**
 * Class TruckBed. TruckBed regarded as separate object for object delegation.
 */
public class TruckBed implements Loadable{

    public TruckBed(double carryCapacity, double maxAngle, String bedType) {
        this.carryCapacity = carryCapacity;
        this.maxAngle = maxAngle;
        this.bedType = bedType;
    }

    /**
     * Bedtype, only currently viable for correct display in console for program run.
     */
    private final String bedType;

    /**
     * carryCapacity, important parameter for a TruckBed.
     */
    private final double carryCapacity;

    /**
     * Max Angle, applied when creating the truckBed, could be used as a final in each truck, however important for correct
     * method calculations in operating methods.
     */
    private final double maxAngle;

    private double currentLoad;

    private double currentAngle;





    public double getMaxAngle(){return maxAngle;}

    public double getCurrentAngle(){return currentAngle;}
    public double getCarryCapacity() {return carryCapacity;}
    public String getBedType() {return bedType;}






    // STACKS. WORK IN PROGRESS, EACH TRUCKBED THEIR OWN.

    Deque<Car> cargoFlak = new ArrayDeque<>();
    Deque<Car> cargoRamp = new ArrayDeque<>();
    Deque<Car> loadedCars = new ArrayDeque<>();



    // ----------------------- WORKING METHODS --------------------------\\


    public void truckBedLiftOperator(TruckBed truckBed, double amount) {
    if (amount >= 0.0 && amount <= truckBed.getMaxAngle()) {
        incrementAngle(amount);
        displayCurrentAngle(amount, truckBed);
    } else {System.out.println("Angle input out of reach");}
}

    public void incrementAngle(double amount) {
        while (currentAngle <= amount) {
            currentAngle = Math.min(currentAngle + 1.0, maxAngle);
        }
    }

    //DISPLAYER, HELPER
    public void displayCurrentAngle(Double amount, TruckBed truckBed) {
        double k;
        System.out.println("Current angle of " + truckBed.getBedType());
        for (k = 0.0; k <= amount; k += 1) {
            System.out.println(k);
        }
    }

    //DISPLAYER, HELPER. NOTE -> CHANGE STACK!
    public void displayCargoInformation (TruckBed truckBed){
        System.out.println("Current load (kg) : " + getCurrentLoad(truckBed));
        System.out.println("Current Cargo for : " + truckBed.getBedType() + " " + loadedCars);
        System.out.println(" ");
    }

    // CURRENT LOAD METHOD.
    public double getCurrentLoad(TruckBed truckBed) {
        return (truckBed.currentLoad = loadedCars.size() * 700);
    }



    // ----------------------- NON - WORKING METHODS --------------------------\\


    // TODO. HELPER METHOD TO CHECK STACK LIMIT





    public void load(TruckBed truckBed, Car car) {
        loadedCars.push(car);
        Car lastLoaded = loadedCars.peek();
        truckBed.currentLoad = truckBed.currentLoad + car.getWeight();
        System.out.println("Loaded " + lastLoaded.getModelName() + " to " + truckBed.getBedType());
        displayCargoInformation(truckBed);
    }

    public void unLoad(TruckBed truckBed) {
        Car lastLoaded = loadedCars.peek();
        loadedCars.pop();
        System.out.println("Unloaded " + lastLoaded.getModelName() + "from " + truckBed.getBedType());
        System.out.println(lastLoaded);
        displayCargoInformation(truckBed);
    }






    public void decrementAngle(double amount) {
        currentAngle = Math.min(getCurrentAngle() - amount, 70);
    }

    public void startTruckBed() {
        currentAngle = 0.1;
    }

    public void stopTruckBed() {
        currentAngle = 0.0;
    }



}