/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

import java.text.DecimalFormat;

/**
 *
 * @author George
 */
public class TestWithMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String a = "435.766";
        DecimalFormat dtime = new DecimalFormat("#.##");
        Double b = Double.valueOf(dtime.format(a));
        System.out.println(b);
    }
    
}
