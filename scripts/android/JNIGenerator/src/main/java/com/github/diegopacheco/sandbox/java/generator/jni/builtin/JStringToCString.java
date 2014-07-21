package com.github.diegopacheco.sandbox.java.generator.jni.builtin;

/**
 * Created by diego on 7/21/2014.
 */
public class JStringToCString implements BuiltInFunction {

    @Override
    public String getName() {
        return "jStringToCString";
    }
    @Override
    public String getCode() {
        return "\tstring jStringToCString(JNIEnv *AEnv, jstring AStr) {\n" +
                "\t\t    return  AEnv->GetStringUTFChars(AStr,NULL);\n" +
                "\t}";
    }
}
