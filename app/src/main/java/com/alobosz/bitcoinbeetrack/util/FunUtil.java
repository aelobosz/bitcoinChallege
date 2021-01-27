package com.alobosz.bitcoinbeetrack.util;

import androidx.core.util.Consumer;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class FunUtil {
    public static <T> Function1<T, Unit> fromConsumer(Consumer<T> callable) {
        return t -> {
            callable.accept(t);
            return Unit.INSTANCE;
        };
    }
}
