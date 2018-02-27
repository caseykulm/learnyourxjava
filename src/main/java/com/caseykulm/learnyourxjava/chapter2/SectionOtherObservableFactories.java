package com.caseykulm.learnyourxjava.chapter2;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SectionOtherObservableFactories {
  public Observable<Integer> range = Observable.range(5, 10);

  public Observable<Long> interval = Observable.interval(1, TimeUnit.SECONDS);

  public ConnectableObservable<Long> hotInterval = Observable.interval(1, TimeUnit.SECONDS).publish();

  public Observable<String> upgradeFuture(Future<String> future) {
    return Observable.fromFuture(future);
  }

  public Observable<String> empty = Observable.empty();

  public Observable<String> never = Observable.never();

  public Observable<String> error = Observable.error(new Exception("Crash and burn #zerocool"));

  public Observable<String> dynamicErrors(Callable<Exception> callable) {
    return Observable.error(callable);
  }
}
