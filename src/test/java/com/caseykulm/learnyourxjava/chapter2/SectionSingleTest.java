package com.caseykulm.learnyourxjava.chapter2;

import org.junit.Before;
import org.junit.Test;

public class SectionSingleTest {
  private SectionSingle subj;

  @Before
  public void setUp() throws Exception {
    subj = new SectionSingle();
  }

  @Test
  public void observableToSingleWithFirst() throws Exception {
    subj.observableToSingle.subscribe(System.out::println);
  }

  @Test
  public void emptyObservableToSingleWithFirst() throws Exception {
    subj.emptySingle.subscribe(System.out::println);
  }
}