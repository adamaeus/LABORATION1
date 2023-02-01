import java.lang.String;
import java.util.ArrayDeque;
import java.util.Deque;

import static java.lang.System.out;


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


    public void openRamp(double amount) {
    if (amount >= 0.0 && amount <= getMaxAngle() && Truck.getCurrentSpeed() == 0.0) {
        incrementAngle(amount);
        } else { out.println("ANGLE INPUT UNREACHABLE");}
    }
    //displayCurrentAngle(amount);
    public void incrementAngle(double amount) {
        while (currentAngle < amount) {
            currentAngle = Math.min(amount, maxAngle);
            out.println(getBedType() + " CURRENT ANGLE -> " + currentAngle);
            if(currentAngle == getMaxAngle()){
                out.println(getBedType() + " IS OPEN. READY TO BEGIN LOADING PROCEDURE...");
            }
        }
    }

    public void closeRamp () {
        if (Trailer.getCurrentSpeed() == 0) {
            currentAngle = 0;
            out.println(currentAngle);
            out.println((getBedType() + " IS CLOSED. LOADING PROCEDURE TERMINATED"));
        }
    }
    public void decrementAngle(double amount) {
        currentAngle = Math.max(getCurrentAngle() - amount, 70);
    }

    /*public void displayCurrentAngle(Double amount) {
        double k;
        out.println("Current angle of " + getBedType());
        for (k = 0.0; k <= amount; k += 1) {
            out.println(k);
        }
    }
*/
    //DISPLAYER, HELPER. NOTE -> CHANGE STACK!
    public void displayCargoInformation (){
        Car lastLoaded = loadedCars.peek();
        out.println("LOADED " + lastLoaded.getModelName() + " to " + getBedType());
        out.println("CURRENT LOAD (KG) : " + getCurrentLoad());
        out.println("CURRENT CARGO FOR : " + getBedType() + " " + loadedCars);
        out.println(" ");
    }

    // CURRENT LOAD METHOD.
    public double getCurrentLoad() {
        return (currentLoad = loadedCars.size() * 700);
    }



    // ----------------------- NON - WORKING METHODS --------------------------\\


    // TODO. HELPER METHODS:

    public boolean isTruckBedOpen (){
        return getCurrentAngle() == getMaxAngle();}

    private boolean isCargoCapacityFull (Car car){
        return (carryCapacity - getCurrentLoad()) > car.getWeight();}

    private boolean isLoadable (Car car) {
        return  (getCurrentAngle() == getMaxAngle() &&
                (carryCapacity - getCurrentLoad()) > car.getWeight());
    }

    public void load(Car car) {
        loadHelper(car);
    }
    public void loadHelper (Car car){
        if(isLoadable(car)) {
            loadCar(car);
            displayCargoInformation();
        }else{
            out.println("ERROR. COULD NOT LOAD  " + car.getModelName() +" -> " + getBedType());
        }
    }

    public void loadCar(Car car){
        loadedCars.push(car);
        currentLoad = currentLoad + car.getWeight();
    }



/*
lastLoaded.setX(5);
        lastLoaded.setY(4);
 */

    // unload helper. Setters for Y and X


    public void unLoad() {
        Car lastLoaded = loadedCars.peek();
        loadedCars.pop();
        out.println("UNLOADED " + lastLoaded.getModelName() + " FROM " + getBedType());
        out.println(lastLoaded);
        Truck.carUnLoadedHelper(lastLoaded);

    }


}