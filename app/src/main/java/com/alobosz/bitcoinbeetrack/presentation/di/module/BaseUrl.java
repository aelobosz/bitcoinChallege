package com.alobosz.bitcoinbeetrack.presentation.di.module;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import javax.inject.Qualifier;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Documented
@Retention(RUNTIME)
public @interface BaseUrl {
    String value() default "baseUrl";
}
