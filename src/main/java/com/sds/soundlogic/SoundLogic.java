package com.sds.soundlogic;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;


/**
 * This class is used to create sound pattern in ascending and descending order of given range.
 * Given range could be any from 1 to 12
 * 
 * @Dependency : This class file is dependent upon JFugue(5.0.4) music library for java.
 * @DownloadLink : http://www.jfugue.org/download.html
 * @MavenInstall : mvn install:install-file -Dfile=jfugue-5.0.4.jar -DgroupId=org
 *               -DartifactId=jfugue -Dversion=5.0.4 -Dpackaging=jar
 * @author sunnydyal
 *
 */
public class SoundLogic {
  private final static char KEYBOARD[] = {'C', 'D', 'E', 'F', 'G', 'A', 'B'};
  private final static char KEYBOARD_INDIAN[] = {'S', 'R', 'G', 'M', 'P', 'D', 'N'};

  /**
   * Method returns array of key.
   * 
   * @param number
   * @return keys
   */
  public char[] getKeys(final long number) {
    char[] keys = new char[Toolbox.numberOfDigitInNumber(number) * 2 + 1];
    long value = number;
    int digit = 0;
    int count = 0;
    while (true) {
      digit = (int) (value % 10);
      value = value / 10;
      if (value == 0)
        break;

      keys[count] = KEYBOARD[digit - 1];
      count++;
      keys[count] = ' ';
      count++;
    }
    keys[count] = KEYBOARD[digit - 1];
    return keys;
  }

  /**
   * Method returns array of key.
   * 
   * @param number
   * @return keys
   */
  public char[] getIndianKeys(final long number) {
    char[] keys = new char[Toolbox.numberOfDigitInNumber(number) * 2 + 1];
    long value = number;
    int digit = 0;
    int count = 0;
    while (true) {
      digit = (int) (value % 10);
      value = value / 10;
      if (value == 0)
        break;

      keys[count] = KEYBOARD_INDIAN[digit - 1];
      count++;
      keys[count] = ' ';
      count++;
    }
    keys[count] = KEYBOARD_INDIAN[digit - 1];
    return keys;
  }

  public void play(Pattern pattern) {
    Player player = new Player();
    player.play(pattern);
  }


}
