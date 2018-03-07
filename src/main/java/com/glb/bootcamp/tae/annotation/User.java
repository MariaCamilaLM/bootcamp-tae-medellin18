package com.glb.bootcamp.tae.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Java Annotations: //https://docs.oracle.com/javase/tutorial/java/annotations/
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface User {

    int id();

    String name();

    String email();

    String status() default "INACTIVE";
}
