/*
 * User can input from keyboard numbers that he wants to calculate
 * and the operator to use
 */
package computer;

import java.util.Scanner;


/**
 * Read from keyboard numbers and operator
 * @author George
 */
public class KeyboardInput {
    
    /*public static boolean contains(String[] operatorList, String item) {
        List<String> operators = Arrays.asList(operatorList);
        return operators.contains(item);
    }*/
    
    String[] defaultOperators = {"+", "-", "/", "*", "="};
    
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
    
    static String getOperator() {
        System.out.print("Input type of operation (+ - * / =): ");
        Scanner readOperator = new Scanner(System.in);
        return readOperator.next();
    }
}