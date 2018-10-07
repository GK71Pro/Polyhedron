package com.gkaraffa.polyhedron;

public class Die {
  private int sides = 0;
  private SingletonRandom srRandom = null;

  public Die() {
    srRandom = SingletonRandom.getSingletonRandom();
  }

  public Die(int sides) {
    this.sides = sides;
    srRandom = SingletonRandom.getSingletonRandom();
  }

  public int getSides() {
    return sides;
  }

  public void setSides(int sides) {
    this.sides = sides;
  }

  public int roll() {
    return (srRandom.getRandomizer().nextInt(sides) + 1);
  }
}
