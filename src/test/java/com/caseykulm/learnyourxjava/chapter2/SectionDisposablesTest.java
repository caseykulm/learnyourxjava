package com.caseykulm.learnyourxjava.chapter2;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SectionDisposablesTest {
  private SectionDisposables subj;

  @Before
  public void setUp() throws Exception {
    subj = new SectionDisposables();
  }

  @Test
  public void disposeOfInterval() throws Exception {
    Disposable disp = subj.interval.subscribe(System.out::println);

    TimeUnit.SECONDS.sleep(1);

    disp.dispose();

    assertTrue(disp.isDisposed());

    TimeUnit.SECONDS.sleep(1);
  }

  @Test
  public void basicSelfDisposingObserver() throws Exception {
    Observable.fromArray(1, 2, 3)
        .subscribe(subj.basicSelfDisposingObserver);
  }

  @Test
  public void resourceObserverExample() throws Exception {
    Disposable disp = Observable.fromArray(1, 2, 3)
        .subscribeWith(subj.resourceObserver);

    disp.dispose();
    
    assertTrue(disp.isDisposed());
  }
}