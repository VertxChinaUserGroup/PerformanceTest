package io.vertx.test.deadcode.main;

import io.vertx.test.deadcode.DeadCodeTest;
import org.junit.Test;

/**
 * @author yz
 * @date 5/18/16
 */
public class Test3 {
  public static void main(String[] args) {
    DeadCodeTest test = new DeadCodeTest();
    System.out.println("Warming up ...");
    test.doTest3(1000000L);
    System.out.println("Warm up done.");
    test.doTest3(100000000L);
    System.out.println("Measurement interval done.");
    System.out.println("Test completed.");
  }

  @Test
  public void test3() {
    DeadCodeTest test = new DeadCodeTest();
    System.out.println();
    System.out.println("Warming up ...");
    test.doTest3(1000000L);
    System.out.println("Warm up done.");
    test.doTest3(100000000L);
    System.out.println("Measurement interval done.");
    System.out.println("Test completed.");
  }
}
