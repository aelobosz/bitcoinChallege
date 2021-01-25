package com.alobosz.bitcoinbeetrack.domain.usecase.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

abstract public class BaseUseCase {
    protected Disposable lastDisposable;
    protected CompositeDisposable compositeDisposable;

    public void disposeLast() {
        if (null != lastDisposable && lastDisposable.isDisposed()) {
            lastDisposable.dispose();
        }
    }

    public void dispose() {
        compositeDisposable.clear();
    }
}