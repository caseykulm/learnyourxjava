package com.caseykulm.learnyourxjava.chapter3;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import io.reactivex.Observable;

public class SectionErrorOperatorsTest {

  @Test
  public void onErrorExample() {
    Observable.just(5, 2, 4, 0, 3, 2, 8)
        .map(i -> 10 / i)
        .subscribe(System.out::println, Throwable::printStackTrace);
  }

  @Test
  public void onErrorReturnItemExample() {
    Observable.just(5, 2, 4, 0, 3, 2, 8)
        .map(i -> 10 / i)
        .onErrorReturnItem(-1)
        .subscribe(System.out::println, Throwable::printStackTrace);
  }

  @Test
  public void onErrorReturnExample() {
    Observable.just(5, 2, 4, 0, 3, 2, 8)
        .map(i -> 10 / i)
        .onErrorReturn(t -> -1)
        .subscribe(System.out::println, Throwable::printStackTrace);
  }

  @Test
  public void onErrorReturnOrderMattersExample() {
    Observable.just(5, 2, 4, 0, 3, 2, 8)
        .onErrorReturn(t -> -1)
        .map(i -> 10 / i)
        .subscribe(System.out::println, Throwable::printStackTrace);
  }

  @Test
  public void catchErrorInStreamAndModelItExample() {
    Observable.just(5, 2, 4, 0, 3, 2, 8)
        .map(i -> {
          try {
            return 10 / i;
          } catch (ArithmeticException e) {
            return -1;
          }
        })
        .subscribe(System.out::println, Throwable::printStackTrace);
  }

  @Test
  public void onErrorResumeNextExample() {
    Observable.just(5, 2, 4, 0, 3, 2, 8)
        .onErrorReturn(t -> -1)
        .map(i -> 10 / i)
        .onErrorResumeNext(Observable.just(-1).repeat(3))
        .subscribe(System.out::println, Throwable::printStackTrace);
  }

  @Test
  public void onErrorResumeNextQuietlyExample() {
    Observable.just(5, 2, 4, 0, 3, 2, 8)
        .onErrorReturn(t -> -1)
        .map(i -> 10 / i)
        .onErrorResumeNext(Observable.empty())
        .subscribe(System.out::println, Throwable::printStackTrace);
  }

  @Test
  public void onErrorResumeNextDynamicExample() {
    Observable.just(5, 2, 4, 0, 3, 2, 8)
        .onErrorReturn(t -> -1)
        .map(i -> 10 / i)
        .onErrorResumeNext((Throwable e) -> Observable.just(-1).repeat(3))
        .subscribe(System.out::println, Throwable::printStackTrace);
  }

  // Be ready to kill this test, this test is dangerous
//  @Test
//  public void onErrorRetryInfinityOverloadExample() {
//    Observable.just(5, 2, 4, 0, 3, 2, 8)
//        .map(i -> 10 / i)
//        .retry()
//        .subscribe(System.out::println, Throwable::printStackTrace);
//  }

  @Test
  public void onErrorRetryLimitExample() {
    Observable.just(5, 2, 4, 0, 3, 2, 8)
        .map(i -> 10 / i)
        .retry(3)
        .subscribe(System.out::println, Throwable::printStackTrace);
  }

  @Test
  public void onErrorRetryLimitWithPredicateExample() {
    AtomicBoolean firstRetry = new AtomicBoolean(true);

    Observable.just(5, 2, 4, 0, 3, 2, 8)
        .map(i -> 10 / i)
        .retry((i, t) -> {
          if (firstRetry.get()) {
            firstRetry.set(false);
            return true;
          } else {
            return false;
          }
        })
        .subscribe(System.out::println, Throwable::printStackTrace);
  }
}