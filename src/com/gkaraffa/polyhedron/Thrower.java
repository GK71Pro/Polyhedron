package com.gkaraffa.polyhedron;

import java.util.*;

public class Thrower {
  static public int throwBestMOfN(int iM, int iN, Die die) throws Exception {
    if (iM >= iN) {
      throw new Exception("M must be less than N");
    }

    int iArray[] = new int[iN];
    for (int index = 0; index < iN; index++) {
      iArray[index] = die.roll();
    }

    Arrays.sort(iArray);

    int iAccum = 0;
    for (int index = iN - 1; index > 0; index--) {
      iAccum += iArray[index];
    }

    return (iAccum);
  }
}
