import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class SingleTonTest {

  private SingleTon inst1;
  private SingleTon inst2;

  @Test
  void speedTest(){
    int lightspeed = 3 * (10 ^ 8);
    int pspeed = 2 * (10 ^ 8);
    try {
      assertTrue(pspeed > lightspeed, "Assertion failed");
    }catch(AssertionError e){
      e.printStackTrace();
    }
    System.out.println("done");
  }

  @Test
  void testAdd(){

    assertTrue(2 + 3 == 5, "assertion failed");
    System.out.println("done");
  }

  @Test
  void getInstance() {
    inst1 = SingleTon.getInstance();
    inst2 = SingleTon.getInstance();
    assertFalse(inst1 != inst2,"singleton instances are different");
    assertTrue(inst1 == inst2, "singleton instances differ");

  }
}
