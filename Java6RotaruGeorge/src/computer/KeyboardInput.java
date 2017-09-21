/*
 * User can input from keyboard numbers that he wants to calculate
 * and the operator to use
 */
package computer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * Read from keyboard numbers and operator
 * @author George
 */
public class KeyboardInput {
    
    static float getNumber() {
        Scanner readNumber = new Scanner(System.in);
        while (true) {
            System.out.print("Input number: ");
            try {
                return readNumber.nextFloat();
            }
            catch (java.util.InputMismatchException ime) {
                readNumber.nextLine();
                System.out.println("Wrong number input.Please try again!");
            }
        }
    }
    
    //http://javadevnotes.com/java-string-array-examples
    
    static String getOperator() {
        System.out.print("Input type of operation (+ - * / =): ");
        Scanner readOperator = new Scanner(System.in);
        String[] defaultOperators = {"+", "-", "*", "/", "="};
        String operatorToSearch = readOperator;
        boolean found = false;
        for (String element:defaultOperators) {
            if ( element.equals(defaultOperators)) {
                found = true;
            }
        }
        if (found) {
            break;
        } else {
        System.out.println("Wrong operator, please try again!");
        }
        return readOperator.next();
    }
}