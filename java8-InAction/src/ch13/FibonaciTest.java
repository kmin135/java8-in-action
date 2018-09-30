package ch13;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FibonaciTest {
	public static void main(String[] args) {
		int n = 100000000;
		long st = System.currentTimeMillis();
		System.out.println("Iterative result : " + fiboIterative(n));
		System.out.println("Iterative elapsed : " + (System.currentTimeMillis() - st));
		
		st = System.currentTimeMillis();
		System.out.println("Streams result  : " + fiboStreams(n));
		System.out.println("Streams elapsed : " + (System.currentTimeMillis() - st));
	}
	
	static long fiboIterative(int n) {
		if(n < 3) return 1;
		long before = 1L;
		long after = 1L;
		for(int i=3;i<=n;i++) {
			long tmp = after;
			after = before + after;
			before = tmp;
		}
		return after;
	}

	static long fiboStreams(long n) {
		return Stream.iterate(new long[] {1, 1}, f -> new long[] {f[1], f[0] + f[1]})
		    .limit(n)
		    .parallel()
		    .reduce((a, b) -> b)
		    .get()[0];
	}
}
