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
    private int firstNumber, secondNumber;
    float total;

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
     * Method adds 2 digits introduced by user from keyboard
     */
    public void add(){
        ecran.clrscr("");
        button.setButtonValue("1");
        ecran.display(button.getButtonValue());
        firstNumber = Integer.parseInt(Button.getValue());
        button.setButtonValue("2");
        ecran.display(button.getButtonValue());
        firstNumber = Integer.parseInt(Button.getValue());
        button.setButtonValue("3");
        ecran.display(button.getButtonValue());
        firstNumber = Integer.parseInt(Button.getValue());

        button.setButtonValue("+");
        ecran.clrscr("");
        button.emptyButton();
        
        button.setButtonValue("2");
        ecran.display(button.getButtonValue());
        secondNumber = Integer.parseInt(Button.getValue());
        button.setButtonValue("2");
        ecran.display(button.getButtonValue());
        secondNumber = Integer.parseInt(Button.getValue());
        button.setButtonValue("3");
        ecran.display(button.getButtonValue());
        secondNumber = Integer.parseInt(Button.getValue());
        button.setButtonValue("=");
        total = firstNumber + secondNumber;
        ecran.clrscr("");
        ecran.display(total);

    }
    
    /**
     * Method clears screen
     */
    public void clear() {
        button.setButtonValue("C");
        button.emptyButton();
        ecran.clrscr("");
        ecran.display("0");
    }
    /**
     * Method adds 2 digits introduced by user from keyboard
     */
    public void decrease(){
        ecran.clrscr("");
        button.setButtonValue("2");
        ecran.display(button.getButtonValue());
        firstNumber = Integer.parseInt(Button.getValue());
        button.setButtonValue("2");
        ecran.display(button.getButtonValue());
        firstNumber = Integer.parseInt(Button.getValue());
        button.setButtonValue("3");
        ecran.display(button.getButtonValue());
        firstNumber = Integer.parseInt(Button.getValue());

        button.setButtonValue("-");
        ecran.clrscr("");
        button.emptyButton();
        
        button.setButtonValue("1");
        ecran.display(button.getButtonValue());
        secondNumber = Integer.parseInt(Button.getValue());
        button.setButtonValue("2");
        ecran.display(button.getButtonValue());
        secondNumber = Integer.parseInt(Button.getValue());
        button.setButtonValue("2");
        ecran.display(button.getButtonValue());
        secondNumber = Integer.parseInt(Button.getValue());
        button.setButtonValue("=");
        total = firstNumber - secondNumber;
        ecran.clrscr("");
        ecran.display(total);
       
    }
    /**
     * Multiply 2 numbers introduced by the user
     */
    public void multiply(){
        ecran.clrscr("");
        button.setButtonValue("1");
        ecran.display(button.getButtonValue());
        firstNumber = Integer.parseInt(Button.getValue());
        button.setButtonValue("2");
        ecran.display(button.getButtonValue());
        firstNumber = Integer.parseInt(Button.getValue());
        button.setButtonValue("3");
        ecran.display(button.getButtonValue());
        firstNumber = Integer.parseInt(Button.getValue());

        button.setButtonValue("*");
        ecran.clrscr("");
        button.emptyButton();
        
        button.setButtonValue("1");
        ecran.display(button.getButtonValue());
        secondNumber = Integer.parseInt(Button.getValue());
        button.setButtonValue("2");
        ecran.display(button.getButtonValue());
        secondNumber = Integer.parseInt(Button.getValue());
        button.setButtonValue("=");
        total = firstNumber * secondNumber;
        ecran.clrscr("");
        ecran.display(total);
    }
    /**
     * Divide 2 numbers introduced by the user
     */
    public void divide(){
        ecran.clrscr("");
        button.setButtonValue("2");
        ecran.display(button.getButtonValue());
        firstNumber = Integer.parseInt(Button.getValue());
        button.setButtonValue("4");
        ecran.display(button.getButtonValue());
        firstNumber = Integer.parseInt(Button.getValue());

        button.setButtonValue("/");
        ecran.clrscr("");
        button.emptyButton();
        
        button.setButtonValue("6");
        ecran.display(button.getButtonValue());
        secondNumber = Integer.parseInt(Button.getValue());
        button.setButtonValue("=");
        total = firstNumber / secondNumber;
        ecran.clrscr("");
        ecran.display(total);
    }
}
