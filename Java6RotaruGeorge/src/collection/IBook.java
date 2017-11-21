/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author George
 */
public class IBook extends ElectronicBook {

private static final String IPOD = "Apple iPod";
private static final String IPHONE = "Apple iPhone";
public enum IBookReaders { IPOD, IPHONE }

private IBookReaders iBookReaders;

    public IBook(String title, String isbn, String[] authors, String[] downloadLinks, 
            String[] remarksAndNotes, String publisher, float price, 
            ElectronicFormat electronicFormat, YearOfPublication yearOfPublication) {
        super(title, isbn, authors, downloadLinks, remarksAndNotes, 
                publisher, price, electronicFormat, yearOfPublication);
    }

    public IBookReaders getiBookReaders() {
        return iBookReaders;
    }

    public void setiBookReaders(IBookReaders iBookReaders) {
        this.iBookReaders = iBookReaders;
    }

}
