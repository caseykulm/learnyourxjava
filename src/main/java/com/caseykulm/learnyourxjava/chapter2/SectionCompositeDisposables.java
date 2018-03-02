package com.caseykulm.learnyourxjava.chapter2;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;

public class SectionCompositeDisposables {
  public Observable<Long> hotObservable = io.reactivex.Observable.interval(1, TimeUnit.SECONDS);
}
