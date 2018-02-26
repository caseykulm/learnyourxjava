package com.caseykulm.learnyourxjava.chapter2;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SectionColdObservablesTest {
  private SectionColdObservables subj;

  @Before
  public void setUp() throws Exception {
    subj = new SectionColdObservables();
  }

  @Test
  public void subscribeTwiceReceivesSameData() throws Exception {
    List<String> observer1Data = new ArrayList<>();
    List<String> observer2Data = new ArrayList<>();

    subj.source.subscribe(s -> {
      observer1Data.add(s);
      System.out.println("Observer 1 Received: " + s);
    });
    subj.source.subscribe(s -> {
      observer2Data.add(s);
      System.out.println("Observer 2 Received: " + s);
    });

    Assert.assertArrayEquals(observer1Data.toArray(), observer2Data.toArray());
  }
}