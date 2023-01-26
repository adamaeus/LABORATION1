import java.awt.*;


/**
 * Bilklass för Volvo.
 */
public class Volvo240 extends Vehicle {

    /**
     * Klassbunden "permanent" variabel som gör anspråk vid klassens metod för att beräkna hastighetsfaktorn.
     */
    public final static double trimFactor = 1.25;

    /**
     * konstruktor av volvo, anropar superkonstruktorn i superklassen vehicle.
     */
    public Volvo240() {
        super(4, Color.BLACK, 100, "Volvo240");
        stopEngine();
    }

    /**
     * Klassspecifik parameter för hastighetsberäkning.
     * @return
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }


}
