package com.java8.interfaces;

import java.util.function.Function;

public class CovariantAndContraVariant {

	interface Future<T> {
		<U> Future<T> map(Function<? super T, ? extends U> f);
	}

}
