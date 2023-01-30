import java.awt.*;
import java.util.Scanner;


/**
 * Abstracta klassen Vehicle. Här skapas inga objekt, vi sätter upp en konstruktor för skapandet av en bil samt
 * de olika parametrarna som används och är gemensamma för de båda subklasserna beroende på biltyp.
 * Denna klass implementerar endast interfacet movable för att vi ska kunna skapa metoder som appliceras vid körning
 * av bilarna.
 */
public abstract class Vehicle implements Movable {

    public Vehicle(String modelName, int nrDoors, double enginePower, Color color, double weight) {
        this.modelName = modelName;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.weight = weight;
    }

    // PROBLEM, ALLA OBJECT AV CARS FÅR VIKTEN 2000 (SOM I TRUCK).
    private static double weight;
    private Color color;
    private final String modelName;
    private final int nrDoors;
    private static  double enginePower;
    private static double currentSpeed;



    public String getModelName() { return modelName; }
    public int getNrDoors() {
        return nrDoors;
    }
    public Color getColor() {
        return color;
    }
    public static double getWeight() {return weight;}

    public static double getCurrentSpeed() {
        return currentSpeed;
    }

    public static double getEnginePower() { return enginePower; }


    private void setColor(Color clr) {color = clr;}




    /**
     * Metod för att starta motorn, currentSpeed sätts till 0.1
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Metod för att stanna motorn. currentSpeed sätts till 0.0
     */
    public void stopEngine() {
        currentSpeed = 0;
    }


    public abstract double speedFactor();

    /**
     * Metod för att öka farten. Denna metod tar in ett amount som anges i metoden gas(). Amountet som anges i gas,
     * och passerar kravet på att det måste befinnas inom intervallet [0, 1], skickas från gas() till incrementSpeed,
     * där en kalkyl beräknar ut vad hastigheten ska "sättas till" som currentSpeed sätts till. Math.min implementationen
     * försäkrar endast att hastigheten aldrig överstiger enginePower (som är bilens maxhastighet).
     * @param amount mängd som vi ökar farten med.
     */
    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    /**
     * Metod för att minska hastigheten. Metoden brake() tar in ett amount som skickas vidare till denna metoden,
     * där kalkylen ges det totala beloppet som farten ska minskas med, därav sätts currentSpeed till farten efter
     * minskning.
     * @param amount beloppet/mängden fartminskning som anges vid metoden brake().
     */
    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    /**
     * Endast en försäkring om att currentSpeed aldrig överstiger 100, utanför incrementSpeed som redan har denna spärr.
     */





    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount){
        if (amount >= 0 && amount <= 1){
            decrementSpeed(amount);
        }
    }


    /**
     * Getters för X och Y koordinat.
     * @return
     */
    public double getX (){return x;}
    public double getY(){return y;}

    /**
     * Värden på vår fiktiva X och Y axel
     */
    private double x = 0.0;
    private double y = 0.0;


    /**
     *  Implementation av "variabel" för ENUM typerna Directions. direction är alltså interchangable med samtliga
     *   av ENUM typerna i ENUM filen.
     */
    Directions direction = Directions.UP;


    /**
     * Metoder för Direction "turns", Med ENUM Directions använder vi en Switch för att bestämma
     * hur bilen ska navigera i planet, alltså hur den ska rotera på en axel, om den är riktad
     * höger, och vill rotera höger, kommer riktningen vara nedåt.
     */
    public void turnLeft() {
        switch (direction) {
            case RIGHT -> direction = Directions.UP;
            case UP -> direction = Directions.LEFT;
            case DOWN -> direction = Directions.RIGHT;
            case LEFT -> direction = Directions.DOWN;
        }
    }

    public void turnRight() {
        switch (direction) {
            case LEFT -> direction = Directions.UP;
            case UP -> direction = Directions.RIGHT;
            case DOWN -> direction = Directions.LEFT;
            case RIGHT -> direction = Directions.DOWN;
        }
    }

    /**
     * Metod för move, nyckeln i samverket mellan ENUM directions och att bilen flyttar sig.
     * Här väljer vi ett grid, x och y axel, där bilens förflyttning uppåt resulterar i
     * positiv y ökning, nedåt resulterar i negativ. LEFT kommer dra bilen ut på x axeln i
     * negativ riktning (x minskar) och motsatt för RIGHT, då x ökar.
     */
    public void move() {
        switch (direction) {
            case LEFT -> x = x - currentSpeed;
            case RIGHT -> x = y + currentSpeed;
            case UP -> y = y + currentSpeed;
            case DOWN -> y = y - currentSpeed;
        }

    }





    public static void printCoordinates (Vehicle vehicle){
        System.out.println((vehicle.direction == Directions.DOWN || vehicle.direction == Directions.UP) ? "           " + vehicle.getY() : vehicle.getX() + "           ");
    }

    /**
     * Metod för att köra bilen. En scanner kallar på input, vilken riktning vi vill köra.
     * Riktningen sätts som lika med directions från ENUM. Därefter aktiveras move och
     * gas som kör bilen i riktningen, medans metoden printCoordinates printar koordinaterna
     * längs körsträckan så att vi ser vart bilen kör.
     */

    public static void driveVehicle(Vehicle vehicle){
        Scanner scanner = new Scanner(System.in);
        vehicle.startEngine();
        System.out.println("Direction to drive " + vehicle.getModelName() + "   ?  ");
        vehicle.direction = Directions.valueOf(scanner.next());
        for (double i = 0; i < 1; i += 0.1) {
            vehicle.move();
            vehicle.gas(i);
            printCoordinates(vehicle);
        }
    }
}


