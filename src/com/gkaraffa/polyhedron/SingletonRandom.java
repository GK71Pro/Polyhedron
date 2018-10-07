package com.gkaraffa.polyhedron;

import java.util.*;

final class SingletonRandom {
  private SingletonRandom() {
    rRandom = new Random(new Date().getTime());
  }

  public Random getRandomizer() {
    return (rRandom);
  }

  public static synchronized SingletonRandom getSingletonRandom() {
    if (srRef == null) {
      // create
      srRef = new SingletonRandom();
    }

    return (srRef);
  }


  private static SingletonRandom srRef = null;
  private Random rRandom = null;
}
