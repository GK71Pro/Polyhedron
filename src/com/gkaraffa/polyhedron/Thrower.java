package com.gkaraffa.polyhedron;

import java.util.*;

public class Thrower {
  public static int throwBestMOfN(int iM, int iN, Die die) throws IllegalArgumentException {
    if (iM >= iN) {
      throw new IllegalArgumentException("M must be less than N");
    }

    int iArray[] = new int[iN];
    for (int index = 0; index < iN; index++) {
      iArray[index] = die.roll();
    }

    Arrays.sort(iArray);

    int iAccum = 0;
    int rightExt = iN - 1;
    int leftExt = (iN - iM) - 1;
    for (int index = rightExt; index > leftExt; index--) {
      iAccum += iArray[index];
    }

    return (iAccum);
  }
  
  public static int throwNTimes(int iN, Die die) {
    int iAccum = 0;
    for (int index = 0; index < iN; index++) {
      iAccum += die.roll();
    }
    
    return iAccum;
  }
    
  public static Results throwRoll(Roll roll) {
    int tosses = roll.getTosses();
    int aggreg = 0;
    int resAry[] = new int[tosses];
    Die die = roll.getDie();
    
    for (int index = 0; index < tosses; index ++) {
      resAry[index] = die.roll();
      aggreg += resAry[index];
    }
    
    return new Results(resAry, aggreg);
  }
}
