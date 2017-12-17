/*
 * Display Hello Web in console
 */
package multithreading;

/**
 *
 * @author George
 */
public class SayGoodbyeAgain extends Thread {
    @Override
    public void run() {
        System.out.println("Hello Web!");
    }
}
