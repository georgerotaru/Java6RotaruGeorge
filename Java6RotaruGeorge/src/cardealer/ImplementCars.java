/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardealer;

public class ImplementCars {

private String brand, type;
int rentPrice;
boolean rentStatus;

public ImplementCars() {
    brand = "Default brand";
    type = "Default brand";
}

public String getBrand() {
    return(brand);
}

public void setBrand(String newBrand) {
    brand = newBrand;
}

public String getType() {
    return(type);
}

public void setType(String newType) {
    type = newType;
}

public int getRentPrice() {
    return(rentPrice);
}

public void setRentPrice(int newRentPrice) {
    rentPrice = newRentPrice;
}
}
