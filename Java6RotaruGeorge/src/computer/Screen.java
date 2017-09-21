/*
 * Screen of computer
 */
package computer;

/**
 * Class Screen implements behavior of screen
 * @author George
 */
public class Screen {
    String screenMemory = "Total: ";
    
    public void display(String deAfisat){
        screenMemory += deAfisat;
        System.out.println(screenMemory);
        //screenMemory.clear();
    }
    
    public void display(float rezultat) {
        screenMemory += rezultat;
        System.out.println(screenMemory);
    }

}
