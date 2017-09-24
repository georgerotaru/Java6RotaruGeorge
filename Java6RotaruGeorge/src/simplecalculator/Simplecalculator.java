/*
 * Simplecalculator
 * This is a calculator that reads 2 numbers and a mathematical operator
 * from user input and displays the result according to the given
 * operator
 * It also shows a warning in case of any bad insertion
 */
package simplecalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

/**
 * The Simplecalculator class provides a calculator that does basic 
 * mathematical operations after the user inputs 2 numbers and the
 * desired operator
 * @author George
 */
public class Simplecalculator {
    private static DecimalFormat df2 = new DecimalFormat(".##");

    public static void main(String[] args) throws IOException {
        double a = 0;
        double b = 0;
        BufferedReader readKeyboard = new BufferedReader(new InputStreamReader(System.in));
        /** user inputs first number and tests if it is a number*/
        System.out.print("Please introduce your first number: ");
        try {
            String input = readKeyboard.readLine();
            a = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Sorry, you introduced wrong data. I quit :)");
            System.exit(0);
        }
        List<String> defaultOperators = Arrays.asList("+", "-", "*", "/");
        /** user inputs operator and tests if it is in given list*/
        System.out.print("Please introduce operator(+/-/*//): ");
        String operator = readKeyboard.readLine();
        if (defaultOperators.contains(operator)) {
            /** user inputs second number and tests if it is a number*/
            System.out.print("Please introduce your second number: ");
                try {
                    String input = readKeyboard.readLine();
                    b = Double.parseDouble(input);
                } catch (NumberFormatException e) {
                System.out.println("Sorry, you introduced wrong data. I quit :)");
                System.exit(0);
                }
        } else {
            System.out.println("Sorry, you introduced wrong data. I quit :)");
            System.exit(0);
        }
        /** user inputs equal sign and tests if it matches "="*/
        System.out.print("Please introduce \"=\": ");
        String equalSign = readKeyboard.readLine();
        if ("=".equals(equalSign)) {
            /** if valid equal sign, does math according to given operator*/
            switch (operator) {
                case "+": a += b;
                    System.out.println("Result is: "+df2.format(a));
                    break;
                case "-": a -= b;
                    System.out.println("Result is: "+df2.format(a));
                    break;
                case "*": a *= b;
                    System.out.println("Result is: "+df2.format(a));
                    break;
                case "/": if (b != 0) {
                    a /= b;
                    System.out.println("Result is: "+df2.format(a));
                    } else {
                        System.out.println("You cannot devide a number by 0 !\n"
                                + "I quit :)");
                        System.exit(0);
                    }
                break;
                default: break;
            }
        } else {
            System.out.println("Sorry, you introduced wrong data. I quit :)");
            System.exit(0);
        }
    }
}
