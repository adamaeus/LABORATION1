import java.lang.String;
import java.util.ArrayDeque;
import java.util.Deque;

import static java.lang.System.out;



public class TruckBed implements Loadable <Car> {
    Display truckBedDisplay = new Display();

    public TruckBed(double carryCapacity, double maxAngle, String bedType) {
        this.carryCapacity = carryCapacity;
        this.maxAngle = maxAngle;
        this.bedType = bedType;
    }



    private final String bedType;
    private final double carryCapacity;
    private final double maxAngle;
    private double currentLoad;
    private double currentAngle;





    public double getMaxAngle(){return maxAngle;}
    public double getCurrentAngle(){return currentAngle;}
    public double getCarryCapacity() {return carryCapacity;}
    public String getBedType() {return bedType;}

    public double getCurrentLoad() {
        return (currentLoad = loadedCars.size() * 700);
    }





    public double getX (){return x;}
    public double getY(){return y;}
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }





    public double x;
    public double y;

    Deque<Car> loadedCars = new ArrayDeque<>();





    // ------------------------- RAMP METHODS ----------------------------\\



    public void openRamp(double amount) {
    if (amount >= 0.0 && amount <= getMaxAngle() && Truck.getCurrentSpeed() == 0.0) {
        incrementAngle(amount);
        } else {truckBedDisplay.angleInputOutOfReach();}
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
        } else {
            System.out.println("TRUCK IS MOVING");
        }
    }
    public void decrementAngle(double amount) {
        currentAngle = Math.max(getCurrentAngle() - amount, 70);
    }




    // ----------------------- LOAD & UNLOAD METHODS --------------------------\\



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
    private boolean isLoadable (Car car) {
        return  (getCurrentAngle() == getMaxAngle() &&
                (carryCapacity - getCurrentLoad()) > car.getWeight());
    }

    public void loadCar(Car car){
        loadedCars.push(car);
        currentLoad = currentLoad + car.getWeight();
    }

    public void unLoad() {
        Car lastLoaded = loadedCars.peek();
        loadedCars.pop();
        out.println("UNLOADED " + lastLoaded.getModelName() + " FROM " + getBedType());
        out.println(lastLoaded);
        lastLoaded.setX(getX());
        lastLoaded.setY(getY());
    }




    // ----------------------- DISPLAYER METHODS --------------------------\\


    public void displayCargoInformation (){
        Car lastLoaded = loadedCars.peek();
        out.println("LOADED " + lastLoaded.getModelName() + " to " + getBedType());
        out.println("CURRENT LOAD (KG) : " + getCurrentLoad());
        out.println("CURRENT CARGO FOR : " + getBedType() + " " + loadedCars);
        out.println(" ");
    }


    public void updateCoordinatesCar (double x, double y){
        if (loadedCars.size() != 0 ){
            for (Car car : loadedCars){
                car.setX(x);
                car.setY(y);
            }
        }
    }




}