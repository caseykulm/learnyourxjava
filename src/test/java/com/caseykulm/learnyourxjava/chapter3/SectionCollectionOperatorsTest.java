package com.caseykulm.learnyourxjava.chapter3;

import java.util.Comparator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SectionCollectionOperatorsTest {
  private SectionCollectionOperators subj;

  @Before
  public void setUp() throws Exception {
    subj = new SectionCollectionOperators();
  }

  @Test
  public void toListExample() throws Exception {
    subj.words
        .toList()
        .subscribe(System.out::println);
  }

  @Test
  public void toSortedListExample() throws Exception {
    subj.words
        .toSortedList(Comparator.comparingInt(String::length))
        .subscribe(System.out::println);
  }
}