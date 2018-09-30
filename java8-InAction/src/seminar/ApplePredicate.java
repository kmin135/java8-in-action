package seminar;

import java.util.function.Predicate;

import ch03.Apple;

public class ApplePredicate {
	public static void main(String[] args) {
		Predicate<Apple> heavy = (a -> a.getWeight() > 100);
		Predicate<Apple> green = (a -> "green".equalsIgnoreCase(a.getColor()));
		Predicate<Apple> red = (a -> "red".equalsIgnoreCase(a.getColor()));
		
		// (heavy && green) || red
		Predicate<Apple> expensiveApple = heavy.and(green).or(red);
		
		Apple apple1 = new Apple(90, "green");
		Apple apple2 = new Apple(90, "red");
		
		System.out.println(isSuitableApple(apple1, expensiveApple));
		System.out.println(isSuitableApple(apple2, expensiveApple));
	}
	
	public static boolean isSuitableApple(Apple a, Predicate<Apple> condition) {
		return condition.test(a);
	}
}
