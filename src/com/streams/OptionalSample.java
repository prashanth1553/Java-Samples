package com.streams;

import java.util.Optional;

public class OptionalSample {

	public static void main(String args[]) {

		Optional<String> result = mightReturnNull(11);
		if (result.isPresent()) {

			System.out.println(result.get());

			// System.out.println("Non-Empty Optional:: " +
			// result.map(String::toUpperCase));

		}
	}

	public static Optional<String> mightReturnNull(int a) {
		String result = null;

		if (a % 2 == 0) {
			return Optional.empty();
		}

		if (a / 2 != 0) {
			return Optional.of("Result");
		}

		// business logic

		return Optional.ofNullable(result);
	}
}
