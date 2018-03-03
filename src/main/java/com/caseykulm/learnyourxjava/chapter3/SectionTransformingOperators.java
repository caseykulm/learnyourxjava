package com.caseykulm.learnyourxjava.chapter3;

import io.reactivex.Observable;

public class SectionTransformingOperators {
  public Observable<String> words = Observable.just(
      "the",
      "quick",
      "brown",
      "fox",
      "jumped",
      "over",
      "the",
      "lazy",
      "dog");

  public Observable<String> otherWords = Observable.just(
      "wabbit1",
      "wabbit2",
      "wabbit3");
}
