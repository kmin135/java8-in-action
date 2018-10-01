package seminar;

import java.util.stream.LongStream;

public class ParallelSum {
	public static void main(String[] args) throws InterruptedException {
		long n = 3987654321L;
		
		long st = System.currentTimeMillis();
		long result = 0L;
		for(long i=1L;i<=n;i++) {
			result += i;
		}
		System.out.printf("Result : %d, elapsed : %d\n", result, System.currentTimeMillis() - st);
		
		st = System.currentTimeMillis();
		result = parallelRangedSum(n);
		System.out.printf("Result : %d, elapsed : %d\n", result, System.currentTimeMillis() - st);
	}
	
	public static long parallelRangedSum(long n) {
		return LongStream.rangeClosed(1, n)
					.parallel()
					.reduce(0, Long::sum);
	}
}
