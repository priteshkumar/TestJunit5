import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

/*Default testclass instantiation is PER_METHOD
  This allows each testcase to be executed in isolation
 PER_CLASS annotation ensures test class is instantiated only once
 All test cases are executed on same testclass instance
 */
//@TestInstance(Lifecycle.PER_CLASS) //uncomment to set PER_CLASS
@TestMethodOrder(OrderAnnotation.class) //forces ordered test execution
public class SingleTonTest {

  private SingleTon inst1;
  private SingleTon inst2;

  @Test
  @Order(2)
  void speedTest() {
    System.out.println(this);
    int lightspeed = 2 * (10 ^ 8);
    int pspeed = 3 * (10 ^ 8);
    try {
      assertTrue(pspeed > lightspeed, "Assertion failed");
    } catch (AssertionError e) {
      e.printStackTrace();
    }
    System.out.println("done");
  }

  @Test
  @Order(1)
  void testAdd() {
    System.out.println(this);
    // assertEquals(true, 5 == 2 + 1,"not equal sum");
    assertTrue(2 + 3 == 5, "assertion failed");
  }

  @Test
  @Order(3)
  void getInstance() {
    System.out.println(this);
    inst1 = SingleTon.getInstance();
    inst2 = SingleTon.getInstance();
    assertFalse(inst1 != inst2, "singleton instances are different");
    assertTrue(inst1 == inst2, "singleton instances differ");

  }
}
