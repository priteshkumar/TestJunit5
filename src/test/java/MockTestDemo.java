import java.util.HashMap;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_CLASS)
public class MockTestDemo {

  /**
   * mock bookcatalog class to simulate dependency
   */
  private static class BookCatalog{
    private HashMap<String,Boolean> bookMap = new HashMap<String, Boolean>();

    public boolean addBook(String book){
      if(bookMap.get(book) != null)
        return false;
      else
        bookMap.put(book,true);
      return true;
    }

    public void clearCatalog(){
      this.bookMap.clear();
    }
  }

  private static BookCatalog bookCatalog;

  @BeforeAll
  public void setUp(){
    bookCatalog = new BookCatalog();
  }

  @Test
  public void testAddBook(){
    assertTrue(bookCatalog.addBook("jenkins2 complete"),"addbook failed");
    assertTrue(bookCatalog.addBook("java8 complete"),"addbook failed");
    assertFalse(bookCatalog.addBook("jenkins2 complete"),"invalid "
        + "addbook passed");
  }

  @AfterAll
  public void cleanUp(){
    bookCatalog.clearCatalog();
  }
}
