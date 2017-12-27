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
    public synchronized void run() {
        System.out.println("TV is running");
        try {
            Thread.sleep(500);
            isFavoriteShow = true;
            receiving();
        } catch (InterruptedException ex) {
            Logger.getLogger(Television.class.getName()).log(Level.SEVERE, null, ex);
        }            
    }
    
    private void receiving(){
        while(true){
            if (isFavoriteShow == true){
                System.out.println("Favourite show started.");                
            break;
            }
        }
    }    
 }
