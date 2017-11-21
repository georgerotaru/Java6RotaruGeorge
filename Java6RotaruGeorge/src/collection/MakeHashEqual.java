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
public class MakeHashEqual {

private String isbn;
private String title;

    public MakeHashEqual(String bookNo, String bookTitle) {
        isbn = bookNo;
        title = bookTitle;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
 
    @Override
    public int hashCode() {
        int hash = 3;
        int a = Integer.parseInt(this.isbn.replaceAll("[\\D]", ""));
        hash = 37 * hash + a;
        return hash; 
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MakeHashEqual other = (MakeHashEqual) obj;
        if (this.isbn != other.isbn) {
            return false;
        }
        return true;
    }
    
}
