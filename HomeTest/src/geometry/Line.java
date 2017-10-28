/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometry;

/**
 *
 * @author George
 */
public class Line extends Flat implements Defineable {
    String definition = "determinata de doua puncte.";

    @Override
    public String getDefinition() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String parentDefinition = super.definiton;
        String grandpaDefinition = super.getParentDefinition();
        String finalDefinition = grandpaDefinition+parentDefinition+definition;
        return finalDefinition;
    }
    
}
