package com.alobosz.bitcoinbeetrack.domain.usecase.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

abstract public class BaseUseCase {
    protected Disposable lastDisposable = null;
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void disposeLast() {
        if (null != lastDisposable && !lastDisposable.isDisposed()) {
            lastDisposable.dispose();
        }
    }

    public void dispose() {
        compositeDisposable.clear();
    }
}