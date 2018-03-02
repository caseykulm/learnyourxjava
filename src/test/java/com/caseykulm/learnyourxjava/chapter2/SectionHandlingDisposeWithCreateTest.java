package com.caseykulm.learnyourxjava.chapter2;

import com.caseykulm.learnyourxjava.models.Toggle;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SectionHandlingDisposeWithCreateTest {
  private SectionHandlingDisposeWithCreate subj;


  @Before
  public void setUp() throws Exception {
    subj = new SectionHandlingDisposeWithCreate();
  }

  @Test
  public void defaultCreateNotDisposingOfListener() throws Exception {
    Toggle toggle = new Toggle();
    Observable<Boolean> defaultCreateObservable = subj.defaultCreateObservable(toggle);

    Disposable disp = defaultCreateObservable.subscribe(
        System.out::println,
        Throwable::printStackTrace,
        () -> System.out.println("complete"));

    for (int i=0; i<10; i++) {
      if (i == 5) {
        disp.dispose();
      }
      toggle.toggle();
    }

    assertEquals(1, toggle.getListenerCount());
  }

  @Test
  public void haveCreateDisposeOfListener() throws Exception {
    Toggle toggle = new Toggle();
    Observable<Boolean> listenerCleanupObservable = subj.listenerCleanupObservable(toggle);

    Disposable disp = listenerCleanupObservable.subscribe(
        System.out::println,
        Throwable::printStackTrace,
        () -> System.out.println("complete"));

    for (int i=0; i<10; i++) {
      if (i == 5) {
        disp.dispose();
      }
      toggle.toggle();
    }

    assertEquals(0, toggle.getListenerCount());
  }
}