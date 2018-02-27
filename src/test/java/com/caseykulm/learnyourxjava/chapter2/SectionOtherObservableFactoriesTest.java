package com.caseykulm.learnyourxjava.chapter2;

import io.reactivex.Observable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;

public class SectionOtherObservableFactoriesTest {
  private SectionOtherObservableFactories subj;

  @Before
  public void setUp() throws Exception {
    subj = new SectionOtherObservableFactories();
  }

  @Test
  public void rangeExample() throws Exception {
    subj.range.subscribe(System.out::println);
  }

  @Test
  public void intervalExample() throws Exception {
    subj.interval.subscribe(System.out::println);
    TimeUnit.SECONDS.sleep(5);
  }

  @Test
  public void intervalIsAColdObservable() throws Exception {
    subj.interval.subscribe(it -> System.out.println("Observer1: " + it));
    TimeUnit.SECONDS.sleep(5);
    subj.interval.subscribe(it -> System.out.println("Observer2: " + it));
    TimeUnit.SECONDS.sleep(5);
  }

  @Test
  public void intervalConvertedToAHotObservable() throws Exception {
    subj.hotInterval.connect();

    subj.hotInterval.subscribe(it -> System.out.println("Observer1: " + it));
    TimeUnit.SECONDS.sleep(5);
    subj.hotInterval.subscribe(it -> System.out.println("Observer2: " + it));
    TimeUnit.SECONDS.sleep(5);
  }

  @Test
  public void upgradeFutureToObservable() throws Exception {
    Future<String> strFuture = Executors.newSingleThreadExecutor().submit(
        () -> "Supercalifragilisticexpealidocious");

    subj.upgradeFuture(strFuture)
        .map(String::length)
        .subscribe(len -> System.out.println("length: " + len));
  }

  @Test
  public void emptyExample() throws Exception {
    subj.empty.subscribe(
        System.out::println,
        Throwable::printStackTrace,
        () -> System.out.println("Done 👍"));
  }

  @Test
  public void neverExample() throws Exception {
    subj.never.subscribe(
        System.out::println,
        Throwable::printStackTrace,
        () -> System.out.println("Done 👍"));

    TimeUnit.SECONDS.sleep(3);
  }

  @Test
  public void errorExample() throws Exception {
    subj.error.subscribe(
        System.out::println,
        Throwable::printStackTrace,
        () -> System.out.println("Done 👍"));
  }

  @Test
  public void dynamicErrorsExample() throws Exception {
    Observable<String> obs1 = subj.dynamicErrors(() -> new Exception("Crash"));
    Observable<String> obs2 = subj.dynamicErrors(() -> new Exception("And Burn"));

    obs1.subscribe(
        System.out::println,
        Throwable::printStackTrace,
        () -> System.out.println("Done 👍"));
    obs2.subscribe(
        System.out::println,
        Throwable::printStackTrace,
        () -> System.out.println("Done 👍"));
  }
}