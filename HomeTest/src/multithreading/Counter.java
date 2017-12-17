/*
 * Keeps the counter
 */
package multithreading;

/**
 *
 * @author George
 */
public class Counter {
private volatile int c = 0;//var. comuna
private boolean canWrite = true;

public synchronized void increment() {
    if (canWrite) {
        canWrite = false;
        c++;
        canWrite = true;
    }
}
public synchronized void decrement() {
    if (canWrite) {
        canWrite = false;
        c--;
        canWrite = true;
    }
}
public synchronized int value() {
    return c;
}    
}
