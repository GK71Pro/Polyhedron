package com.gkaraffa.polyhedron;

public class Results {
  int[] rollResults;
  int rollAggregate;
  
  public Results(int[] rollResults, int rollAggregate) {
    this.rollResults = rollResults;
    this.rollAggregate = rollAggregate;
  }

  public int[] getRollResults() {
    return rollResults;
  }

  public int getRollAggregate() {
    return rollAggregate;
  }

}
