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
public class EBook extends ElectronicBook {
    
private static final String KINDLEFIRE = "Amazon Kindle Fire";
private static final String CALIBRE = "Sony Calibre";
public enum EBookReaders { KINDLEFIRE, CALIBRE }

private EBookReaders recommendedReader;

    public EBook(String title, String isbn, String[] authors, String[] downloadLinks, 
            String[] remarksAndNotes, String publisher, float price, 
            ElectronicFormat electronicFormat, YearOfPublication yearOfPublication) {
        super(title, isbn, authors, downloadLinks, remarksAndNotes, publisher, price, electronicFormat, yearOfPublication);
        getRecommendedReader();
    }

    public EBookReaders getRecommendedReader() {
        return recommendedReader;
    }

    public void setRecommendedReader(EBookReaders recommendedReader) {
        this.recommendedReader = recommendedReader;
    }


}
