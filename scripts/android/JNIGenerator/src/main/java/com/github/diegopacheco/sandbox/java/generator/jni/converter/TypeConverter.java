package com.github.diegopacheco.sandbox.java.generator.jni.converter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by diego on 7/16/2014.
 */
public class TypeConverter implements Converter {

    private Map<String, String> typez = new HashMap<String, String>();

    public TypeConverter() {
        typez.put("boolean", "jboolean");
        typez.put("byte", "jbyte");
        typez.put("char", "jchar");
        typez.put("short", "jshort");
        typez.put("int", "jint");
        typez.put("float", "jfloat");
        typez.put("double", "jdouble");
        typez.put("void", "void");
    }

    public String transform(String source) {
        String result = typez.get(source);
        if (result == null || "".equals(result)) {
            return "jobject";
        }
        return result;
    }

}
