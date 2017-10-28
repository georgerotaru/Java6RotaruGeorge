/*
 * Class box for everything
 */
package generics;

/**
 * class Box<T>
 * @author George
 * @param <T> will be specified in run-time
 */
public class Box<T> {
    T volume;

    public T getVolume() {
        return volume;
    }

    public void setVolume(T volume) {
        this.volume = volume;
    }
    
}
