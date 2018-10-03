package seminar;

import java.util.stream.IntStream;

public class ZeroDivide {
	public static void main(String[] args) {
		IntStream.rangeClosed(0, 5)
			.forEach((i) -> System.out.println(i / 0));
	}
}
