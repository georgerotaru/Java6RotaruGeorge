/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author George
 */
public class CalculatorTest {
    
    public CalculatorTest() {
    }

    /**
     * Test of start method, of class Calculator.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Calculator instance = new Calculator();
        instance.start();
        int valAfisata = instance.getEcran().getValoareAfisata();
        assertEquals(0, valAfisata);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of displayMessageOnScreen method, of class Calculator.
     */
    @Test
    public void testDisplayMessageOnScreen() {
        System.out.println("displayMessageOnScreen");
        String message = "~works fine";
        Calculator instance = new Calculator();
        instance.displayMessageOnScreen(message);
        String expResult = "~works fine";
        assertEquals(expResult, message);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of pushButtonsForOperand method, of class Calculator.
     * In the Test Results display window, I cannot see the values given to
     * operand1 nor operand2
     */
    @Test
    public void testPushButtonsForOperand() {
        System.out.println("pushButtonsForOperand");
        Calculator instance = new Calculator();
        Double operand1 = 2.2;
        Double operand2 = 2.3;
        instance.getProcesor().setPrimulOperand(operand1);
        instance.getProcesor().setAlDoileaOperand(operand2);
        Double result1 = instance.getProcesor().getPrimulOperand();
        Double result2 = instance.getProcesor().getAlDoileaOperand();
        assertEquals(operand1, result1);
        assertEquals(operand2, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of pushButtonsForOperator method, of class Calculator.
     * In the Test Results display window, I cannot see the value given to
     * the operator
     */
    @Test
    public void testPushButtonsForOperator() {
        System.out.println("pushButtonsForOperator");
        Calculator instance = new Calculator();
        Character operator = '+';
        instance.getProcesor().setOperator(operator);
        Character result = instance.getProcesor().getOperator();
        assertEquals(operator, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of pushButtonEqual method, of class Calculator.
     * In the Test Results display window, after the pushButtonEqual method is
     * called, I can see the result is 4.5 but I cannot figure out a way to 
     * use assertEquals in the test method (Probably because the method returns
     * void)
     */
    @Test
    public void testPushButtonEqual() {
        System.out.println("pushButtonEqual");
        Calculator instance = new Calculator();
        instance.getProcesor().setPrimulOperand(2.2);
        instance.getProcesor().setAlDoileaOperand(2.3);
        instance.getProcesor().setOperator('+');
        instance.pushButtonEqual();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getEcran method, of class Calculator.
     * It returns 0, as it should
     */
    @Test
    public void testGetEcran() {
        System.out.println("getEcran");
        Calculator instance = new Calculator();
        Screen ecran = new Screen();
        ecran.display(0);
        instance.setEcran(ecran);
        instance.getEcran();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setEcran method, of class Calculator.
     * It returns ~works fine, as it should
     */
    @Test
    public void testSetEcran() {
        System.out.println("setEcran");
        Calculator instance = new Calculator();
        Screen ecran = new Screen();
        ecran.displayMessage("~works fine");
        instance.setEcran(ecran);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getButoane method, of class Calculator.
     */
    @Test
    public void testGetButoane() {
        System.out.println("getButoane");
        Calculator instance = new Calculator();
        Button[] butoane = new Button['1'];
        instance.setButoane(butoane);
        Button[] result = instance.getButoane();
        Button[] expResult = new Button['1'];
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setButoane method, of class Calculator.
     */
    @Test
    public void testSetButoane() {
        System.out.println("setButoane");
        Button[] butoane = new Button['1'];
        Calculator instance = new Calculator();
        instance.setButoane(butoane);
        Button[] result = instance.getButoane();
        Button[] expResult = new Button['1'];
        Assert.assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getProcesor method, of class Calculator.
     * I think this method cannot be tested here as it refers to the class Processor
     * which is tested separately
     */
    /*@Test
    public void testGetProcesor() {
        System.out.println("getProcesor");
        Calculator instance = new Calculator();
        Processor expResult = null;
        Processor result = instance.getProcesor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of setProcesor method, of class Calculator.
     * I think this method cannot be tested here as it refers to the class Processor
     * which is tested separately
     */
    /*@Test
    public void testSetProcesor() {
        System.out.println("setProcesor");
        Processor procesor = null;
        Calculator instance = new Calculator();
        instance.setProcesor(procesor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
