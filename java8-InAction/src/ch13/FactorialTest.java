package ch13;

import java.util.stream.LongStream;

public class FactorialTest {
	public static void main(String[] args) {
		int n = 987654321;
		long st = System.currentTimeMillis();
		System.out.println("Iterative result : " + factorialIterative(n));
		System.out.println("Iterative elapsed : " + (System.currentTimeMillis() - st));
		
		st = System.currentTimeMillis();
		//factorialRecursive(n);
		System.out.println("Recursive elapsed : " + (System.currentTimeMillis() - st));
		
		st = System.currentTimeMillis();
		System.out.println("Streams result : " + factorialStreams(n));
		System.out.println("Streams elapsed : " + (System.currentTimeMillis() - st));
	}
	
	static long factorialIterative(int n) {
		long r = 1L;
		for(int i=1;i<=n;i++) {
			r *= i;
		}
		return r;
	}
	
	static long factorialRecursive(int n) {
		return n == 1 ? 1 : n * factorialRecursive(n-1);
	}
	
	static long factorialStreams(long n) {
		return LongStream.rangeClosed(1, n)
				.parallel()
				.reduce(1, (a, b) -> a * b);
	}
}
