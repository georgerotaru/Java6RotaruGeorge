/*
 * Testing the car implementation
 */
package oop;

/**
 *
 * @author George
 */
public class TestCar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create three Car instances using all 'three' constructors
        Car firstCar = new Car();
        short speed2 = 230;
        Car secondCar = new Car("Mercedes", speed2, Car.Color.GRAY);
        Car thirdCar = new Car();
        //set color of first car to yellow
        firstCar.setColor(Car.Color.YELLOW);
        //set speed of second class to 120
        speed2 = 120;
        secondCar.setSpeed(speed2);
        //set name of third car
        thirdCar.setName("Volvo");
        //increase the speed of first car to 200
        short speed1 = 200;
        firstCar.increaseSpeed(speed1);
        //decrease the speed of second car to 60
        speed2 = 60;
        secondCar.decreaseSpeed(speed2);
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("firstCar: ");
        System.out.println("firstCar.Name: "+ firstCar.getName());
        System.out.println("firstCar.Color: "+ firstCar.getColor());
        System.out.println("firstCar.Speed: "+ firstCar.getSpeed());
        System.out.println("firstCar.DailyRentingPrice:: "+ firstCar.getDailyRentPrice());
        System.out.println("firstCar.SalePrice:: "+ firstCar.getSalePrice());
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("secondCar: ");
        System.out.println("secondCar.Name: "+ secondCar.getName());
        System.out.println("secondCar.Color: "+ secondCar.getColor());
        System.out.println("secondCar.Speed: "+ secondCar.getSpeed());
        System.out.println("secondCar.DailyRentingPrice:: "+ secondCar.getDailyRentPrice());
        System.out.println("secondCar.SalePrice:: "+ secondCar.getSalePrice());
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("thirdCar: ");
        System.out.println("thirdCar.Name: "+ thirdCar.getName());
        System.out.println("thirdCar.Color: "+ thirdCar.getColor());
        System.out.println("thirdCar.Speed: "+ thirdCar.getSpeed());
        System.out.println("thirdCar.DailyRentingPrice:: "+ thirdCar.getDailyRentPrice());
        System.out.println("thirdCar.SalePrice:: "+ thirdCar.getSalePrice());
        System.out.println("+++++++++++++++++++++++++++++++++");
    }
    
}
