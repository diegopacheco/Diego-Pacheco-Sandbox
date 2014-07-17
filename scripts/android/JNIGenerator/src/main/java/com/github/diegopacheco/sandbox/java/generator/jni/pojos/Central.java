package com.github.diegopacheco.sandbox.java.generator.jni.pojos;

import com.github.diegopacheco.sandbox.java.generator.jni.metadata.JNIClass;
import com.github.diegopacheco.sandbox.java.generator.jni.metadata.JNIField;

/**
 * Created by diego on 7/10/2014.
 */
@JNIClass(path = "../../../../mobile-api/src/include/contract", cppResource = "Central")
public class Central {

    @JNIField(name = "uuid",typpe = "String")
    private String uuid;

}
