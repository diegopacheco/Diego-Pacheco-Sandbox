package com.github.diegopacheco.sandbox.java.spring.cloud.functions.fun;

import java.util.function.Function;
import reactor.core.publisher.Flux;

public class Upper implements Function<Flux<String>, Flux<String>> {

	@Override
	public Flux<String> apply(Flux<String> words) {
		return words.map(word->word.toUpperCase());
	}

}