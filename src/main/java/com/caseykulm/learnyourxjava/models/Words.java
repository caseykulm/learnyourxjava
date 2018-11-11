package com.caseykulm.learnyourxjava.models;


import io.reactivex.Observable;

public class Words {
  public static Observable<String> ABC = Observable.just("Alpha", "Beta", "Gamma", "Epsilon");
}
