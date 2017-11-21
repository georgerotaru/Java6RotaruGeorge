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
public class ElectronicBook {
    
public static final int Y2015 = 2015;
public static final int Y2016 = 2016;
public enum YearOfPublication {Y2015, Y2016}

public static final String EPUB = "EPUB";
public static final String BBEB = "BBeB";
public enum ElectronicFormat { EPUB, BBEB }

private String title;
private String isbn;
private String[] authors;
private String[] downloadLinks;
private String[] remarksAndNotes;
private String publisher;
private float price;
private ElectronicFormat electronicFormat;
private YearOfPublication yearOfPublication;

    public ElectronicBook(String title, String isbn, String[] authors, String[] downloadLinks, 
            String[] remarksAndNotes, String publisher, float price, 
            ElectronicFormat electronicFormat, YearOfPublication yearOfPublication) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
        this.downloadLinks = downloadLinks;
        this.remarksAndNotes = remarksAndNotes;
        this.publisher = publisher;
        this.price = price;
        this.electronicFormat = electronicFormat;
        this.yearOfPublication = yearOfPublication;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String[] getAuthors() {
        return authors;
    }

    public String[] getDownloadLinks() {
        return downloadLinks;
    }

    public String[] getRemarksAndNotes() {
        return remarksAndNotes;
    }

    public String getPublisher() {
        return publisher;
    }

    public float getPrice() {
        return price;
    }

    public ElectronicFormat getElectronicFormat() {
        return electronicFormat;
    }

    public YearOfPublication getYearOfPublication() {
        return yearOfPublication;
    }

}