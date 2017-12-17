/*
 * Add a value to counter
 */
package multithreading;

/**
 *
 * @author George
 */
public class Adunare extends Thread {
    Counter c;
    
    public Adunare(Counter existingCounter) {
        c = existingCounter;
    }
    
    @Override
    public void run() {
        for (int i=0; i<500; i++) {
            c.increment();
            System.out.println("c value is = "+c.value());
        }
    }
}
