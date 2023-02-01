import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //System.out.println( "X           Y");
        //System.out.println("----------------");

        /**
         * CARS
         */
        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();
        Volvo240 volvo01 = new Volvo240();


        /**
         * Trucks
         */
        Trailer trailer = new Trailer();
        Scania scania = new Scania();

        /**
         * Drive method
         */
        //Scania.driveVehicle(scania);
        //volvo240.driveVehicle(volvo240);


        /**
         * Open ramp / flak
         */

        //scania.tiltFlak(70.0);
        //trailer.openRamp(1);


        /**
         * Load / unLoad methods
         */






        trailer.drive2(2, 3);

    }
}
