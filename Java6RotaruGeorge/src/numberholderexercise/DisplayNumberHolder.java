/*
 * DisplayNumberHolder
 * Displays the value of the two numbers specified in the NumberHolder class
 */
package numberholderexercise;

/**
 * This class creates an instance of the class, initializes its two member 
 * variables, and then displays the value of each member variable
 * @author George
 */
public class DisplayNumberHolder {

    public static void main(String[] args) {
        NumberHolder numbers = new NumberHolder();
        numbers.anInt = 23;
        numbers.aFloat = 343.3453f;
        System.out.println("Value of integer number is: " + numbers.anInt);
        System.out.println("Value of float number is: " + numbers.aFloat);
    }
    
}
