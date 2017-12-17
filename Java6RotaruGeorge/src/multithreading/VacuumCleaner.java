/*
 * Display the existance of a vacuum cleaner
 */
package multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George
 */
public class VacuumCleaner extends Thread {
private boolean isCleaning = false;

    public boolean getIsCleaning() {
        return isCleaning;
    }

    public void setIsCleaning(boolean isCleaning) {
        this.isCleaning = isCleaning;
        if (isCleaning)
            System.out.println("The vacuum cleaner is swiched on");
        }
    @Override
    public void run() {
        cleaning();
    }
    
    private void cleaning() {
        if (isCleaning==true) {
            try {
                Thread.sleep(MIN_PRIORITY);
            } catch (InterruptedException ex) {
                Logger.getLogger(VacuumCleaner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
