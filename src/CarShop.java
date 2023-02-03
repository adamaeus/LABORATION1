import java.util.ArrayDeque;
import java.util.Deque;

public class CarShop  <T extends Vehicle> implements Loadable<T>{

    private Deque <T> carShopCars = new ArrayDeque<>(20);



    @Override
    public void load(T car) {
        carShopCars.add(car);
    }

    @Override
    public void unLoad() {

    }

    public void showShopCars(){
        carShopCars.size();
    }


    public String getStack(){
        return carShopCars.toString();
    }
}
