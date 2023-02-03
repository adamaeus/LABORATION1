import java.util.ArrayDeque;
import java.util.Deque;


public class CarMechanic <Car> {


    LoadingSystems<Car> mechanicLoadingSystem = new LoadingSystems<>();
    public void loadToMechanic(Car car) {
        mechanicLoadingSystem.load(car);
        System.out.println(mechanicLoadingSystem.loadedStack);
    }

    public void unLoad() {
        mechanicLoadingSystem.unLoad();
    }

    public int getAmountOfCarsInShop(){
        return mechanicLoadingSystem.loadedStack.size();
    }


    public String getStackToString(){
        return (mechanicLoadingSystem.loadedStack.toString());
    }
}
