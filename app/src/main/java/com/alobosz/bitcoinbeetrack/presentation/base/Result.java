package com.alobosz.bitcoinbeetrack.presentation.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static com.alobosz.bitcoinbeetrack.presentation.base.Status.EMPTY;
import static com.alobosz.bitcoinbeetrack.presentation.base.Status.ERROR;
import static com.alobosz.bitcoinbeetrack.presentation.base.Status.LOADING;
import static com.alobosz.bitcoinbeetrack.presentation.base.Status.SUCCESS;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Result<T> {

    public final Status status;

    @Nullable
    public final T data;

    @Nullable
    public final Throwable error;

    private Result(Status status, @Nullable T data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static Result onLoading() {
        return new Result(LOADING, null, null);
    }

    public static <T> Result onSuccess(@NonNull T data) {
        return new Result(SUCCESS, data, null);
    }

    public static Result onError(@NonNull Throwable error) {
        return new Result(ERROR, null, error);
    }

    public static Result onEmpty() {
        return new Result(EMPTY, null, null);
    }
}
