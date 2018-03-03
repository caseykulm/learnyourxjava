package com.caseykulm.learnyourxjava.chapter3;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;

public class SectionSupressingOperators {
  public Observable<String> strings = Observable.just(
      "the",
      "quick",
      "brown",
      "fox",
      "jumped",
      "over",
      "the",
      "lazy",
      "dog");

  public Observable<Long> interval = Observable.interval(100, TimeUnit.MILLISECONDS);

  public Observable<Integer> range = Observable.range(1, 100);
}
