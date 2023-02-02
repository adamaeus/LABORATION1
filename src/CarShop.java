import java.util.ArrayDeque;
import java.util.Deque;

public class CarShop  <T extends Vehicle> implements Loadable<T>{

    private Deque <T> carshopCars = new ArrayDeque<>();



    @Override
    public void load(T car) {
    }

    @Override
    public void unLoad() {

    }

    public void showShopCars(){
        carshopCars.size();
    }
}
