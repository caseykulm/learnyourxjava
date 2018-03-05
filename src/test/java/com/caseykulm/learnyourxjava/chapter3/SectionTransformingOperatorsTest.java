package com.caseykulm.learnyourxjava.chapter3;

import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SectionTransformingOperatorsTest {
  private SectionTransformingOperators subj;

  @Before
  public void setUp() throws Exception {
    subj = new SectionTransformingOperators();
  }

  @Test
  public void mapExample() throws Exception {
    subj.words
        .map(w -> w.substring(1) + w.charAt(0) + "ay")
        .subscribe(System.out::println);
  }

  @Test
  public void startWithExample() throws Exception {
    subj.words
        .startWith("Not a haiku...")
        .subscribe(System.out::println);
  }

  @Test
  public void startWithArrayExample() throws Exception {
    subj.words
        .startWithArray("Not a haiku", "============")
        .subscribe(System.out::println);
  }

  @Test
  public void defaultIfEmptyExample() throws Exception {
    subj.words
        .filter(w -> w.contains("wabbit"))
        .defaultIfEmpty("no wabbits")
        .subscribe(System.out::println);
  }

  @Test
  public void switchIfEmptyExample() throws Exception {
    subj.words
        .filter(w -> w.contains("wabbit"))
        .switchIfEmpty(subj.otherWords)
        .subscribe(System.out::println);
  }

  @Test
  public void sortedExample() throws Exception {
    subj.words
        .sorted(Comparator.comparingInt(String::length))
        .subscribe(System.out::println);
  }

  @Test
  public void delayExample() throws Exception {
    subj.words
        .delay(500, TimeUnit.MILLISECONDS)
        .subscribe(System.out::println);

    TimeUnit.SECONDS.sleep(1);
  }

  @Test
  public void repeatExample() throws Exception {
    subj.words
        .repeat(3)
        .subscribe(System.out::println);
  }

  @Test
  public void scanExample() throws Exception {
    subj.range
        .scan((acc, next) -> acc + next)
        .subscribe(System.out::println);
  }

  @Test
  public void scanWordCountExample() throws Exception {
    subj.words
        .scan(0, (acc, next) -> acc + 1)
        .subscribe(System.out::println);
  }
}