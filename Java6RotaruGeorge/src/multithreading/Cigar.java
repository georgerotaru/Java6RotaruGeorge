/*
 * Display the existance of a cigarette and make it burn out
 */
package multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George
 */
public class Cigar extends Thread {

    @Override
    public void run() {
        burning();
    }
    
    private void burning() {
        System.out.println("The cigar is burning");
        try {
            Thread.sleep(4000);
            System.out.println("The cigar burned out");
        } catch (InterruptedException ex) {
            Logger.getLogger(Cigar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
