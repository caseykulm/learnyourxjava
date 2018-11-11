package com.caseykulm.learnyourxjava.chapter3;

import com.caseykulm.learnyourxjava.models.Words;

import org.junit.Test;

import io.reactivex.Observable;

public class SectionActionOperatorsTest {

  @Test
  public void doOnNextExample() {
    Words.ABC
        .doOnNext(s -> System.out.println("instream: " + s))
        .subscribe(System.out::println, Throwable::printStackTrace);
  }

  @Test
  public void doAfterNextExample() {
    Words.ABC
        .doAfterNext(s -> System.out.println("instream: " + s))
        .subscribe(System.out::println, Throwable::printStackTrace);
  }

  @Test
  public void doOnCompleteExample() {
    Words.ABC
        .doOnComplete(() -> System.out.println("instream: done"))
        .subscribe(System.out::println, Throwable::printStackTrace);
  }

  @Test
  public void doOnErrorExample() {
    Observable.just(5, 2, 4, 0, 3, 2, 8)
        .doOnError(e -> System.out.println("will print this if source failed"))
        .map(i -> 10 / i)
        .doOnError(e -> System.out.println("will print this if division failed"))
        .subscribe(System.out::println, t -> {});
  }

  @Test
  public void doOnSubscribeAndDoFinallyExample() {
    // doOnDispose is not used anymore as of 2.0.5, and doFinally typically replaces it per
    // https://github.com/ReactiveX/RxJava/issues/5264
    Words.ABC
        .doOnSubscribe(d -> System.out.println("subscribing"))
        .doFinally(() -> System.out.println("disposing"))
        .subscribe(System.out::println, Throwable::printStackTrace);
  }

  @Test
  public void doOnSuccessExample() {
    Observable.just(5, 3, 7, 10, 2, 14)
        .reduce((acc, next) -> acc + next)
        .doOnSuccess(i -> System.out.println("instream: " + i))
        .subscribe(System.out::println, t -> {});
  }
}
