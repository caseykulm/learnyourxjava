package com.caseykulm.learnyourxjava.chapter2;

import io.reactivex.Observable;
import io.reactivex.Single;

public class SectionSingle {
  public Single<String> observableToSingle = Observable.just("alpha", "beta", "gamma")
      .first("empty");

  public Single<String> emptySingle = Observable.<String>empty().first("empty");
}
