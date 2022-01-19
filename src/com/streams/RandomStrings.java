package com.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;

public class RandomStrings {

	public static void main(String args[]) {
		RandomStrings obj = new RandomStrings();
		obj.randomString();
	}

	public void randomString() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		System.out.println(generatedString);

		Supplier<StringBuilder> supplier = () -> new StringBuilder();
		ObjIntConsumer<StringBuilder> consumer = (ss, v) -> ss.appendCodePoint(v);
		BiConsumer<StringBuilder, StringBuilder> combiner = (a, b) -> {
			a.append(",").append(b);
			// System.out.println("combiner == ");
		};

		combiner = combiner.andThen((l, r) -> l.append(" ").append(r)); // cominer(third parameter in collect) not used
																		// in serial streams
		generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(supplier, consumer, combiner.andThen((l, r) -> r.append(r))).toString();

		System.out.println(generatedString);

		// using and then

		List<String> list2 = Arrays.asList("a", "b", "c", "d", "e", "g", "h", "i", "j", "1", "2");

		BiConsumer<StringBuilder, String> combiner2 = (a, b) -> a.append(b);
		generatedString = list2.parallelStream()
				.collect(supplier, (StringBuilder a, String b) -> a.append(",").append(b), combiner).toString();

		System.out.println(generatedString);

		combiner = (a, b) -> {
			a.append(",").append(b);
			// System.out.println("combiner == ");
		};
		StringBuilder biConsumerTest = new StringBuilder("s");
		combiner.andThen(combiner).accept(biConsumerTest, new StringBuilder("sa"));
		System.out.println("biConsumerTest == " + biConsumerTest);

	}
}
