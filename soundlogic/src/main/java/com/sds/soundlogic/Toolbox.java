package com.sds.soundlogic;

import java.util.Random;

public class Toolbox {
  /**
   * Method will return a reverse order of given number.
   * 
   * @param number
   * @return
   */
  public static long reverseNumber(long number) {
    long reverseNumber = 0;
    long value = number;
    while (true) {
      reverseNumber = ((reverseNumber * 10) + (value % 10));
      value = value / 10;
      if (value == 0)
        break;
    }
    return reverseNumber;
  }

  /**
   * Generating random number of provided quantity in between two high and low range
   * 
   * @param high
   * @param low
   * @param quantity
   * @return
   */
  public static long generateRandomNumber(final int high, final int low, final int quantity) {
    Random r = new Random();
    long randomPlus = 0;
    // TODO - Quantity limit should be validated
    for (int i = 1; i <= quantity; i++) {
      int nextInt = r.nextInt(high + 1 - low);
      long result = (long) nextInt + low;
      randomPlus = ((randomPlus * 10) + result);
    }
    r = null;
    return randomPlus;
  }

  /**
   * Returns number of digits in a given number
   * 
   * @param number
   * @return
   */
  public static int numberOfDigitInNumber(long number) {
    long value = number;
    long digit = 0;
    int count = 0;
    while (true) {
      digit = ((digit * 10) + (value % 10));
      value = value / 10;
      if (value == 0)
        break;
      count++;
    }
    return count;
  }

  /**
   * Adding 1 to each digit of given number. Added number should not be greater then high value
   * 
   * @param number
   * @return
   */
  public static long addOneToEachDigit(long number, final int high, final int low) {
    long remainder = 0;
    long remainderPlusOne = 0;
    long sum = 0;
    while (number != 0) {
      remainder = number % 10;
      remainderPlusOne = remainder == high ? remainder = low : remainder + 1;
      if (remainderPlusOne == 10)
        remainderPlusOne = 0;
      number = number / 10;
      sum = (sum * 10) + remainderPlusOne;
    }
    remainderPlusOne = 0;
    while (sum != 0) {
      remainder = sum % 10;
      sum = sum / 10;
      remainderPlusOne = (remainderPlusOne * 10) + remainder;
    }
    return remainderPlusOne;
  }


}
