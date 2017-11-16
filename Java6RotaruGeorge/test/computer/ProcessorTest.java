/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author George
 */
public class ProcessorTest {
    
    public ProcessorTest() {
    }

    /**
     * Test of getPrimulOperand method, of class Processor.
     */
    @Test
    public void testGetPrimulOperand() {
        System.out.println("getPrimulOperand");
        Processor instance = new Processor();
        instance.setPrimulOperand(2.2);
        Double result = instance.getPrimulOperand();
        Double expResult = 2.2;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPrimulOperand method, of class Processor.
     */
    @Test
    public void testSetPrimulOperand() {
        System.out.println("setPrimulOperand");
        Processor instance = new Processor();
        Double primulOperand = 2.2;
        instance.setPrimulOperand(primulOperand);
        Double result = instance.getPrimulOperand();
        assertEquals(primulOperand, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAlDoileaOperand method, of class Processor.
     */
    @Test
    public void testGetAlDoileaOperand() {
        System.out.println("getAlDoileaOperand");
        Processor instance = new Processor();
        instance.setAlDoileaOperand(2.3);
        Double expResult = 2.3;
        Double result = instance.getAlDoileaOperand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setAlDoileaOperand method, of class Processor.
     */
    @Test
    public void testSetAlDoileaOperand() {
        System.out.println("setAlDoileaOperand");
        Processor instance = new Processor();
        Double alDoileaOperand = 2.3;
        instance.setAlDoileaOperand(alDoileaOperand);
        Double result = instance.getAlDoileaOperand();
        assertEquals(alDoileaOperand, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getOperator method, of class Processor.
     */
    @Test
    public void testGetOperator() {
        System.out.println("getOperator");
        Processor instance = new Processor();
        instance.setOperator('+');
        Character expResult = '+';
        Character result = instance.getOperator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setOperator method, of class Processor.
     */
    @Test
    public void testSetOperator() {
        System.out.println("setOperator");
        Processor instance = new Processor();
        Character operator = '-';
        instance.setOperator(operator);
        Character result = instance.getOperator();
        assertEquals(operator, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calculeaza method, of class Processor.
     */
    @Test
    public void testCalculeaza() {
        System.out.println("calculeaza");
        Processor instance = new Processor();
        instance.setPrimulOperand(2.2);
        instance.setAlDoileaOperand(4.3);
        instance.setOperator('+');
        Double expResult = 6.5;
        Double result = instance.calculeaza();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
