package com.caseykulm.learnyourxjava.chapter2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SectionCompletableTest {
  private SectionCompletable subj;

  @Before
  public void setUp() throws Exception {
    subj = new SectionCompletable();
  }

  @Test
  public void doSomeWork() throws Exception {
    subj.completable.subscribe(System.out::println, Throwable::printStackTrace);
  }
}