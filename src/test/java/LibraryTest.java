import java.util.regex.Matcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class LibraryTest {

  @Mock
  private BookCatalog mockCatalog;

  @InjectMocks
  private Library library;

  @BeforeEach
  public void setUp(){
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testAddBook(){
    when(mockCatalog.save(any(Book.class))).thenReturn(true);
    Book book = new Book("jenkins2");
    assertTrue(library.addBook(book),"add book failed");

  }

  @Test
  public void testAddBookRandom(){
    Book book = new Book("Docker");
    when(mockCatalog.save(any(Book.class))).thenReturn(true,true,false);
    assertTrue(library.addBook(book),"add book passed");
    book = new Book("Awsec2");
    assertTrue(library.addBook(book),"add book passed");
    assertFalse(library.addBook(book),"existing book add passed");
  }
}
