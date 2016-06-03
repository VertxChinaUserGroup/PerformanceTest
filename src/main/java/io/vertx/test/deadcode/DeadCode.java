package io.vertx.test.deadcode;

/**
 * Test JIT compile some code to DeadCode.
 *
 * @author yz
 * @date 5/17/16
 */
public class DeadCode {
  /**
   * Fibonacci impl
   * @param n
   * @return
   */
  public static int calcFibonacci(int n) {
    int result = 1;
    int prev = -1;
    int sum;
    for (int i = 0; i <= n; i++) {
      sum = prev + result;
      prev = result;
      result = sum;
    }

    return result;
  }
}
