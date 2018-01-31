/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcconnection;

import java.util.List;

/**
 *
 * @author George
 */
public interface BookDAO {
    public List<EBooks>findAllBooks();
    
    public List<EBooks>searchBooksByKeyword(String keyWord);
    
    public List<BookGenres>findAllCategories();
    
    public void insert(EBooks book);
    
    public void update(EBooks book);
    
    public void delete(String bookId);
}
