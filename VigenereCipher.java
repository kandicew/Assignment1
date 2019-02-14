package assignment1;

import java.io.PrintWriter;

public class VigenereCipher {

  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    /** incorrect number of arguments */
    if (args.length != 3) {
      System.err.println("Incorrect number of parameters");
      System.exit(2);
    } else {
      /** if the key word is empty string, no shifting letters */
      if ((args[2]).equals("")) {
        args[2] = "a";
      }
      /** make keyword the same length as the string */
      String keyword = makecode(args[1], args[2]);
      /** if encoding */
      if ((args[0]).equals("encode")) {
        pen.println(encode(args[1], keyword));
      } /** if decoding */
      else if ((args[0]).equals("decode")) {
        pen.println(decode(args[1], keyword));
      } /** if instructions invalid */
      else {
        System.err.println("Valid options are encode or decode");
        System.exit(1);
      }
    }
  }// main

  /**
   * Precondition: str and code not empty and all letters in lowercase Postcondition:code is the
   * same length as str by repeating itself
   */
  public static String makecode(String str, String code) {
    /** make a new array for code that is the same length as str */
    char[] temparr = new char[str.length()];
    /** make the original code into an array */
    char[] codearr = code.toCharArray();
    /** placing the letter of code into the new array */
    for (int i = 0; i < str.length(); i++) {
      if (i < code.length()) {
        temparr[i] = codearr[i];
      } /** if goes over, start from the beginning again */
      else {
        temparr[i] = codearr[i % code.length()];
      }
    }
    /** change back to string */
    code = new String(temparr);
    return code;
  }// makecode

  /**
   * Precondition: str and code not empty and all letters in lowercase Postcondition: each letter in
   * str is changed by adding the corresponding letter in code
   */
  public static String encode(String str, String code) {
    /** change str and code into array */
    char[] charray = str.toCharArray();
    char[] codearray = code.toCharArray();
    int base = (int) 'a';
    for (int i = 0; i < str.length(); i++) {
      /** compute a number to shift the letter in str */
      int n = (int) codearray[i] - base;
      if (((int) charray[i] + n) <= (int) 'z') {
        charray[i] = (char) ((int) charray[i] + n);
      } /** if exceeds z */
      else {
        int temp = (int) charray[i] - 26;
        charray[i] = (char) (temp + n);
      }
    }

    str = new String(charray);
    return str;
  }// encode

  /**
   * Precondition: str and code not empty and all letters in lowercase Postcondition: each letter in
   * str is changed by subtracting the corresponding letter in code
   */
  public static String decode(String str, String code) {
    /** change str and code into array */
    char[] charray = str.toCharArray();
    char[] codearray = code.toCharArray();
    int base = (int) 'a';
    for (int i = 0; i < str.length(); i++) {
      /** compute a number to shift the letter in str */
      int n = (int) codearray[i] - base;
      if (((int) charray[i] - n) >= (int) 'a') {
        charray[i] = (char) ((int) charray[i] - n);
      } /** if exceeds a */
      else {
        int temp = (int) charray[i] + 26;
        charray[i] = (char) (temp - n);
      }
    }

    str = new String(charray);
    return str;
  }// decode
}
