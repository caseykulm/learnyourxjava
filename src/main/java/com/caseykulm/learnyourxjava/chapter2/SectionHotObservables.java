package com.caseykulm.learnyourxjava.chapter2;

import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;

public class SectionHotObservables {
  public static class Toggle {
    public interface Listener {
      void onToggleEvent(boolean state);
    }
    private boolean toggled = false;
    private List<Listener> listeners = new ArrayList<>();

    public void toggle() {
      this.toggled = !toggled;
      for (Listener listener : listeners) {
        listener.onToggleEvent(toggled);
      }
    }

    public boolean isToggled() {
      return toggled;
    }

    public void addListener(Listener listener) {
      listeners.add(listener);
    }
  }

  public Observable<Boolean> toggleObservable(Toggle toggle) {
    return Observable.create(emmitter -> {
      emmitter.onNext(toggle.isToggled());
      toggle.addListener(emmitter::onNext);
    });
  }
}
