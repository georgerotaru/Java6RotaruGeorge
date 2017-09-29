/*
 * Computer frame
 */
package computer;

import java.util.Scanner;

/**
 * Calculator frame
 * @author George
 */
public class Calculator {

    private final Screen ecran;
    private final Button button;
    private StringBuilder sb;

    public Calculator() {
        ecran = new Screen();
        button = new Button();
    }
    
    /**
     * Start the calculator and activate screen
     */
    public void start(){
        ecran.display("0");
    }
    /**
     * Methods adds 2 digits introduced by user from keyboard
     */
    public void add(){
        ecran.clrscr("");
        button.setButtonValue("1");
        ecran.display(button.getButtonValue());

        button.setButtonValue("2");
        ecran.display(button.getButtonValue());

        button.setButtonValue("3");
        ecran.display(button.getButtonValue());


        button.setButtonValue("+");
        ecran.clrscr("");
        
        button.setButtonValue("2");
        ecran.display(button.getButtonValue());
        
        button.setButtonValue("2");
        ecran.display(button.getButtonValue());
        
        button.setButtonValue("3");
        ecran.display(button.getButtonValue());
        button.setButtonValue("=");
        ecran.clrscr("");

    }
    /**
     * Methods adds 2 digits introduced by user from keyboard
     */
    public void decrease(){
    
    }
    /**
     * Multiply 2 numbers introduced by the user
     */
    public void multiply(){
    
    }
    /**
     * Divide 2 numbers introduced by the user
     */
    public void divide(){
    
    }
}
