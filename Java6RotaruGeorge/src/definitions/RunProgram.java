/*
 * RunProgram class executes the program
 */
package definitions;

import java.util.Scanner;

/**
 * RunProgram class (main) asks the user whether to print to console all definitions
 * or a definition of their choice by inputing 'DEFALL', 'DEFC', 'DEFR', 'DEFS'
 * or 'DEFT'. If other options are entered, it will display a warning message
 * and exit.
 * @author George
 */
public class RunProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Layer getDefinition = new Layer();
        // create a list with all definitions
        getDefinition.addToList();
        // print to console the user's options
        System.out.println("\u001B[34m"+"Choose one of the options bellow:"
                + "\nDEFALL - for all definitions"
                + "\nDEFC - for circle definition"
                + "\nDEFR - for rectangle definition"
                + "\nDEFS - for square definition"
                + "\nDEFT - for triangle definition");
        // read the user's option
        Scanner sc = new Scanner(System.in);
        System.out.print("\u001B[0m");
        String inputChoice = sc.next().toLowerCase();
        // display definitions according to user's option
        switch (inputChoice) {
            case "defall" : getDefinition.defineAllFigures();
                            break;
            case "defc" : getDefinition.defineCircle();
                            break;
            case "defr" : getDefinition.defineRectangle();
                            break;
            case "defs" : getDefinition.defineSquare();
                            break;
            case "deft" : getDefinition.defineTriangle();
                            break;
            default: System.out.println("\u001B[31m"+"Invalid input!");
                     break;
        }
    }
    
}
