package com.caseykulm.learnyourxjava.chapter2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SectionConnectableObservablesTest {
  private SectionConnectableObservables subj;

  @Before
  public void setUp() throws Exception {
    subj = new SectionConnectableObservables();
  }

  @Test
  public void bothObserversReceiveSameEventsInOrder() throws Exception {
    subj.source.subscribe(s -> System.out.println("Observer1: " + s));
    subj.source.map(String::length).subscribe(i -> System.out.println("Observer2: " + i));

    subj.source.connect();
  }
}