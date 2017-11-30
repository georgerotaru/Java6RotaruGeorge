/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package definitions;

/**
 *
 * @author George
 */
public class Rectangle extends Figure {
private static final String DEFINITION = "RECTANGLE: with four straight sides and four right angles, especially one with unequal adjacent sides, in contrast to a square.";
    /**
     *
     * @return
     */
    @Override
    public String getDefinition() {
        StringBuilder rectangleDefinition = new StringBuilder();
        rectangleDefinition.append(DEFINITION);
        rectangleDefinition.insert(11, super.getDefinition());
        return rectangleDefinition.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
