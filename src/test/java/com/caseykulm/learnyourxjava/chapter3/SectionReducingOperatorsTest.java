package com.caseykulm.learnyourxjava.chapter3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SectionReducingOperatorsTest {
  private SectionReducingOperators subj;

  @Before
  public void setUp() throws Exception {
    subj = new SectionReducingOperators();
  }

  @Test
  public void countExample() throws Exception {
    subj.words
        .count()
        .subscribe(System.out::println);
  }

  @Test
  public void reduceExample() throws Exception {
    subj.words
        .reduce(new StringBuilder(), (acc, next) -> acc.append(next).append(" "))
        .map(StringBuilder::toString)
        .subscribe(System.out::println);
  }

  @Test
  public void allExample() throws Exception {
    subj.words
        .all(s -> s.length() > 2)
        .subscribe(System.out::println);

    subj.words
        .all(s -> s.length() > 3)
        .subscribe(System.out::println);
  }

  @Test
  public void anyExample() throws Exception {
    subj.words
        .any(s -> s.length() > 7)
        .subscribe(System.out::println);

    subj.words
        .any(s -> s.length() > 5)
        .subscribe(System.out::println);
  }

  @Test
  public void containsExample() throws Exception {
    subj.words
        .contains("dog")
        .subscribe(System.out::println);

    subj.words
        .contains("cat")
        .subscribe(System.out::println);
  }
}