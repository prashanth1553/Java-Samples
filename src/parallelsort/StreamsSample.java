package parallelsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsSample {

	public static void main(String args[]) {
		StreamsSample obj = new StreamsSample();
		obj.reduceOperation();

	}

	public void streamIterate() {

		Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * i);
		// initial value, n the value would function(n-1)

		infiniteStream.limit(3).mapToInt(i -> i).max();

	}

	public void reduceOperation() {
		IntStream intStream = IntStream.range(1, 5);

		System.out.println(intStream.reduce(0, (a, b) -> a + b));

		List<String> list = new ArrayList<>();
	}

	public void distinct() {
		List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
		List<Integer> distinctIntList = intList.stream().distinct().collect(Collectors.toList());
		
		List<Integer> uniquel = intList.stream().distinct().collect(Collectors.toList());
		
	}
}
