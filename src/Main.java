import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

/**
 * Skapandet av bilar
 */
        Volvo240 volvo240 = new Volvo240();



        /*
        System.out.println( "X           Y");
        System.out.println("----------------");


        //driveCar(volvo240);
        //turnCar(volvo240);

*/




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

    // ANVÄNDER SIG AV (condition) ? expression1 : expression2;
    /*
    public static void printCoordinates(Vehicle car){
        System.out.println((car.direction == Directions.DOWN || car.direction == Directions.UP) ? "           " + ((double) Math.round(car.getY())) : (((double) Math.round(car.getX()) + "           ")));
    }


    public static void printCoordinates(Vehicle car){
    System.out.println((car.direction == Directions.DOWN || car.direction == Directions.UP) ? "           " + car.getY() : car.getX() + "           ");
}
     */
    /**
     * Metod för att köra bilen. En scanner kallar på input, vilken riktning vi vill köra.
     * Riktningen sätts som lika med directions från ENUM. Därefter aktiveras move och
     * gas som kör bilen i riktningen, medans metoden printCoordinates printar koordinaterna
     * längs körsträckan så att vi ser vart bilen kör.
     */

    public static void driveCar (Vehicle car){
        Scanner scanner = new Scanner(System.in);
        car.startEngine();
        System.out.println("Direction to drive " + car + "   ?  ");
        car.direction = Directions.valueOf(scanner.next());
        for (double i = 0; i <1 ; i+=0.1 ){
        car.move();
        car.gas(i);
        printCoordinates(car);
        }
    }

    /*
    public static void turnCar(Vehicle car){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Where to turn? ");
        car.direction = Directions.valueOf(scanner.next());
            if (Directions.valueOf(scanner.next()) == Directions.RIGHT){
                car.turnRight();
                printCoordinates(car);
            }else if (Directions.valueOf(scanner.next()) == Directions.LEFT){
                car.turnLeft();
                printCoordinates(car);
            }
        System.out.println("Wrong input ");
    }
*/







}
