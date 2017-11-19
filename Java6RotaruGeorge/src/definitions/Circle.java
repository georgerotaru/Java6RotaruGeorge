/*
 * Circle class creates the geometrical definition for a circle
 */
package definitions;

/**
 * Circle class extends Figure class and overrides getDefinition() method
 * to return the geometrical definition for a circle
 * @author George
 */
public class Circle extends Figure {
private static final String DEFINITION = "CIRCLE: whose boundary (the circumference) consists of points equidistant from a fixed point (the center).";

    /**
     * @return circleDefinition
     */
    @Override
    public String getDefinition() {
        StringBuilder circleDefinition = new StringBuilder();
        circleDefinition.append(DEFINITION);
        circleDefinition.insert(8, super.getDefinition());
        return circleDefinition.toString();
    }
    
}
