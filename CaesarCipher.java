package assignment1;

import java.io.PrintWriter;

public class CaesarCipher {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    /**
     * if there are not exactly two arguments in the command line exit with code 2
     */
    if (args.length != 2) {
      System.err.println("Incorrect number of parameters");
      System.exit(2);
    } else {
      /** if encoding */
      if ((args[0]).equals("encode")) {
        for (int i = 0; i < 26; i++) {
          pen.println("n=" + i + ", " + encode(args[1], i));
        }
      } /** if decoding */
      else if ((args[0]).equals("decode")) {
        for (int i = 0; i < 26; i++) {
          pen.println("n=" + i + ", " + decode(args[1], i));
        }
      } /** if argument incorrect */
      else {
        System.err.println("Valid options are encode or decode");
        System.exit(1);
      }
    }
  }// main

  /**
   * Precondition: str is not empty and all letters in lowercase, n is nonnegative Postcondition:
   * each letter in str is changed by adding n
   */
  public static String encode(String str, int n) {
    /** change str to an array */
    char[] charray = str.toCharArray();
    /** shifting each letter by n */
    for (int i = 0; i < str.length(); i++) {
      /** if not exceeds z */
      if (((int) charray[i] + n) <= (int) 'z') {
        charray[i] = (char) ((int) charray[i] + n);
      } /** if exceeds z */
      else {
        int temp = (int) charray[i] - 26;
        charray[i] = (char) (temp + n);
      }
    }
    /** change back to string */
    str = new String(charray);

    return str;
  }// encode

  /**
   * Precondition: str is not empty and all letters in lowercase, n is nonnegative Postcondition:
   * each letter in str is changed by subtracting n
   */
  public static String decode(String str, int n) {
    /** change str to an array */
    char[] charray = str.toCharArray();
    /** shifting each letter by n */
    for (int i = 0; i < str.length(); i++) {
      /** if not exceeds a */
      if (((int) charray[i] - n) >= (int) 'a') {
        charray[i] = (char) ((int) charray[i] - n);
      } /** if exceeds a */
      else {
        int temp = (int) charray[i] + 26;
        charray[i] = (char) (temp - n);
      }
    }
    /** change back to string */
    str = new String(charray);

    return str;
  }// decode
}
