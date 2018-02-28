package com.caseykulm.learnyourxjava.chapter2;

import io.reactivex.Maybe;

public class SectionMaybe {
  public Maybe<Integer> maybeWithData = Maybe.just(42);

  public Maybe<Integer> maybeWithoutData = Maybe.empty();
}
