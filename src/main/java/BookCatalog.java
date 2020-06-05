import java.util.*;

class Book{
  private String name;

  public Book(String name){
    this.name = name;
  }

  public String getName(){
    return this.name;
  }
}

public class BookCatalog {
  private HashMap<String,Book> bookMap = new HashMap();

  public boolean exists(String book){
    return (bookMap.get(book) != null);
  }

  public boolean save(Book book){
      bookMap.put(book.getName(),book);
      return true;
  }
}
