package com.caseykulm.learnyourxjava.chapter2;

import io.reactivex.Observable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SectionHotObservablesTest {
  private SectionHotObservables subj;
  private SectionHotObservables.Toggle toggle;

  @Before
  public void setUp() throws Exception {
    subj = new SectionHotObservables();
    toggle = new SectionHotObservables.Toggle();
  }

  @Test
  public void whenSubscribeHappensIsTimeSensitive() throws Exception {
    Observable<Boolean> hotObs1 = subj.toggleObservable(toggle);
    hotObs1.subscribe(state -> System.out.println("Hot Observer 1: " + state));

    toggle.toggle();
    toggle.toggle();

    Observable<Boolean> hotObs2 = subj.toggleObservable(toggle);
    hotObs2.subscribe(state -> System.out.println("Hot Observer 2: " + state));

    toggle.toggle();
    toggle.toggle();
  }
}