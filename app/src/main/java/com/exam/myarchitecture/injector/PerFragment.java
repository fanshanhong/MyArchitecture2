package com.exam.myarchitecture.injector;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by fan on 2016/8/16.
 */
@Scope
@Retention(RUNTIME)
public @interface PerFragment {
}