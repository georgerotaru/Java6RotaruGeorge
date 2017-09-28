/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardealer;

/**
 *
 * @author George
 */
public class CarApp {

    public static void main(String[] args) {
        ImplementCars car1 = new ImplementCars();
        car1.setBrand("Volkswagen");
        car1.setType("Passat");
        car1.setRentStatus(true);
        car1.setRentPrice(190);
        System.out.println("Car created = "+car1.getBrand()+" "+car1.getType()+"\n"
        +"Rent status: "+car1.getRentStatus()+car1.getRentPrice());
    }
    
}
