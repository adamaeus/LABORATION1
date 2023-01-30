import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //System.out.println( "X           Y");
        //System.out.println("----------------");

        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();
        volvo240.driveVehicle(volvo240);
        Scania scania = new Scania();

        Scania.driveVehicle(scania);


        Trailer trailer = new Trailer();

        scania.tiltFlak(10.0);
        trailer.openRamp(1);


        scania.load(saab95);
        scania.unLoad();

        // Behöver HJÄLP med displayCurrentLoad (generalisering, Truck class, ej behöva mata in parameter).
        //scania.displayCurrentLoad();
        //trailer.displayCurrentLoad();

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(volvo240);
        cars.add(saab95);
        cars.remove(saab95);
        double combinedWeight = Volvo240.getWeight() + Saab95.getWeight();
        if (combinedWeight < 1000) {
            System.out.println(combinedWeight);
        } else {
            System.out.println("too heavy load");
        }

    }

        /**
         * Metod för att printa ut koordinaterna bilen förflyttas i på X och Y axlarna.
         * @param car any objekt from the class Vehicle.
         */

    }
