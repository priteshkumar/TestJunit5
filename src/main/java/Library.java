import java.util.*;

public class Library {
  private BookCatalog bookCatalog;

  public boolean addBook(Book book){
    if(bookCatalog.exists(book.getName()))
      return false;
    return bookCatalog.save(book);
  }

  public BookCatalog getBookCatalog(){
    return this.bookCatalog;
  }

  public void setBookCatalog(BookCatalog bookCatalog){
    this.bookCatalog = bookCatalog;
  }
}
