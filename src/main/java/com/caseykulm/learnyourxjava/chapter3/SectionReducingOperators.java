package com.caseykulm.learnyourxjava.chapter3;

import io.reactivex.Observable;

public class SectionReducingOperators {
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
}
