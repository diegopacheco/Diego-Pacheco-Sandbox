package com.github.diegopacheco.sandbox.java.generator.jni.generator;

import com.github.diegopacheco.sandbox.java.generator.jni.builtin.BuiltInFunction;
import com.github.diegopacheco.sandbox.java.generator.jni.builtin.JStringToCString;
import com.github.diegopacheco.sandbox.java.generator.jni.converter.ClassConverter;
import com.github.diegopacheco.sandbox.java.generator.jni.converter.TypeConverter;
import com.github.diegopacheco.sandbox.java.generator.jni.metadata.JNIService;
import com.github.diegopacheco.sandbox.java.generator.jni.metadata.JNIServiceOperation;
import com.github.diegopacheco.sandbox.java.generator.jni.reflections.JavaReflectionService;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by diego on 7/10/2014.
 */
public class JNIReflectionGenerator {

    private String basePackageScan;
    private ClassConverter classConverter = new ClassConverter();
    private TypeConverter typeConverter = new TypeConverter();
    private Set<BuiltInFunction> buildInFunctions = new LinkedHashSet<BuiltInFunction>();
    private List<Include> cppIncludes;

    public static void main(String args[]) {
        JNIReflectionGenerator generator = new JNIReflectionGenerator();

        List<Include> includes = new ArrayList<Include>();
        includes.add(new Include("<string.h>"));
        includes.add(new Include("<jni.h>"));

        Set<BuiltInFunction> fns = new LinkedHashSet<BuiltInFunction>();
        fns.add(new JStringToCString());

        generator.setBuildInFunctions(fns);
        generator.setCppIncludes(includes);
        generator.generate();
    }

    public void generate() {

        StringBuffer builder = new StringBuffer("");
        builder.append(addImports());

        JavaReflectionService reflectionService = new JavaReflectionService().fromPackage(basePackageScan);
        Set<Class<?>> services = reflectionService.extract(JNIService.class);

        builder.append(addCClassImports(services));
        builder.append(addExtern());

        builder.append(addBuitInFunctions());
        addJNIExports(builder, reflectionService, services);

        builder.append(closeExtern());
        System.out.println(builder.toString());
    }

    private String addBuitInFunctions() {
        StringBuffer sb = new StringBuffer("");
        for(BuiltInFunction fn: buildInFunctions){
            sb.append(fn.getCode() + "\n\n");
        }
        return sb.toString();
    }

    private void addJNIExports(StringBuffer builder, JavaReflectionService reflectionService, Set<Class<?>> services) {
        for (Class serviceClass : services) {
            Set<Method> methods = reflectionService.methods(serviceClass, JNIServiceOperation.class);
            for (Method m : methods) {
                builder.append(exportMethod(serviceClass, m));
            }
        }
    }

    private String addCClassImports(Set<Class<?>> services){
        StringBuffer sb = new StringBuffer("");
        try{
            String path = JNIService.class.getMethod("cPath").getDefaultValue().toString();
            for (Class serviceClass : services) {
                sb.append( "#include \"" + path + serviceClass.getSimpleName() + ".h\"\n" );
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    private String exportMethod(Class serviceClass, Method m) {
        StringBuilder sb = new StringBuilder("");
        sb.append("     JNIEXPORT ");
        sb.append(" " + exportReturnType(m) + " ");
        sb.append(classConverter.transform(serviceClass.getName()) + "(JNIEnv *env, jobject obj)");
        sb.append(" { \n");
        sb.append("         " + exportCall(serviceClass, m) + "\n");
        sb.append("     } \n");
        return sb.toString();
    }

    private String exportReturnType(Method m) {
        return typeConverter.transform(m.getReturnType().getSimpleName().toLowerCase());
    }

    public String exportCall(Class serviceClass, Method m) {
        return "return " + serviceClass.getSimpleName() + "()." + m.getName() + "();";
    }

    private String addImports() {
        StringBuilder sb = new StringBuilder("");
        for (Include in : cppIncludes) {
            sb.append(in.toString());
        }
        return sb.toString();
    }

    private String addExtern() {
        return "\nextern \"C\" {\n\n";
    }

    private String closeExtern() {
        return "\n }";
    }

    public void setTypeConverter(TypeConverter typeConverter) {
        this.typeConverter = typeConverter;
    }

    public void setBasePackageScan(String basePackageScan) {
        this.basePackageScan = basePackageScan;
    }

    public void setCppIncludes(List<Include> cppIncludes) {
        this.cppIncludes = cppIncludes;
    }

    public void setClassConverter(ClassConverter classConverter) {
        this.classConverter = classConverter;
    }

    public void setBuildInFunctions(Set<BuiltInFunction> buildInFunctions) {
        this.buildInFunctions = buildInFunctions;
    }
}
