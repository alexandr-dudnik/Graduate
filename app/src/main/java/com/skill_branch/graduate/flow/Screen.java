package com.skill_branch.graduate.flow;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.TYPE)
public @interface Screen {
    int value() default 0;

}
