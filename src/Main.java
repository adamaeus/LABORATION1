import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {


        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();
        Volvo240 volvo01 = new Volvo240();


        Trailer trailer = new Trailer();
        Scania scania = new Scania();

        //Scania.driveVehicle(scania);
        //volvo240.driveVehicle(volvo240);


        //scania.tiltFlak(70.0);
        //trailer.openRamp(1);



        CarMechanic<Volvo240> volvo240CarMechanic = new CarMechanic<>();
        volvo240CarMechanic.loadToMechanic(volvo01);
        volvo240CarMechanic.loadToMechanic(volvo240);




        trailer.stopEngine();
        trailer.openRamp(1);
        trailer.load(volvo01);
        trailer.closeRamp();
        trailer.startEngine();
        trailer.driveVehicle();
        trailer.stopEngine();
        trailer.openRamp(1);
        trailer.unLoad();
        trailer.printCoordinates();
        volvo01.printCoordinates();


    }

}
