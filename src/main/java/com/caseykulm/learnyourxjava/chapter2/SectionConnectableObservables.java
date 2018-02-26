package com.caseykulm.learnyourxjava.chapter2;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class SectionConnectableObservables {
  public ConnectableObservable<String> source = Observable
      .just(
      "Alpha",
      "Beta",
      "Gamma",
      "Delta",
      "Epsilon")
      .publish();
}
