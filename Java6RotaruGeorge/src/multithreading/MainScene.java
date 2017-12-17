/*
 * Create and run the main scenario
 */
package multithreading;

/**
 *
 * @author George
 */
public class MainScene {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create instances of all actors
        Cigar tigara = new Cigar();
        Marleen femeie = new Marleen(tigara);
        Television televizor = new Television();
        VacuumCleaner aspirator = new VacuumCleaner();
        Bob barbat = new Bob(aspirator, femeie, televizor);
        
        femeie.setPriority(1);
        // start threads
        tigara.start();
        televizor.start();
        aspirator.start();
        femeie.start();
        barbat.start();
        
    }
    
}
