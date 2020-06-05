import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.Math;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

class Upgrad {
  public boolean prime(int n) {
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0)
        return false;
    }
    return true;
  }
}


public class TestPrimeGen {
  private static Upgrad upgrad;

  @BeforeAll
  public static void setUp(){
    upgrad = new Upgrad();
  }

  @Test
  public void testPrime(){
    assertTrue(upgrad.prime(17),"prime number validation failed");
    assertFalse(upgrad.prime(20),"invalid prime number passed");
  }

}

