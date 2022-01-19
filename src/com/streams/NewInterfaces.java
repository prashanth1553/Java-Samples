package com.streams;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class NewInterfaces {

	class FunctionImpl implements Function<String, String> {

		@Override
		public String apply(String arg0) {
			return null;
		}

	}

	class BiFunctionImpl implements BiFunction<Integer, String, String> {

		@Override
		public String apply(Integer t, String u) {
			return null;
		}

	}

	class PredicateImpl implements Predicate<String> {

		@Override
		public boolean test(String t) {
			return t.isEmpty();
		}

	}

	// https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#forEach-java.util.function.Consumer-
	// Runnable example, for each
	class ConsumerImpl implements Consumer<String> {

		@Override
		public void accept(String arg0) {

		}

	}

	class SupplierImpl implements Supplier<String> {

		@Override
		public String get() {
			return "";
		}

	}
}
