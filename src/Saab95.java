import java.awt.*;

/**
 * Klass för byggandet av en Saab95.
 */
public class Saab95 extends Car{

    /**
     * Saab95 kommer med turbo, en parameter deklareras här för turbo, som antingen kan vara på eller av.
     */
    public boolean turboOn;

    /**
     * Konstruktor för Saab95, åkallar superkonstruktorn i superklassen, med ytterliggare en klassspecifik parameter
     * "turboOn".
     */
    public Saab95(){
        super("Saab95", 2, 125, Color.RED);
        turboOn = false;
        stopEngine();
    }

    /**
     * Metoder för att aktivera eller avaktivera turbo.
     */
    public void setTurboOn(){
	    turboOn = true;
    }
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * Klassspeficik metod för att räkna ut speedfaktor som används vid hastighetsberäkning.
     * @return
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower()* 0.01 * turbo;
    }
}
