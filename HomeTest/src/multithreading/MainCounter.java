/*
 * Try to syncronize two threads
 */
package multithreading;

/**
 *
 * @author George
 */
public class MainCounter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create counter object
        Counter counter = new Counter();
        //create two threads
        Adunare add = new Adunare(counter);
        Scadere dif = new Scadere(counter);
        //start two threads\
        add.start();
        dif.start();
        //
    }
    
}
