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
public class ScreenTest {
    
    public ScreenTest() {
    }

    /**
     * Test of display method, of class Screen.
     * It displays 0 on Test Results window, as it should
     */
    @Test
    public void testDisplay() {
        System.out.println("display");
        int valueToDisplay = 0;
        Screen instance = new Screen();
        instance.display(valueToDisplay);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class Screen.
     * It displays 0 on Test Results window, as it should
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Screen instance = new Screen();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getValoareAfisata method, of class Screen.
     */
    @Test
    public void testGetValoareAfisata() {
        System.out.println("getValoareAfisata");
        Screen instance = new Screen();
        int expResult = 0;
        instance.setValoareAfisata(0);
        int result = instance.getValoareAfisata();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setValoareAfisata method, of class Screen.
     */
    @Test
    public void testSetValoareAfisata() {
        System.out.println("setValoareAfisata");
        int valoareAfisata = 0;
        Screen instance = new Screen();
        instance.setValoareAfisata(valoareAfisata);
        int result = instance.getValoareAfisata();
        int expResult = 0;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of displayMessage method, of class Screen.
     */
    @Test
    public void testDisplayMessage() {
        System.out.println("displayMessage");
        String message = "";
        Screen instance = new Screen();
        instance.displayMessage(message);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
