package com.github.diegopacheco.sandbox.java.generator.jni.pojos;

import com.github.diegopacheco.sandbox.java.generator.jni.metadata.JNIClass;
import com.github.diegopacheco.sandbox.java.generator.jni.metadata.JNIField;

/**
 * Created by diego on 7/10/2014.
 */
@JNIClass()
public class User {

    @JNIField
    private String uuid;

    @JNIField
    private String eMail;

    @JNIField
    private String password;

    @JNIField
    private String name;

    @JNIField
    private String secretQuestion;

    @JNIField
    private String secretAnswer;

    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String geteMail() {
        return eMail;
    }
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSecretQuestion() {
        return secretQuestion;
    }
    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }
    public String getSecretAnswer() {
        return secretAnswer;
    }
    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
    }
}
