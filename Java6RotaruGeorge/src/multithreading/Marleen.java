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
    public void run() {
        System.out.println("Marleen is sleeping");
        while(true){
            System.out.print(""); // if no instructions before the if statement, it is never executed. WHY ??
            if (isSleeping==false) {
                System.out.println("Marleen is watching tv");
                break;
            }
        }
    }
}
