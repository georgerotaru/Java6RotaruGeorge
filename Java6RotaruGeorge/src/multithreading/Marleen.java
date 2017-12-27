/*
 * Woman character
 */
package multithreading;

/**
 *
 * @author George
 */
public class Marleen extends Thread {
private Boolean isSleeping = true;
private Cigar tigara;

    public Marleen(Cigar c) {
        tigara = c;
    }

    public void setIsSleeping(Boolean isSleeping) {
        this.isSleeping = isSleeping;
    }

    public Boolean getIsSleeping() {
        return isSleeping;
    }

    @Override
    public synchronized void run() {
        sleeping();
    }
    
    private void sleeping(){
        while(true){
            if(isSleeping == false){
                System.out.println("Marleen is awake and watching her favourite show.");
                break;
            } else {
                System.out.println("Marleen is sleeping.");
            }
        }
    }
}
