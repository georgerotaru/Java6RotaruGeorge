/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visibility;

import Visibility.packageOne.Alpha;
import Visibility.packageOne.Beta;
import Visibility.packageTwo.Gama;

/**
 *
 * @author George
 */
public class TestVisibility {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alpha alphaObject = new Alpha();
        Beta betaObject = new Beta();
        Gama gamaObject = new Gama();
        System.out.println("Test visibility Alpha class: public var "+alphaObject.publicVarA);
        //System.out.println("Test visibility Alpha class: protected var "+alphaObject.protectedVarA);
        //System.out.println("Test visibility Alpha class: private var "+alphaObject.privateVarA);
        //System.out.println("Test visibility Alpha class: package var "+alphaObject.packageVarA);
        
        System.out.println("Test visibility Alpha class: public method:alphaObject.testInternVariables()");
        alphaObject.testInternVariables();
        
        System.out.println("Test visibility Beta class: public method:betaObject.testInternVariables()");
        betaObject.testInheritedVariables();
        
        System.out.println("Test visibility Gama class: public method:gamaObject.testInheretedVariables()");
        gamaObject.testInheritedVariables();
        System.out.println("Test visibility Gama class: public method:gamaObject.testParentVariables()");
        gamaObject.testParentVariables();
        System.out.println("TestVisibility to Gama members: "+gamaObject.publicVarG);
        System.out.println("TestVisibility to Gama members: "+gamaObject.publicVarA);
        System.out.println("Test visibility Gama class: public method:gamaObject.testInternVariables()");
        gamaObject.testInternVariables();
    }
    
}
