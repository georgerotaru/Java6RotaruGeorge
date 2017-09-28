/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardealer;

public class ImplementCars {

private String carBrand, carModel;
private int carSellPrice, carRentPrice;
private boolean rentedCar, soldCar;
private static int carsDealed, totalSoldCars, totalRentedCars;
private static String soldCars = "";
private static String rentedCars = "";
private static String remainingCars = "";

public ImplementCars(String brand, String model, int sellPrice, int rentPrice,
        boolean rentable, boolean sold) {
    carBrand = brand;
    carModel = model;
    carSellPrice = sellPrice;
    carRentPrice = rentPrice;
    rentedCar = rentable;
    soldCar = sold;
    carsDealed++;

    if (soldCar == true)
        totalSoldCars++;
    if (soldCar == true)
        soldCars += "Car sold: "+carBrand+" "+carModel+" for :"+carSellPrice+" euro\n";
    if (rentedCar == true)
        totalRentedCars++;
    if (rentedCar == true)
        rentedCars += "Car rented: "+carBrand+" "+carModel+" for :"+carRentPrice+" euro per day\n";
    if (rentedCar == false && soldCar == false)
        remainingCars += "Brand: "+carBrand+", Model "+carModel+", rent price: "
                +carRentPrice+" euro, selling price: "+carSellPrice+" euro.\n";
}

public String getBrand() {
    return(carBrand);
}
public String getModel() {
    return(carModel);
}
public int sellingPrice() {
    return(carSellPrice);
}
public int rentingPrice() {
    return(carRentPrice);
}
public boolean rentableCar() {
    return(rentedCar);
}
public boolean carSold() {
    return(soldCar);
}
public static int totalCarsDealed() {
    return(carsDealed);
}
public static int totalCarsSold() {
    return(totalSoldCars);
}
public static int totalCarsRented() {
    return(totalRentedCars);
}
public static String soldCarList() {
    return(soldCars);
}
public static String rentedCarList() {
    return(rentedCars);
}
public static String parkingLot() {
    return(remainingCars);
}
}