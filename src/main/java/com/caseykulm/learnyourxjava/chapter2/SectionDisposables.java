package com.caseykulm.learnyourxjava.chapter2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.ResourceObserver;
import java.util.concurrent.TimeUnit;

public class SectionDisposables {
  public Observable<Long> interval = Observable.interval(100, TimeUnit.MILLISECONDS);

  public Observer<Integer> basicSelfDisposingObserver = new Observer<Integer>() {
    private Disposable disp;

    @Override public void onSubscribe(Disposable d) {
      this.disp = d;
    }

    @Override public void onNext(Integer integer) {

    }

    @Override public void onError(Throwable e) {

    }

    @Override public void onComplete() {
      disp.dispose();
    }
  };

  public ResourceObserver<Integer> resourceObserver = new ResourceObserver<Integer>() {
    @Override public void onNext(Integer integer) {
      System.out.println(integer);
    }

    @Override public void onError(Throwable e) {
      e.printStackTrace();
    }

    @Override public void onComplete() {
      System.out.println("onComplete");
    }
  };
}
