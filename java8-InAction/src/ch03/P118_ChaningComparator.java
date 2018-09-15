package ch03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

public class P118_ChaningComparator {
	public static void main(String[] args) {
		BiFunction<Integer, String, Apple> con = Apple::new;
		List<Apple> src = Arrays.asList(
			con.apply(100, "red"),
			con.apply(200, "red"),
			con.apply(200, "green")
		);
		
		src.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
		
		System.out.println(src);
	}
}
