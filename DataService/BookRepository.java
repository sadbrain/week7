package DataService;

import java.util.ArrayList;
import Models.Book;
public class BookRepository {
    protected SimpleDataAccess context;

    public BookRepository(SimpleDataAccess context) {
        this.context = context;
    }
    
    public void saveChange() {context.saveChanges();}

    public ArrayList<Book> books () {return context.getBooks();}

    public Book[] select() {return context.getBooks().toArray(new Book[context.getBooks().size()]);}

    public Book select(int id){
        for (Book b : context.getBooks()) {
            if(b.getId() == id){
                return b;
            }
        }
        return null;
    }
    public void insert(Book book){
        int i = context.getBooks().size();
        int id = i == 0 ? 1 : context.getBooks().get(i-1).getId() + 1;
        book.setId(id);
        context.getBooks().add(book);
    }

    public boolean update(int id, Book book){
        Book b = select(id);
        if(b == null) return false;
        b.setAuthor(book.getAuthor());
        b.setName(book.getName());
        b.setCategory(book.getCategory());
        b.setShell(book.getShell());
        b.setPrice(book.getPrice());
        b.setBookStatus(book.getBookStatus());
        return true;
    }
    public boolean delete(int id)
    {
        Book b = select(id);
        if (b == null) return false;
        context.getBooks().remove(b);
        return true;
    } 

}
