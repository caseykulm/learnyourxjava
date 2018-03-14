package com.caseykulm.learnyourxjava.chapter3;

import java.util.Comparator;
import java.util.HashSet;
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

  @Test
  public void toMapExample() throws Exception {
    subj.words
        .toMap(word -> word.charAt(0))
        .subscribe(System.out::println);

    subj.words
        .toMap(word -> word.charAt(0), String::length)
        .subscribe(System.out::println);
  }

  @Test
  public void toMultiMapExample() throws Exception {
    subj.words
        .toMultimap(String::length)
        .subscribe(System.out::println);
  }

  @Test
  public void collectExample() throws Exception {
    subj.words
        .collect(HashSet::new, HashSet::add)
        .subscribe(System.out::println);
  }
}