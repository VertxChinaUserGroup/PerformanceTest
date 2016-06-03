package io.vertx.test.deadcode;

import static io.vertx.test.deadcode.DeadCode.calcFibonacci;

/**
 * Test Dead Code.
 * @author yz
 * @date 5/18/16
 */
public class DeadCodeTest {

  final private static long NANOS_PER_MS = 1000000L;
  final private static int NUMBER = 50;

  volatile int result;

  /**
   *
   * @param iterations
   */
  public void doTest1(long iterations) {
    long startTime = System.nanoTime();
    for (long i = 0; i < iterations; i++) {
      calcFibonacci(NUMBER);  // Dead Code.
    }

    long elapsedTime = System.nanoTime() - startTime;

    System.out.println("    迭代" + iterations/1000000 + "百万次消耗时间(ns) -> " + elapsedTime);
    float mills = elapsedTime / NANOS_PER_MS;
    float itrsPerMs = 0;
    if (mills != 0) {
      itrsPerMs = iterations / mills;
    }

    System.out.println("    每ms迭代次数 ---->" + itrsPerMs);
  }

  public void doTest2(long iterations) {
    int answer = 0;
    long startTime = System.nanoTime();
    for (long i = 0; i < iterations; i++) {
      answer = calcFibonacci(NUMBER);
    }

    long elapsedTime = System.nanoTime() - startTime;
    System.out.println("    结果 -> " + answer);
    System.out.println("    迭代" + iterations/1000000 + "百万次消耗时间(ns) -> " + elapsedTime);

    float millis = elapsedTime / NANOS_PER_MS;

    float itrsPerMs = 0;
    if (millis != 0) {
      itrsPerMs = iterations / millis;
    }

    System.out.println("    每ms迭代次数 ---->" + itrsPerMs);
  }

  public void doTest3(long iterations) {
    long startTime = System.nanoTime();
    for (long i = 0; i < iterations; i++) {
      result = calcFibonacci(NUMBER);
    }

    long elapsedTime = System.nanoTime() - startTime;
    System.out.println("    结果 -> " + result);
    System.out.println("    迭代" + iterations/1000000 + "百万次消耗时间(ns) -> " + elapsedTime);

    float millis = elapsedTime / NANOS_PER_MS;

    float itrsPerMs = 0;
    if (millis != 0) {
      itrsPerMs = iterations / millis;
    }

    System.out.println("    每ms迭代次数 ---->" + itrsPerMs);
  }
}
