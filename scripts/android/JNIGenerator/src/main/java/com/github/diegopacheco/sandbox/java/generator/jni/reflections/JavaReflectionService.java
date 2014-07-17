package com.github.diegopacheco.sandbox.java.generator.jni.reflections;


import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * This classes exatract metadata based on annotations.
 *
 * Created by diego on 7/10/2014.
 */
public class JavaReflectionService {

    private String basePackage;
    private Reflections reflections;

    public JavaReflectionService fromPackage(String basepackage){
        this.basePackage = basepackage;
        this.reflections = new Reflections(this.basePackage);
        return this;
    }

    public Set<Class<?>> extract(Class clazz){
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(clazz);
        return classes;
    }

    public Set<Method> methods(Class clazz,Class annotation){
        Set<Method> methods = new LinkedHashSet<Method>();
        Method[] javaMethods = clazz.getMethods();
        for(Method m : javaMethods){
            if (m.getAnnotation(annotation)!=null) methods.add(m);
        }
        return methods;
    }

}
