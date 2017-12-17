/*
 * Create the TV object which displays a show
 */
package multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George
 */
public class Television extends Thread {
private boolean isFavoriteShow = false;

    public Boolean getIsFavoriteShow() {
        return isFavoriteShow;
    }

    @Override
    public void run() {
        System.out.println("TV is running");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Television.class.getName()).log(Level.SEVERE, null, ex);
        }
            isFavoriteShow = true;
            System.out.println("Favourite show started");
    }
 }
