package com.caseykulm.learnyourxjava.chapter2;

import io.reactivex.Observable;

public class SectionColdObservables {
  public Observable<String> source = Observable.just(
      "Alpha",
      "Beta",
      "Gamma",
      "Delta",
      "Epsilon");
}
