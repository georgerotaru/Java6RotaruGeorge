/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import java.util.HashSet;

/**
 *
 * @author George
 */
public class TestBook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ElectronicBook[] books = new ElectronicBook[3];
        EBook eBook = new EBook("Fata din tren", "978-606-719-350-3", new String[] {"PAULA HAWKINS"}, 
                new String[] {"http://www.elefant.ro/ebooks/ebooks/fata-din-tren-248404.html"}, new String[] {"none"}, 
                "TREI", 13.19f, ElectronicBook.ElectronicFormat.EPUB, ElectronicBook.YearOfPublication.Y2015);
        eBook.setRecommendedReader(EBook.EBookReaders.KINDLEFIRE);
        books[0] = eBook;
        for(int index = 0; index < 1; index++) {
            System.out.println("Book title: "+books[index].getTitle());
            System.out.println("Book ISBN: "+books[index].getIsbn());
            System.out.println("Book Publisher: "+books[index].getPublisher());
            String[] authorsOfThisBook = books[index].getAuthors();
            int numberOfAuthors = authorsOfThisBook.length;
            for(int currentAuthor=0; currentAuthor < numberOfAuthors; currentAuthor++) {
                System.out.println("Book author: "+ authorsOfThisBook[currentAuthor]);
            }
            System.out.println("Book Price: "+books[index].getPrice());
            System.out.println("Book format: "+books[index].getElectronicFormat());
            //System.out.println("Recommended reader: book[index].);
            System.out.println("Book year of publication: "+books[index].getYearOfPublication());
            String[] downloadLinks = books[index].getDownloadLinks();
            int numberOfDownloadLinks = downloadLinks.length;
            for(int currentDownloadLink=0; currentDownloadLink < numberOfDownloadLinks; currentDownloadLink++) {
                System.out.println("Download links "+ downloadLinks[currentDownloadLink]);
            }
            String[] bookRemarksAndNotes = books[index].getRemarksAndNotes();
            int numberOfReviews = bookRemarksAndNotes.length;
            for(int currentReview=0; currentReview < numberOfReviews; currentReview++) {
                System.out.println("Remarks and notes: "+ bookRemarksAndNotes[currentReview]);
            }
            System.out.println("***************************************");
        }
        
        HashSet<AddBook> books1 = new HashSet<>();
        books1.add(new AddBook("22-21", "Fata din tren"));
        books1.add(new AddBook("23-25", "Un barbat pe nume Owe"));
        books1.add(new AddBook("24-44", "Femeile vin de pe Venus, barbatii de la baut"));
        books1.add(new AddBook("25-01", "Palatul Puricilor"));
        books1.add(new AddBook("22-21", "Fugara"));
        
        System.out.println("Total number of books is "+books1.size()+".");
        for (AddBook elem1 : books1) {
            System.out.println("ISBN is "+elem1.getIsbn()+" and book title is \""+elem1.getTitle()+"\".");
        }     
        System.out.println("***************************************");
        
        HashSet<MakeHashEqual> books2 = new HashSet<>();
        books2.add(new MakeHashEqual("22-21", "Fata din tren"));
        books2.add(new MakeHashEqual("23-25", "Un barbat pe nume Owe"));
        books2.add(new MakeHashEqual("24-44", "Femeile vin de pe Venus, barbatii de la baut"));
        books2.add(new MakeHashEqual("25-01", "Palatul Puricilor"));
        books2.add(new MakeHashEqual("22-21", "Fugara"));
        
        System.out.println("Total number of books is "+books2.size()+".");
        for (MakeHashEqual elem2 : books2) {
            System.out.println("ISBN is "+elem2.getIsbn()+" and book title is \""+elem2.getTitle()+"\".");         
        }
        System.out.println("***************************************");       
    }
}
