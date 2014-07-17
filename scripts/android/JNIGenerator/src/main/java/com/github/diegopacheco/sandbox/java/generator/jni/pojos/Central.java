package com.github.diegopacheco.sandbox.java.generator.jni.pojos;

import com.github.diegopacheco.sandbox.java.generator.jni.metadata.JNIClass;
import com.github.diegopacheco.sandbox.java.generator.jni.metadata.JNIField;

/**
 * Created by diego on 7/10/2014.
 */
@JNIClass()
public class Central {

    @JNIField
    private String uuid;

    @JNIField
    private String name;

    @JNIField
    private Boolean isLocalyAvailable;

    @JNIField
    private Integer numberOfDependents;

    public Central() {}

    public Central(String uuid, String name, Boolean isLocalyAvailable, Integer numberOfDependents) {
        this.uuid = uuid;
        this.name = name;
        this.isLocalyAvailable = isLocalyAvailable;
        this.numberOfDependents = numberOfDependents;
    }

    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsLocalyAvailable() {
        return isLocalyAvailable;
    }
    public void setIsLocalyAvailable(Boolean isLocalyAvailable) {
        this.isLocalyAvailable = isLocalyAvailable;
    }

    public Integer getNumberOfDependents() {
        return numberOfDependents;
    }
    public void setNumberOfDependents(Integer numberOfDependents) {
        this.numberOfDependents = numberOfDependents;
    }
}
