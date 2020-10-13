/**     @author Qianli Lu
 *      used for align text use two parameters for defaut align_left function usage:
 *     java AlignText file_name line_length .
 *     use three parameters for enhanced functions usage:
 *     java AlignText file_name line_length [align_mode] .
 *     for align_mode R stand for align right, C stand for align center, B stand for bubble
 */
public class AlignText {
  /** The main class for alignment */
  private static final int ARG_LENGTH_3 = 3;
  private static final int ARG_LENGTH_2 = 2;
  private static final int VACANT = 4;

  public static void main(String[] args) {
    // if the parameters is mis typed, return the usage info
    if (args.length < ARG_LENGTH_2 || !args[1].matches("[0-9]*")) {
      System.out.print("usage: java AlignText file_name line_length");
      return;
    }
    String[] str = Reader.readFile(args[0]);
    int length = Integer.parseInt(args[1]);
    // enhanced functions
    if (args.length >= ARG_LENGTH_3) {
      // Align right function
      if (args[2].equals("R")) {
        // align text for each paragraph entered
        for (String s : str) {
          printAlignRight(s, length);
          System.out.println();
        }
        return;
        // align center function
      } else if (args[2].equals("C")) {
        for (String s : str) {
          printAlignCentre(s, length);
          System.out.println();
        }
        return;
        // adding bubble function
      } else if (args[2].equals("B")) {
        // using string buffer to attach all the paragraphs
        StringBuffer sb = new StringBuffer();
        for (String s : str) {
          sb.append(s);
          sb.append(" ");
        }
        // calculate the length of the longest words appeared
        // then assign the size of the bubble
        String s = sb.toString();
        String[] strArr = s.split(" ");
        int len = length - VACANT;

        for (String temp : strArr) {
          if (temp.length() > len) {
            len = temp.length();
          }
        }
        // print upper bound of bubble
        System.out.print(" ");
        for (int i = 0; i < len + 2; i++) {
          System.out.print("_");
        }
        System.out.print(" ");
        System.out.println();
        // create the main body of bubble
        for (String s2 : str) {
          printBubble(s2, len, length - VACANT);
          System.out.println();
        }
        // print the bottom part of bubble
        System.out.print(" ");
        for (int i = 0; i < len + 2; i++) {
          System.out.print("-");
        }
        System.out.println();
        System.out.println("        \\");
        System.out.println("         \\");

        return;
      } else { // the default condition if other parameter detected
        for (String s : str) {
          printAlignLeft(s, length);
          System.out.println();
        }
        return;
      }
    }
    // Basic function align left if two parameters detected.
    for (String s : str) {
      printAlignLeft(s, length);
      System.out.println();
    }
  }

  /**
   * print left-aligned text.
   * @param s
   * @param length
   */
  public static void printAlignLeft(String s, int length) {
    String[] str = s.split(" ");
    int count = 0;
    // start a new line if the word exceeded the length
    for (int i = 0; i < str.length; i++) {
      if (count == 0) {
        System.out.print(str[i] + " ");
        count += str[i].length() + 1;
        continue;
      }
      count += str[i].length();
      if (count > length) {
        System.out.println();
        count = 0;
        i--;

      } else {
        System.out.print(str[i] + " ");
        count++;
      }
    }
  }

