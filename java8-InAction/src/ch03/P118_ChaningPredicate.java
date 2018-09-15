package ch03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class P118_ChaningPredicate {
	public static void main(String[] args) {
		BiFunction<Integer, String, Apple> c = Apple::new;
		List<Apple> apples = Arrays.asList(c.apply(100, "red"), c.apply(90, "green"), c.apply(120, "white"), c.apply(150, "red"));
		
		Predicate<Apple> redApple = a -> "red".equals(a.getColor());
		System.out.println(filter(apples, redApple));
		
		Predicate<Apple> notRedApple = redApple.negate();
		System.out.println(filter(apples, notRedApple));
		
		// (red && heavy) or green
		Predicate<Apple> redAndHeavyOrGreenApple = redApple.and(a -> a.getWeight() > 100).or(a -> "green".equals(a.getColor()));
		System.out.println(filter(apples, redAndHeavyOrGreenApple));
	}
	
	public static List<Apple> filter(List<Apple> apples, Predicate<Apple> predicate) {
		List<Apple> results = new ArrayList<>();
		for(Apple a : apples) {
			if(predicate.test(a)) {
				results.add(a);
			}
		}
		return results;
	}
}
