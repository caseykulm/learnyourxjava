package com.caseykulm.learnyourxjava.chapter2;

import com.caseykulm.learnyourxjava.models.Toggle;
import io.reactivex.Observable;

public class SectionHandlingDisposeWithCreate {
  public Observable<Boolean> defaultCreateObservable(Toggle toggle) {
    return Observable.create(emmitter -> {
      emmitter.onNext(toggle.isToggled());
      toggle.addListener(emmitter::onNext);
    });
  }

  public Observable<Boolean> listenerCleanupObservable(Toggle toggle) {
    return Observable.create(emmitter -> {
      emmitter.onNext(toggle.isToggled());
      emmitter.setCancellable(toggle::removeListeners);
      toggle.addListener(emmitter::onNext);
    });
  }
}
