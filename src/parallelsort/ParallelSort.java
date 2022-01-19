package parallelsort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;


public class ParallelSort {

	public static void main(String args[]) {
		// cat /proc/cpuinfo | grep processor | wc -l

		System.out.println(" availableProcessors = " + Runtime.getRuntime().availableProcessors());

		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		
		System.out.println("commonPool Paralleism" + commonPool.getParallelism());

		System.out.println("commonPool Paralleism " + ForkJoinPool.getCommonPoolParallelism());

		ParallelSort obj = new ParallelSort();

	//	obj.parallelArraySortTimeTest();

		// MIN_ARRAY_SORT_GRAN = 8192 [
		
		Thread.currentThread().interrupt();

	}

	private void parallelArraySortTimeTest() {
		int[] arraySizes = { 10000, 100000, 1000000, 10000000 };

		for (int arraySize : arraySizes) {

			System.out.println("When Array size = " + arraySize);

			int[] intArray = new int[arraySize];
			Random random = new Random();

			for (int i = 0; i < arraySize; i++)
				intArray[i] = random.nextInt(arraySize) + random.nextInt(arraySize);

			int[] forSequential = Arrays.copyOf(intArray, intArray.length);
			int[] forParallel = Arrays.copyOf(intArray, intArray.length);

			long startTime = System.currentTimeMillis();
			Arrays.sort(forSequential);
			long endTime = System.currentTimeMillis();

			System.out.println("Sequential Sort Milli seconds: " + (endTime - startTime));

			startTime = System.currentTimeMillis();
			Arrays.parallelSort(forParallel);
			endTime = System.currentTimeMillis();

			System.out.println("Parallel Sort Milli seconds: " + (endTime - startTime));
			System.out.println("------------------------------");

		}
	}

}
