package com.caseykulm.learnyourxjava.chapter3;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SectionSupressingOperatorsTest {
  private SectionSupressingOperators subj;

  @Before
  public void setUp() throws Exception {
    subj = new SectionSupressingOperators();
  }

  @Test
  public void filterExample() throws Exception {
    subj.strings.filter(s -> s.length() > 3)
        .subscribe(System.out::println);
  }

  @Test
  public void takeExample() throws Exception {
    Disposable disp = subj.strings.take(3)
        .subscribe(System.out::println);

    assertTrue(disp.isDisposed());
  }

  @Test
  public void takeIntervalExample() throws Exception {
    subj.interval
        .take(1, TimeUnit.SECONDS)
        .subscribe(System.out::println);

    TimeUnit.SECONDS.sleep(2);
  }

  @Test
  public void skipExample() throws Exception {
    subj.range
        .skip(90)
        .subscribe(System.out::println);
  }

  @Test
  public void takeWhileExample() throws Exception {
    subj.range
        .takeWhile(i -> i % 11 != 0)
        .subscribe(System.out::println);
  }

  @Test
  public void skipWhileExample() throws Exception {
    subj.range
        .skipWhile(i -> i % 90 != 0)
        .subscribe(System.out::println);
  }

  @Test
  public void distinctExample() throws Exception {
    subj.strings
        .distinct(String::length)
        .subscribe(System.out::println);
  }

  @Test
  public void distinctUntilChangedExample() throws Exception {
    subj.strings
        .distinctUntilChanged(String::length)
        .subscribe(System.out::println);
  }

  @Test
  public void elementAtExample() throws Exception {
    subj.strings
        .elementAt(3)
        .subscribe(System.out::println);

    subj.strings
        .elementAt(30, "nada")
        .subscribe(System.out::println);
  }
}