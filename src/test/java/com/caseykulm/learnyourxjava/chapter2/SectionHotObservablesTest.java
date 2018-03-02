package com.caseykulm.learnyourxjava.chapter2;

import com.caseykulm.learnyourxjava.models.Toggle;
import io.reactivex.Observable;
import org.junit.Before;
import org.junit.Test;

public class SectionHotObservablesTest {
  private SectionHotObservables subj;
  private Toggle toggle;

  @Before
  public void setUp() throws Exception {
    subj = new SectionHotObservables();
    toggle = new Toggle();
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