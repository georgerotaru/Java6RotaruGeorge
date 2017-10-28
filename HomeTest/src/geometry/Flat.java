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
public class Flat extends Shape {
    protected String definiton = "plana ";
    
    protected String getParentDefinition() {
        String parentDefinition = super.definition;
        return parentDefinition;
    }
}
