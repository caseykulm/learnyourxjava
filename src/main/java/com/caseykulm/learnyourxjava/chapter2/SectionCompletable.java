package com.caseykulm.learnyourxjava.chapter2;

import io.reactivex.Completable;

public class SectionCompletable {
  public Completable completable = Completable.fromRunnable(() -> {
    System.out.println("---- doing work ---");
  });
}
