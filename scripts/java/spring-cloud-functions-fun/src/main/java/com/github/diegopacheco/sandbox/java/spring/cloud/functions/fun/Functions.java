package com.github.diegopacheco.sandbox.java.spring.cloud.functions.fun;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.compiler.FunctionCompiler;
import org.springframework.cloud.function.compiler.proxy.LambdaCompilingFunction;
import org.springframework.cloud.function.context.FunctionScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ByteArrayResource;

import reactor.core.publisher.Flux;

@FunctionScan
@SpringBootApplication
public class Functions {
	
	@Bean
	public Upper upper() {
		return new Upper();
	}
	
	@Bean
	public Function<Flux<String>, Flux<String>> lower() {
		return flux -> flux.map(value -> value.toLowerCase());
	}
	
	@Bean
	public <T, R> FunctionCompiler<T, R> compiler() {
		return new FunctionCompiler<>();
	}
	
	@Bean
	public Function<String, String> compiledUppercase(FunctionCompiler<String, String> compiler) {
		String lambda = "s -> s.toUpperCase()";
		LambdaCompilingFunction<String, String> function = new LambdaCompilingFunction<>(new ByteArrayResource(lambda.getBytes()), compiler);
		function.setTypeParameterizations("String", "String");
		return function;
	}

	@Bean
	public Function<Flux<String>, Flux<String>> compiledLowercase(FunctionCompiler<Flux<String>, Flux<String>> compiler) {
		String lambda = "f->f.map(o->o.toString().toLowerCase())";
		return new LambdaCompilingFunction<>(new ByteArrayResource(lambda.getBytes()), compiler);
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Functions.class, args);
	}
	
}
