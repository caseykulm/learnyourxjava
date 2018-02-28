package com.caseykulm.learnyourxjava.chapter2;

import org.junit.Before;
import org.junit.Test;

public class SectionMaybeTest {
  private SectionMaybe subj;

  @Before
  public void setUp() throws Exception {
    subj = new SectionMaybe();
  }

  @Test
  public void maybeWithData() throws Exception {
    subj.maybeWithData.subscribe(
        System.out::println,
        Throwable::printStackTrace,
        () -> System.out.println("onComplete"));
  }

  @Test
  public void maybeWithoutData() throws Exception {
    subj.maybeWithoutData.subscribe(
        System.out::println,
        Throwable::printStackTrace,
        () -> System.out.println("onComplete"));
  }
}