package jdk18.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Statistics {

	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		IntSummaryStatistics intSummaryStatistics = numList.stream().mapToInt(num -> num).summaryStatistics();
		System.out.println("count: " + intSummaryStatistics.getCount());
		System.out.println("max: " + intSummaryStatistics.getMax());
		System.out.println("min: " + intSummaryStatistics.getMin());
		System.out.println("sum: " + intSummaryStatistics.getSum());
		System.out.println("avg: " + intSummaryStatistics.getAverage());
	}

}
