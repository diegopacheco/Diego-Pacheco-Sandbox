package com.github.diegopacheco.sandbox.java.generator.jni.generator;

import com.github.diegopacheco.sandbox.java.generator.jni.converter.ClassConverter;
import com.github.diegopacheco.sandbox.java.generator.jni.converter.TypeConverter;
import com.github.diegopacheco.sandbox.java.generator.jni.metadata.JNIService;
import com.github.diegopacheco.sandbox.java.generator.jni.metadata.JNIServiceOperation;
import com.github.diegopacheco.sandbox.java.generator.jni.reflections.JavaReflectionService;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by diego on 7/10/2014.
 */
public class JNIReflectionGenerator {

    private String basePackageScan;
    private ClassConverter classConverter = new ClassConverter();
    private TypeConverter typeConverter = new TypeConverter();
    private List<Include> cppIncludes;

    public static void main(String args[]) {
        JNIReflectionGenerator generator = new JNIReflectionGenerator();

        List<Include> includes = new ArrayList<Include>();
        includes.add(new Include("<string.h>"));
        includes.add(new Include("<jni.h>"));

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

        for (Class serviceClass : services) {
            Set<Method> methods = reflectionService.methods(serviceClass, JNIServiceOperation.class);
            for (Method m : methods) {
                builder.append(exportMethod(serviceClass, m));
            }
        }

        builder.append(closeExtern());
        System.out.println(builder.toString());
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
}
