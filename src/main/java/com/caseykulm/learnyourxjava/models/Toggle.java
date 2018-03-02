package com.caseykulm.learnyourxjava.models;

import com.caseykulm.learnyourxjava.chapter2.SectionHotObservables;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent a non-rxjava listener style UI widget
 * that supports toggling, (pull) getting the current state,
 * or (push) listening for state updates.
 */
public class Toggle {
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

  public void removeListeners() {
    listeners.clear();
  }

  public int getListenerCount() {
    return listeners.size();
  }
}
