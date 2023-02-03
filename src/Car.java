import java.awt.*;


public class Car extends Vehicle{


    public Car(String modelName, int nrDoors, double enginePower, Color color) {
        super(modelName, nrDoors, enginePower, color, 700);

    }



    private Truck carrier = null;

    public void setCurrentCarrier(Truck carrier){
        this.carrier = carrier;
    }


    @Override
    public double speedFactor() {
        return 0;
    }

    public double getX(){
        if(carrier == null){
            return x;
        } else {
            return carrier.getX();
        }}





    public double getY(){
            if (carrier == null) {
                return y;
            } else {
                return carrier.getY();
            }
        }



}
