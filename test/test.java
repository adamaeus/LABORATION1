import org.junit.Before;
import org.junit.After;
import org.junit. Test;


import java.awt.*;

public class test {

    /**
     * Skapandet av två fordon av klassen Vehicle, via subklasserna Volvo240 och Saab95,
     * samt skapandet av en riktningsparameter från "klassen" enum.
     */
    Saab95 saab;
    Volvo240 volvo;
    Directions direction;

    /**
     * Sätter intitialt stadie varpå samtliga test har som utgångspunkt.
     */
    @Before
    public void before() {
        saab = new Saab95();
        volvo = new Volvo240();
        direction = Directions.UP;
    }

    /**
     * En resetfas som utförs efter att ett test genomförts som försäkrar om att samtliga test får samma utgångspunkt,
     * och därför ger resultat reflekterande korrekt processeringsdata.
     */
    @After
    public void after() {
        saab = null;
        volvo = null;
        direction = null;
    }

    /**
     * Test för att testa om gasmetoden fungerar. Om gas ges ett värde x, där 0 < x > 1,
     * sätts currentSpeed till värdet utifrån kalkylen i incrementSpeed.
     */
    @Test
    public void testGas(){
        volvo.gas(0.1);
        assert(volvo.getCurrentSpeed() > 0.0);
    }

    /**
     * Testar om gas metoden kan anta värden högre än 1.0, om den inte kan det,
     * innebär det att metoden aldrig anropas och bilen ges aldrig någon fart, alltså currentSpeed == 0.
     *
     */
    @Test
    public void testGasToohigh(){
        saab.gas(1.1);
        assert(saab.getCurrentSpeed() == 0.0);
    }

    /**
     * Testar metoden gas om vi anger för högt amount. Vi anger ett amount 1.1,
     * gas metoden skickar detta amount till increment speed, som ger nytt värde åt currentSpeed.
     * Därefter kallar vi på metoden move, som aktivt flyttar bilen i en riktning, default uppåt i y-led.
     * Vi kollar därefter om Y positionen är 0.0, vilket stämmer,
     * alltså kunde inte vårt höga gas amount komma förbi gas metodskravet på max 1.0.
     */
    @Test
    public void testGasAmount(){
        volvo.gas(1.1);
        volvo.move();
        assert (volvo.getY() == 0.0);
    }

    /**
     * Testar metoden brake. startEngine sätter currentSpeed till 0.1. Implementation av brake åkallar metoden
     *  decrementSpeed, vilket minskar farten med ett amount,
     *  om vi minskar farten med nuvarande hastighet (currentSpeed) blir volvos current speed = 0. Alltså ger testet true.
     *
     */
    @Test
    public void testBreak(){
        volvo.startEngine();
        volvo.brake(volvo.getCurrentSpeed());
        assert (volvo.getCurrentSpeed() == 0.0);
    }
    @Test
    public void testBreakSaab(){
        saab.startEngine();
        saab.brake(saab.getCurrentSpeed());
        assert (saab.getCurrentSpeed() == 0.0);
    }

    /**
     * Testar om fordonet flyttas i korrekt riktning längs linjära diagram.
     * Gas och move flyttar bilen uppåt i Y led. Break stannar bilen.
     * turnLeft riktar bilen vänster, direction pekar nu i X - led.
     * Move och gas flyttar oss i negativ riktning på X-axeln. Vi kollar därefter om bilens position i
     * Y-led är positiv (förflyttning uppåt) och att bilens position i X -led är negativ.
     */
    @Test
    public void testDrive(){
        volvo.startEngine();
        volvo.gas(0.5);
        volvo.move();
        volvo.brake(0.5);
        volvo.turnLeft();
        volvo.gas(0.5);
        volvo.move();
        volvo.brake(0.5);
        volvo.stopEngine();
        assert(volvo.getY() > 0.0 && volvo.getX() < 0.0);
    }


    /**
     * Testar om brake med otillräckligt amount angivet inte stannar bilen,
     * utan att bilen fortfarande har en currentSpeed (dock reducerad).
     */
    @Test
    public void testBreakUnsufficient(){
        volvo.startEngine();
        volvo.brake(0.05);
        assert(volvo.getCurrentSpeed() != 0.0);
    }


