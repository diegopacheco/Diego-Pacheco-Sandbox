package com.github.diegopacheco.sandbox.java.generator.jni.converter;

/**
 * Created by diego on 7/16/2014.
 */
public class ClassConverter implements Converter {

    @Override
    public String transform(String source) {
        return "Java_" + source.replace(".","_");
    }

}
