/*
 * Square class creates the geometrical definition for a square
 */
package definitions;

/**
 * Square class extends Figure class and overrides getDefinition()
 * method to return the geometrical definition for a square
 * @author George
 */
public class Square extends Figure {
private static final String DEFINITION = "SQUARE: with four equal straight sides and four right angles.";
    /**
    * @return squareDefinition
    */
@Override
    public String getDefinition() {
        StringBuilder squareDefinition = new StringBuilder();
        squareDefinition.append(DEFINITION);
        squareDefinition.insert(8, super.getDefinition());
        return(squareDefinition.toString());
    }
    
}
