/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

/**
 *
 * @author George
 */
public class MainForSayGoodbye {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create 2 different threads
        SayGoodbye sgb = new SayGoodbye();
        SayGoodbyeAgain sgba = new SayGoodbyeAgain();
        
        System.out.println("SGB status is "+sgb.getState());
        System.out.println("SGBA status is "+sgba.getState());
        //set priorities
        sgb.setPriority(1);
        sgba.setPriority(10);
        //start 2 threads
        sgb.start();
        sgba.start();
        
        System.out.println("SGB status is "+sgb.getState());
        System.out.println("SGBA status is "+sgba.getState());
    }
    
}
