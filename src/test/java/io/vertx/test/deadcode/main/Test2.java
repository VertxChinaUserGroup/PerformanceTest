package io.vertx.test.deadcode.main;

import io.vertx.test.deadcode.DeadCodeTest;
import org.junit.Test;

/**
 * @author yz
 * @date 5/18/16
 */
public class Test2 {
  public static void main(String[] args) {
    DeadCodeTest test = new DeadCodeTest();
    System.out.println("Warming up ...");
    test.doTest2(1000000L);
    System.out.println("Warm up done.");
    System.out.println("Starting measurement interval ...");
    test.doTest2(100000000L);
    System.out.println("Measurement interval done.");
    System.out.println("Test completed.");
  }


  @Test
  public void test2() {
    DeadCodeTest test = new DeadCodeTest();
    System.out.println();
    System.out.println("Warming up ...");
    test.doTest2(1000000L);
    System.out.println("Warm up done.");
    System.out.println("Starting measurement interval ...");
    test.doTest2(100000000L);
    System.out.println("Measurement interval done.");
    System.out.println("Test completed.");
  }

}
