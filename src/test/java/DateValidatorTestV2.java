import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Demonstrates single testclass instance for all test cases . Default
 * behavior in jupiter is PER_METHOD testclass instance creation
 */
@TestInstance(Lifecycle.PER_CLASS)
public class DateValidatorTestV2 {

  private DateValidator dateValidator;

  @BeforeAll
  public void setUp() {
    dateValidator = new DateValidator();
  }

  @Test
  public void testValidDate() {

    //dump "this" to check for same DateValidatorTestV2 instance
    System.out.println(this);
    assertTrue(dateValidator.isValidDate(29, 2, 2020),
        "valid date failed");
  }

  @Test
  public void testInValidDate() {
    //dump "this" to check for same DateValidatorTestV2 instance
    System.out.println(this);
    assertFalse(dateValidator.isValidDate(29, 2, 2019),
        "invalid date passed");
  }

  @AfterAll
  public void cleanUp() {
    System.out.println("exiting tests-execution");
  }
}
