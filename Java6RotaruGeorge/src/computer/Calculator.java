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
    int x, y, z;
    //float y = 0;
    //float z = 0;
    Scanner i;
    private final Screen ecran;

    public Calculator() {
        ecran = new Screen();
    }
    
    /**
     * Methods adds 2 digits introduced by user from keyboard
     */
    public void add(){
        x = KeyboardInput.getNumber();
        i = KeyboardInput.getOperator();
        y = KeyboardInput.getNumber();
        z = x + y;
        ecran.display(z);
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
    /**
     * Start the calculator and activate screen
     */
    public void start(){
        ecran.display("");
}
}
