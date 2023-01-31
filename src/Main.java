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

        //scania.tiltFlak(80.0);
        //trailer.openRamp(1);


        /**
         * Load / unLoad methods
         */

        scania.load(scania.flak, saab95);
        scania.load(scania.flak, volvo01);
        scania.load(scania.flak, volvo240);

        scania.unLoad(scania.flak);
        scania.unLoad(scania.flak);
        scania.unLoad(scania.flak);

        trailer.load(trailer.ramp, saab95);
        trailer.load(trailer.ramp, volvo01);
        trailer.unLoad(trailer.ramp);
        trailer.displayCargoInformation();


    }


    }
