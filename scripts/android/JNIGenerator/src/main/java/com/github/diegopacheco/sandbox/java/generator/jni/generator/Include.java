package com.github.diegopacheco.sandbox.java.generator.jni.generator;

/**
 * Created by diego on 7/10/2014.
 */
public class Include {

    private String name;

    public Include(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "#include " + name + "\n";
    }
}
