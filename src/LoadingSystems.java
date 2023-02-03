import java.util.ArrayDeque;
import java.util.Deque;

public class LoadingSystems <T> implements Loadable<T> {


    protected Deque<T> loadedStack = new ArrayDeque<>();



    public void load(T object) {
        loadedStack.push(object);
    }

    public void unLoad() {
        T lastLoaded = loadedStack.peek();
        assert lastLoaded != null;
        loadedStack.pop();
    }
}
