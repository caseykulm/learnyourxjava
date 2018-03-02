package com.caseykulm.learnyourxjava.chapter2;

import com.caseykulm.learnyourxjava.models.Toggle;
import io.reactivex.Observable;

public class SectionHotObservables {
  public Observable<Boolean> toggleObservable(Toggle toggle) {
    return Observable.create(emmitter -> {
      emmitter.onNext(toggle.isToggled());
      toggle.addListener(emmitter::onNext);
    });
  }
}
