/*
 * Screen of computer
 */
package computer;

/**
 * Class Screen implements behavior of screen
 * @author George
 */
public class Screen {
    String screenMemory = "Display: ";
    
    public void display(String deAfisat){
        screenMemory += deAfisat;
        System.out.println(screenMemory);
    }
}
