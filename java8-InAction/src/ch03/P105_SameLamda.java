package ch03;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.ToIntBiFunction;

public class P105_SameLamda {
	public static void main(String[] args) {
		Apple a1 = new Apple(100);
		Apple a2 = new Apple(150);
		
		Comparator<Apple> asc = (a, b) -> Integer.compare(a.getWeight(), b.getWeight());
		ToIntBiFunction<Apple, Apple> getCompareValue = (a, b) -> Integer.compare(a.getWeight(), b.getWeight());
		BiFunction<Apple, Apple, Integer> getCompareValue2 = (a, b) -> Integer.compare(a.getWeight(), b.getWeight());
		
		System.out.println(asc.compare(a1, a2));
		System.out.println(getCompareValue.applyAsInt(a1, a2));
		System.out.println(getCompareValue2.apply(a1, a2));
	}
}
