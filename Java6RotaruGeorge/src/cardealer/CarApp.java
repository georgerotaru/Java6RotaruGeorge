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
        int rentedCars = 0;
        ImplementCars car1 = new ImplementCars("Volkswagen", "Passat", 7200, 110, false, true);
        ImplementCars car2 = new ImplementCars("BMW", "320D", 11700, 180, true, false);
        ImplementCars car3 = new ImplementCars("Opel", "Zafira", 3100, 40, true, false);
        ImplementCars car4 = new ImplementCars("Mercedes", "E220", 19000, 240, false, false);
        ImplementCars car5 = new ImplementCars("Nissan", "Juke", 8200, 120, false, false);
        ImplementCars car6 = new ImplementCars("Ford", "Mondeo", 9700, 140, true, false);
        ImplementCars car7 = new ImplementCars("BMW", "X5", 17000, 230, false, true);
        ImplementCars car8 = new ImplementCars("Porsche", "Cayenne", 31000, 370, false, false);
        ImplementCars car9 = new ImplementCars("Volkswagen", "Golf", 6300, 90, false, false);
        ImplementCars car10 = new ImplementCars("Renault", "Laguna", 4100, 60, true, false);
        ImplementCars car11 = new ImplementCars("Ford", "Focus", 3900, 45, false, false);
        ImplementCars car12 = new ImplementCars("Smart", "ForFour", 5500, 80, false, true);

        System.out.println("Total cars dealed: "+ImplementCars.totalCarsDealed());
        System.out.println("Sold cars: "+ImplementCars.totalCarsSold());
        System.out.println(ImplementCars.soldCarList());
        System.out.println("Rented cars: "+ImplementCars.totalCarsRented());
        System.out.println(ImplementCars.rentedCarList());
        System.out.println("Cars in parking lot:");
        System.out.println(ImplementCars.parkingLot());

        
    }
    
}
