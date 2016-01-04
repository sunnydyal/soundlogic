package com.sds.soundlogic;

import org.jfugue.pattern.Pattern;


public class Main {
  private static final int LOW = 1;
  private static final int HIGH = 7;
  private static final int QUANTITY = 9;

  public static void main(String[] args) throws InterruptedException {
    SoundLogic soundLogic = new SoundLogic();
    long randomNumber = Toolbox.generateRandomNumber(HIGH, LOW, QUANTITY);
    long reverseNumber = Toolbox.reverseNumber(randomNumber);

    System.out.println(randomNumber + " | " + reverseNumber);
    System.out.println(new String(soundLogic.getKeys(reverseNumber)) + " | "
        + new String(soundLogic.getKeys(randomNumber)));
    long randomNumberPlus = 0;
    long mainNumber = randomNumber;
    while (randomNumberPlus != randomNumber) {
      randomNumberPlus = Toolbox.addOneToEachDigit(mainNumber, HIGH, LOW);
      reverseNumber = Toolbox.reverseNumber(randomNumberPlus);
      System.out.println(randomNumberPlus + " | " + reverseNumber);
      System.out.println(new String(soundLogic.getKeys(reverseNumber)) + " | "
          + new String(soundLogic.getKeys(randomNumberPlus)));

      // soundLogic.play(new String(soundLogic.getKeys(reverseNumber)));
      // Thread.sleep(5000);
      mainNumber = randomNumberPlus;
    }
    // soundLogic.play("[Flute] C D E E E E E D   E F E E  E D D B4 D C");

    Pattern p1 = new Pattern("C D E E E E E D   E F E E  E D D B4 D C").setInstrument("Flute");
    soundLogic.play(p1);



  }
}
