package ch03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Assert;
import org.junit.Test;

public class P112_ConstructorReference {
	@Test public void
	successAllContructorReference() {
		Supplier<Apple> c1 = Apple::new;
		Apple a1 = c1.get();
		Assert.assertEquals(0, a1.getWeight());
		Assert.assertEquals("red", a1.getColor());
		
		Function<Integer, Apple> c2 = Apple::new;
		Apple a2 = c2.apply(100);
		Assert.assertEquals(100, a2.getWeight());
		Assert.assertEquals("red", a2.getColor());
		
		BiFunction<Integer, String, Apple> c3 = Apple::new;
		Apple a3 = c3.apply(200, "green");
		Assert.assertEquals(200, a3.getWeight());
		Assert.assertEquals("green", a3.getColor());
		
		List<Integer> weights = Arrays.asList(111,222,333);
		Assert.assertEquals(3, mapWeightTo(weights, c2).size());
	}
	
	public static List<Apple> mapWeightTo(List<Integer> weights, Function<Integer, Apple> constructor) {
		List<Apple> apples = new ArrayList<>();
		for(Integer weight : weights) {
			apples.add(constructor.apply(weight));
		}
		return apples;
	}
}
