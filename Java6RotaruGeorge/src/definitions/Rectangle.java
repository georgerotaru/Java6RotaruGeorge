/*
 * Rectangle class creates the geometrical definition for a rectangle
 */
package definitions;

/**
 * Rectangle class extends Figure class and overrides getDefinition()
 * method to return the geometrical definition for a rectangle
 * @author George
 */
public class Rectangle extends Figure {
private static final String DEFINITION = "RECTANGLE: with four straight sides and four right angles, especially one with unequal adjacent sides, in contrast to a square.";
    /**
     * @return rectangleDefinition
     */
    @Override
    public String getDefinition() {
        StringBuilder rectangleDefinition = new StringBuilder();
        rectangleDefinition.append(DEFINITION);
        rectangleDefinition.insert(11, super.getDefinition());
        return rectangleDefinition.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
