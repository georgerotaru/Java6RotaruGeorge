/*
 * Triangle class creates the geometrical definition for a triangle
 */
package definitions;

/**
 * Triangle class extends Figure class and overrides getDefinition()
 * method to return the geometrical definition for a triangle
 * @author George
 */
public class Triangle extends Figure {
private static final String DEFINITION = "TRIANGLE: with three straight sides and three angles.";
    /**
     * @return triangleDefinition
     */
    @Override
    public String getDefinition() {
        StringBuilder triangleDefinition = new StringBuilder();
        triangleDefinition.append(DEFINITION);
        triangleDefinition.insert(10, super.getDefinition());
        return(triangleDefinition.toString());
    }
    
}
