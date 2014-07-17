package com.github.diegopacheco.sandbox.java.generator.jni.pojos;

import com.github.diegopacheco.sandbox.java.generator.jni.metadata.JNIService;
import com.github.diegopacheco.sandbox.java.generator.jni.metadata.JNIServiceOperation;

import java.util.List;

/**
 * Created by diego on 7/10/2014.
 */
@JNIService(name = "CentralService")
public class CentralService {

    static {
        System.loadLibrary("api-lib");
    }

    @JNIServiceOperation(name = "isCentralConfigured")
    public Boolean isCentralConfigured(){
        return null;
    }

    @JNIServiceOperation
    public List<Central> retrieveConfiguredCentrals(User user){
        return null;
    }
}
