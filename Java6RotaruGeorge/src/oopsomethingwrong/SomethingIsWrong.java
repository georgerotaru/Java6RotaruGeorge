/*
 * SomethingIsWrong
 * The given program didn't had a ...
 */
package oopsomethingwrong;

import java.awt.Rectangle;

/**
 * The class calculates the area of a rectangle
 * @author George
 */
public class SomethingIsWrong {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Rectangle myRect = new Rectangle();
        myRect.width = 40;
        myRect.height = 50;
        int area = myRect.width * myRect.height;
        System.out.println("myRect's area is " + area);
    }
}