    /**
     * Testar ett fält i constructor som sätter färg till bilen.
     */
    @Test
    public void testGetColor() {
        assert (saab.getColor() == Color.RED && volvo.getColor() == Color.BLACK);
    }

    /**
     * Testar om bilens riktning faktiskt pekar åt höger efter att vi kallat metoden turnRight.
     */
    @Test
    public void testTurnRight() {
        volvo.direction = Directions.UP;
        volvo.turnRight();
        assert (volvo.direction == Directions.RIGHT);

    }

    /**
     * I denna test metoden utgår vi från att bilens riktning pekar åt höger.
     * Då utgår vi från att efter rotation åt höger 4 gånger,
     * kommer bilens riktning vara tillbaka till ursprungsriktningen, alltså åt höger.
     *
     */
    @Test
    public void testTurnRight2() {
        volvo.direction = Directions.RIGHT;
        volvo.turnRight();
        volvo.turnRight();
        volvo.turnRight();
        volvo.turnRight();
        assert (volvo.direction == Directions.RIGHT);
    }

    /**
     * Testar om funktionen turnLeft fungerar, där bilen med utgångspunkt har direction UP,
     * testar vi om efter att vi satt direction till LEFT, att bilen faktiskt också är riktad åt LEFT.
     *
     */
    @Test
    public void testTurnLeft() {
        volvo.direction = Directions.UP;
        volvo.turnLeft();
        assert (volvo.direction == Directions.LEFT);
    }

    /**
     * Ett cykeltest, där vi testar om bilen med utgångspunkt LEFT,
     * kommer att nå tillbaka till sin ursprungsposition efter att ha ändrat riktning åt vänster 4 gånger.
     * Alltså 90 grader * 4 = 326 == helt varv.
     */
    @Test
    public void testTurnLeft2() {
        volvo.direction = Directions.LEFT;
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.turnLeft();
        assert (volvo.direction == Directions.LEFT);
    }

    /**
     * Testar om bilen faktiskt förflyttas framåt vid kallelse av metoden move. Move med riktning UP ger ett
     * inkrementerande Y värde, där Y är större än 0 kan slutsats dras att bilen färdats i riktning UP,
     * vilket på ett liggande plan skulle kunna ses som "framåt".
     *
     */
    @Test
    public void testMoveForward() {
        volvo.startEngine();
        volvo.gas(volvo.getCurrentSpeed());
        volvo.move();
        assert (volvo.getY() > 0);
    }

    /**
     * Ytterligare en testmetod för att kontrollera att bilen färdas i den riktning vi vill. startEngine ger oss
     * currentSpeed == 0.1, därefter väljer vi att rikta vänster och applicera move,
     * som ska färda bilen i negativ x riktning.
     *
     */
    @Test
    public void testMoveLeft(){
        volvo.startEngine();
        volvo.turnLeft();
        volvo.move();
        assert (volvo.getX() < 0.0);
    }

    /**
     * Test för att kolla om metoden setTurboOn aktiverar turbon.
     */
    @Test
    public void testTurboOn(){
        saab.setTurboOn();
        assert (saab.turboOn = true);
    }

    /**
     * Test för att kontrollera att turboOff fungerar, först aktiveras turbon, sedan aktiveras den. Vi påstår därefter
     * att turboOn ska vara falsk, alltså att turbon är av. Om detta ger true, fungerar metoden.
     */
    @Test
    public void testTurboOff(){
        saab.setTurboOn();
        saab.setTurboOff();
        assert (!saab.turboOn);
    }

    /**
     * Test för metoden startEngine. startEngine sätter currentSpeed till 0.1, genom att starta motorn kollar vi så att
     * currentSpeed faktiskt är högre än 0.0.
     */
    @Test
    public void testStartEngine(){
        volvo.startEngine();
        assert (volvo.getCurrentSpeed() > 0.0);
    }

    /**
     * Test för stopEngine, som ska sätta currentSpeed till 0.0.
     */
    @Test
    public void testStopEngine(){
        volvo.stopEngine();
        assert (volvo.getCurrentSpeed() == 0.0);
    }

}


