/*
 * Layer class creates a list of all definitions and can print to console
 * one or all items
 */
package definitions;

import java.util.LinkedList;

/**
 * Layer class creates a list which contains all definitions and iterates 
 * through it in order to print to console one or all of its elements
 * @author George
 */
public class Layer {
private LinkedList<String> shapes;
private String triangle;
private String square;
private String rectangle;
private String circle;

// this method creates a LinkedList in which the definitions are stored
    public void addToList() {
        shapes = new LinkedList<>();
        Circle circleDefinition = new Circle();
        shapes.add(circleDefinition.getDefinition());
        Rectangle rectangleDefinition = new Rectangle();
        shapes.add(rectangleDefinition.getDefinition());
        Square squareDefinition = new Square();
        shapes.add(squareDefinition.getDefinition());
        Triangle triangleDefinition = new Triangle();
        shapes.add(triangleDefinition.getDefinition());
    }
 
// this method prints to console all definitions
    public void defineAllFigures() {
        System.out.println("Definitions of all figures are:");
        shapes.forEach(System.out::println);
    }

//this method prints to console the definition for triangle    
    public void defineTriangle() {
        triangle = "TRIANGLE";
        for (String search:shapes) {
            if (search.contains(triangle)) {
                System.out.println(search);
            }
        }
    }

//this method prints to console the definition for square    
    public void defineSquare() {
        square = "SQUARE";
        for (String search:shapes) {
            if (search.contains(square)) {
                System.out.println(search);
            }
        }
    }

//this method prints to console the definition for rectangle    
    public void defineRectangle() {
        rectangle = "RECTANGLE";
        for (String search:shapes) {
            if (search.contains(rectangle)) {
                System.out.println(search);
            }
        }
    }

//this method prints to console the definition for circle    
    public void defineCircle() {
        circle = "CIRCLE";
        for (String search:shapes) {
            if (search.contains(circle)) {
                System.out.println(search);
            }
        }
    }  
}
