package com.github.diegopacheco.sandbox.java.generator.jni.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by diego on 7/10/2014.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface JNIService {
    String name() default "";
    String cPath() default "../../src/include/contract/";
}
