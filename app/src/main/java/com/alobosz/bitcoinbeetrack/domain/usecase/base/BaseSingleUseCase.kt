package com.alobosz.bitcoinbeetrack.domain.usecase.base

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


abstract class BaseSingleUseCase<T> : BaseUseCase() {

    abstract fun buildSingleUseCase(): Single<T>

    @JvmOverloads
    fun execute(
            onSuccess: ((t: T) -> Unit),
            onError: ((t: Throwable) -> Unit),
            onComplete: () -> Unit = {}
    ) {
        disposeLast()
        lastDisposable = buildSingleUseCase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate(onComplete)
                .subscribe(onSuccess, onError)

        lastDisposable?.let {
            compositeDisposable.add(it)
        }
    }
}