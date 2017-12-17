/*
 * Display Hello World in console
 */
package multithreading;

/**
 *
 * @author George
 */
public class SayGoodbye extends Thread {
    @Override
    public void run() {
        System.out.println("Hello World!");
    }
}
