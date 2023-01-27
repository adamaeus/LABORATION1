import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

/**
 * Skapandet av bilar
 */
        Volvo240 volvo240 = new Volvo240();

        /**
         * metod för att köra bilen.
         */
        driveCar(volvo240);


    }

    /**
     * Metod för att printa ut koordinaterna bilen förflyttas i på X och Y axlarna.
     * @param car any objekt from the class Vehicle.
     */
    public static void printCoordinates(Vehicle car){
        if (car.direction == Directions.DOWN || car.direction == Directions.UP) {
            System.out.println("           " + ((double) Math.round(car.getY())));
        }else {
            System.out.println((((double) Math.round(car.getX()) + "           ")));

        }
    }
    /**
     * Metod för att köra bilen. En scanner kallar på input, vilken riktning vi vill köra.
     * Riktningen sätts som lika med directions från ENUM. Därefter aktiveras move och
     * gas som kör bilen i riktningen, medans metoden printCoordinates printar koordinaterna
     * längs körsträckan så att vi ser vart bilen kör.
     */

    public static void driveCar (Vehicle car){
        Scanner scanner = new Scanner(System.in);
        car.startEngine();
        System.out.println("Direction to drive " + car.GetModelName() + "?  ");
        car.direction = Directions.valueOf(scanner.next());
        for (double i = 0; i <1 ; i+=0.1 ){
        car.move();
        car.gas(i);
        printCoordinates(car);
        }}
    }


