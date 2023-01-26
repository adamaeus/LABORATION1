/**
 * Interace för movable, ger oss förmågan att kunna flytta bilen i x och y riktning. Samt styrriktningar för att
 * sätta bilen till en av riktningarna angivna i enum.
 */

public interface Movable {


    void move();
    void turnLeft();
    void turnRight();

}


