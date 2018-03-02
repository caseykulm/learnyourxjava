package com.caseykulm.learnyourxjava.chapter2;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SectionCompositeDisposablesTest {
  private SectionCompositeDisposables subj;

  @Before
  public void setUp() throws Exception {
    subj = new SectionCompositeDisposables();
  }

  @Test
  public void addMultipleDisposablesAndDisposeOfThem() throws Exception {
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    Disposable disp1 = subj.hotObservable.subscribe(System.out::println);
    compositeDisposable.add(disp1);

    Disposable disp2 = subj.hotObservable.subscribe(System.out::println);
    compositeDisposable.add(disp2);

    compositeDisposable.dispose();

    assertTrue(disp1.isDisposed());
    assertTrue(disp2.isDisposed());
  }
}