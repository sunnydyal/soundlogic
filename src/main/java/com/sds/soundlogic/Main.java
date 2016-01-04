package com.sds.soundlogic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Main {
  private static final int LOW = 1;
  private static final int HIGH = 7;
  private static final int QUANTITY = 9;

  public static void main(String[] args) throws InterruptedException {
    SoundLogic soundLogic = new SoundLogic();
    long randomNumber = Toolbox.generateRandomNumber(HIGH, LOW, QUANTITY);
    long reverseNumber = Toolbox.reverseNumber(randomNumber);

    // System.out.println(randomNumber + " | " + reverseNumber);
    // System.out.println(new String(soundLogic.getKeys(reverseNumber)) + " | "
    // + new String(soundLogic.getKeys(randomNumber)));
    long randomNumberPlus = 0;
    long mainNumber = randomNumber;

    Stack<String> decendingOrder = new Stack<String>();
    Queue<String> ascendingOrder = new LinkedList<String>();

    ascendingOrder.add(new String(soundLogic.getIndianKeys(reverseNumber)));
    decendingOrder.push(new String(soundLogic.getIndianKeys(randomNumber)));
    System.out.println("Aaroh...");
    while (randomNumberPlus != randomNumber) {
      randomNumberPlus = Toolbox.addOneToEachDigit(mainNumber, HIGH, LOW);
      reverseNumber = Toolbox.reverseNumber(randomNumberPlus);

      // System.out.println(randomNumberPlus + " | " + reverseNumber);
      // System.out.println(new String(soundLogic.getIndianKeys(reverseNumber)) + " | "
      // + new String(soundLogic.getIndianKeys(randomNumberPlus)));

      System.out.println(new String(soundLogic.getIndianKeys(reverseNumber)));

      ascendingOrder.add(new String(soundLogic.getIndianKeys(reverseNumber)));
      decendingOrder.push(new String(soundLogic.getIndianKeys(randomNumberPlus)));

      // soundLogic.play(new String(soundLogic.getKeys(reverseNumber)));
      // Thread.sleep(5000);
      mainNumber = randomNumberPlus;
    }
    System.out.println("Avroh...");
    while (!decendingOrder.isEmpty()) {
      System.out.println(decendingOrder.pop());
    }
    // soundLogic.play("[Flute] C D E E E E E D   E F E E  E D D B4 D C");

    // Pattern p1 = new Pattern("C D E E E E E D   E F E E  E D D B4 D C").setInstrument("Flute");
    // soundLogic.play(p1);



  }
}
