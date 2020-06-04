import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(OrderAnnotation.class)
public class DateValidatorTest {

  protected static final int MIN_DAY = 1;
  protected static final int MAX_DAY = 31;
  protected static final int MIN_MONTH = 1;
  protected static final int MAX_MONTH = 12;
  protected static final int MIN_YEAR = 1901;
  protected static final int MAX_YEAR = 2022;
  protected static final int FEB = 2;

  private DateValidator dateValidator = new DateValidator();

  @Test
  @Order(6)
  public void testInvalidDates() {
    assertTrue(dateValidator.isValidDate(0, 0, 1900) == false,
        "invalid date passed");

    assertTrue(dateValidator.isValidDate(1, 1, 1900) == false,
        "invalid year");
    assertTrue(dateValidator.isValidDate(1, 1, 2023) == false,
        "invalid month");
    assertTrue(dateValidator.isValidDate(1, 0, 1901) == false,
        "invalid month");
    assertTrue(dateValidator.isValidDate(1, 13, 1901) == false,
        "invalid month");
    assertTrue(dateValidator.isValidDate(0, 1, 1901) == false,
        "invalid day");
    assertTrue(dateValidator.isValidDate(32, 1, 1901) == false,
        "invalid day");

  }


  @Test
  @Order(7)
  public void testInvalidDatesAll() {
    testInvalidDateYears();
    testInvalidDateMonths();
    //    testInvalidDateDays();
  }

  @Test
  public void testInvalidDateYears() {
    for (int month = MIN_MONTH; month <= MAX_MONTH; month++) {
      int days = DateValidator.monthdays[month];
      for (int day = 1; day <= days; day++) {
        assertFalse(dateValidator.isValidDate(day, month, 0),
            "invalid year less than lower bound passed");
        assertFalse(dateValidator.isValidDate(day, month, 2023),
            "invalid year greater than upper bound passed");
      }
    }
  }


  @Test
  public void testInvalidDateMonths() {
    for (int year = MIN_YEAR; year <= MAX_YEAR; year++) {
      for (int month = MIN_MONTH; month <= MAX_MONTH; month++) {
        int days = DateValidator.monthdays[month];
        for (int day = 1; day <= days; day++) {
          assertFalse(dateValidator.isValidDate(day, 0, year),
              "invalid month less than lower bound passed");
          assertFalse(dateValidator.isValidDate(day, 13, year),
              "invalid month greater than upper bound passed");
        }
      }
    }
  }


  @Test
  @Order(2)
  public void testNonLeapDates() {
    assertTrue(dateValidator.isValidDate(28, 2, 2019) == true,
        "nonleap valid date " + "failed");
    assertTrue(dateValidator.isValidDate(29, 2, 2019) == false,
        "nonleap invalid " + "date passed");
  }

  @Test
  @Order(3)
  public void testNonLeapDatesAll() {
    for (int year = MIN_YEAR; year <= MAX_YEAR; year++) {
      if (dateValidator.isLeapYear(year) == false) {
        assertTrue(dateValidator.isValidDate(29, 2, year) == false,
            "nonleap invalid date " + "passed");
        assertTrue(dateValidator.isValidDate(28, 2, year) == true,
            "nonleap valid date" + "failed");
      }
    }
  }

  @Test
  @Order(4)
  public void testLeapDates() {
    assertTrue(dateValidator.isValidDate(29, 2, 2020) == true,
        "leap valid date " + "failed");
    assertTrue(dateValidator.isValidDate(28, 2, 2020) == true,
        "leap valid " + "date failed");
    assertTrue(dateValidator.isValidDate(29, 2, 2016) == true,
        "leap valid date " + "failed");
    assertTrue(dateValidator.isValidDate(28, 2, 2016) == true,
        "leap valid " + "date failed");
    assertTrue(dateValidator.isValidDate(30, 2, 2020) == false,
        "leap invalid date " + "passed");

  }

  @Test
  @Order(5)
  public void testLeapDatesAll() {
    for (int year = MIN_YEAR; year <= MAX_YEAR; year++) {
      if (dateValidator.isLeapYear(year) == true) {
        assertTrue(dateValidator.isValidDate(29, 2, year) == true,
            "leap valid date " + "failed");
        assertTrue(dateValidator.isValidDate(28, 2, year) == true,
            "leap valid date" + "failed");
        assertTrue(dateValidator.isValidDate(30, 2, year) == false,
            "leap invalid date" + "passed");

      }
    }
  }

  @Test
  @Order(1)
  public void testValidDatesAll() {

    for (int year = MIN_YEAR; year <= MAX_YEAR; year++) {
      for (int month = MIN_MONTH; month <= MAX_MONTH; month++) {
        int days = DateValidator.monthdays[month];
        for (int day = 1; day <= days; day++) {
          assertTrue(dateValidator.isValidDate(day, month, year) == true,
              "valid date " + "failed");

        }
      }
    }
  }
}
