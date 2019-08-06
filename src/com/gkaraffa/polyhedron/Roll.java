package com.gkaraffa.polyhedron;

public class Roll {
  private int tosses;
  private Die die;

  public Roll(int tosses, Die die) {
    this.tosses = tosses;
    this.die = die;
  }

  public int getTosses() {
    return tosses;
  }

  public Die getDie() {
    return die;
  }


  private static boolean nonZeroCheck(char c) {
    int i = (int) c;

    if ((i < 49) || (i > 57)) {
      return false;
    }

    return true;
  }

  private static boolean validateString(String rollString) {
    // format nDrr
    // 3-4 character length
    // 2nd character must be 'D' or 'd'
    // 1st character must be non zero integer
    // 3rd character must be non zero integer
    // 4th character may be empty or non zero integer


    // validate length
    int length = rollString.length();
    if ((length < 3) || (length > 4)) {
      return false;
    }

    // validate 2nd character
    char dChar = rollString.charAt(1);
    if (!((dChar == 'D') || (dChar == 'd'))) {
      return false;
    }

    // validate 1st and 3rd characters
    if (!nonZeroCheck(rollString.charAt(0))) {
      return false;
    }

    if (!nonZeroCheck(rollString.charAt(2))) {
      return false;
    }

    if (length == 4) {
      if (!Character.isDigit(rollString.charAt(3))) {
        return false;
      }
    }

    return true;
  }

  public static Roll createRoll(String rollString) throws IllegalArgumentException {

    // validate
    if (!validateString(rollString)) {
      throw new IllegalArgumentException("Input string not properly formatted");
    }

    // parse
    int tosses = Integer.parseInt(rollString.substring(0, 1));

    int die;
    if (rollString.length() == 4) {
      die = Integer.parseInt(rollString.substring(2, 4));
    }
    else {
      die = Integer.parseInt(rollString.substring(2, 3));
    }

    // int less = 0;

    // create Roll
    Roll roll = new Roll(tosses, new Die(die));

    // return Roll;
    return roll;
  }

}