  /**
   * print center-aligned text
   * @param s
   * @param length
   */
  public static void printAlignCentre(String s, int length) {
    // calculate the vacant number and add to the head and tail of a text
    String[] str = s.split(" ");
    int vacantHead = 0;
    int count = 0;
    int pointer = 0;
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < str.length; i++) {
      if (count == 0) {
        sb.append(str[i]);
        sb.append(" ");
        count += str[i].length() + 1;
        if (i == str.length - 1) {
          count--;
          vacantHead = length - count;
          int tailVacant = vacantHead / 2;
          int headVacant = vacantHead - tailVacant;
          for (int j = 0; j < headVacant; j++) {
            sb.insert(pointer, " ");
          }
        }
        continue;
      }
      count += str[i].length();
      if (count > length) {
        sb.deleteCharAt(sb.length() - 1);
        count -= str[i].length() + 1;
        vacantHead = length - count;
        int tailVacant = vacantHead / 2;
        int headVacant = vacantHead - tailVacant;
        if (vacantHead >= 0) {
          for (int j = 0; j < headVacant; j++) {
            sb.insert(pointer, " ");
          }
        }
        sb.insert(sb.length(), "\n");
        count = 0;
        pointer = sb.length();
        i--;
      } else {
        if (i == str.length - 1) {

          vacantHead = length - count;
          int tailVacant = vacantHead / 2;
          int headVacant = vacantHead - tailVacant;
          for (int j = 0; j < headVacant; j++) {
            sb.insert(pointer, " ");
          }
        }
        sb.append(str[i]);
        sb.append(" ");
        count++;
      }
    }
    System.out.print(sb.toString());
  }

  /**
   * print right-aligned text.
   *
   * @param s
   * @param length
   */
  public static void printAlignRight(String s, int length) {
    // calculate the vacant number and add to the tail of a text
    String[] str = s.split(" ");
    int vacantHead = 0;
    int count = 0;
    int pointer = 0;
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < str.length; i++) {
      if (count == 0) {
        sb.append(str[i]);
        sb.append(" ");
        count += str[i].length() + 1;
        if (i == str.length - 1) {
          count--;
          vacantHead = length - count;
          for (int j = 0; j < vacantHead; j++) {
            sb.insert(pointer, " ");
          }
        }
        continue;
      }
      count += str[i].length();
      if (count > length) {
        sb.deleteCharAt(sb.length() - 1);
        count -= str[i].length() + 1;
        vacantHead = length - count;
        // System.out.print(length+"||\n");
        if (vacantHead >= 0) {
          for (int j = 0; j < vacantHead; j++) {
            sb.insert(pointer, " ");
          }
        }
        sb.insert(sb.length(), "\n");
        count = 0;
        pointer = sb.length();
        i--;
      } else {
        if (i == str.length - 1) {

          vacantHead = length - count;
          for (int j = 0; j < vacantHead; j++) {
            sb.insert(pointer, " ");
          }
        }
        sb.append(str[i]);
        sb.append(" ");
        count++;
      }
    }
    System.out.print(sb.toString());
  }

  /**
   * print bubble surrounding the text.
   * @param s
   * @param length
   * @param exepectLength
   */
  public static void printBubble(String s, int length, int exepectLength) {
    // add vacant and special symbols to the original text
    int count = 0;
    int pointer = 0;
    int vacantTail = 0;
    int len = length - VACANT;
    String[] str = s.split(" ");
    StringBuffer sb = new StringBuffer();

    sb.insert(pointer, "| ");
    for (int i = 0; i < str.length; i++) {
      if (count == 0) {
        sb.append(str[i]);
        sb.append(" ");
        count += str[i].length() + 1;

        if (i == str.length - 1) {
          count--;
          vacantTail = length - count;
          for (int j = 0; j < vacantTail; j++) {
            sb.append(" ");
          }
          sb.append("|");
        }
        continue;
      }
      count += str[i].length();
      // if next word exceeded the length create a new line
      if (count > exepectLength) {
        sb.deleteCharAt(sb.length() - 1);

        count -= str[i].length() + 1;
        // count--;
        vacantTail = length - count;
        for (int j = 0; j < vacantTail; j++) {
          sb.append(" ");
        }
        sb.append(" |" + "\n" + "| ");
        count = 0;
        pointer = sb.length();
        i--;

      } else {
        if (i == str.length - 1) {

          vacantTail = length - count;

          sb.append(str[i]);
          for (int j = 0; j < vacantTail; j++) {
            sb.append(" ");
          }
          sb.append(" |");
          continue;
        }
        sb.append(str[i]);
        sb.append(" ");
        count++;
      }
    }
    System.out.print(sb.toString());
  }
}

