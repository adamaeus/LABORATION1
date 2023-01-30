import java.lang.String;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;


/**
 * Class TruckBed. TruckBed regarded as separate object for object delegation.
 */
public class TruckBed implements Loadable{


    /**
     * Bedtype, only currently viable for correct display in console for program run.
     */
    private final String bedType;

    /**
     * carryCapacity, important parameter for a TruckBed.
     */
    private double carryCapacity;

    /**
     * Max Angle, applied when creating the truckBed, could be used as a final in each truck, however important for correct
     * method calculations in operating methods.
     */
    private double maxAngle;

    private double currentLoad;

    public double getMaxAngle(){return maxAngle;}

    public double getCurrentAngle(){return currentAngle;}

    public double getCarryCapacity() {return carryCapacity;}
    public String toStringTruckBed() {return bedType;}

    private double currentAngle;



    public TruckBed(double carryCapacity, double maxAngle, String bedType) {
        this.carryCapacity = carryCapacity;
        this.maxAngle = maxAngle;
        this.bedType = bedType;
        Deque<Car> loadedCars = new ArrayDeque<>();
    }

    public void truckBedLiftOperator(TruckBed truckBed, double amount) {
    if (amount >= 0.0 && amount <= truckBed.getMaxAngle()) {
        incrementAngle(amount);
        displayCurrentAngle(amount, truckBed);
    } else {System.out.println("Angle input out of reach");}
}

    public void displayCurrentAngle(Double amount, TruckBed truckBed) {
        double k;
        System.out.println("Current angle of " + truckBed.toStringTruckBed());
        for (k = 0.0; k <= amount; k += 1) {
            System.out.println(k);
        }
    }





    /*
    public void displayCurrentLoad(TruckBed truckBed){
        System.out.println("Current Load for: " + truckBed.toStringTruckBed());
        System.out.println(getCurrentLoad(truckBed));
    }

    public double getCurrentLoad(TruckBed truckBed) {
        int cars = Car.getWeight() - amountOfCars;
        return truckBed.currentLoad = getCarryCapacity() - cars;
    }

    public void displayLoad(TruckBed truckBed){
        System.out.println(getCurrentLoad(truckBed));
    }
     */


    Deque<Car> loadedCars = new ArrayDeque<>();

    public void load(TruckBed truckBed, Car car) {
        loadedCars.push(car);
        Car lastLoaded = loadedCars.peek();
        truckBed.currentLoad = truckBed.currentLoad + (truckBed.carryCapacity - car.getWeight());
        System.out.println("Loaded " + lastLoaded + " to " + truckBed.toStringTruckBed());
    }
    public void unLoad(TruckBed truckBed) {
        Car lastLoaded;
        lastLoaded = loadedCars.peek();
        loadedCars.pop();
        System.out.println("Unloaded " + lastLoaded.getModelName() + "from " + truckBed.toStringTruckBed());
        System.out.println(lastLoaded);
    }


    public void incrementAngle(double amount) {
        while (currentAngle < amount) {
            currentAngle = Math.min(currentAngle + 1.0, 70);
        }
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