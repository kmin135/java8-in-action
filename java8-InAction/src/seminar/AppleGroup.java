package seminar;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import ch03.Apple;

public class AppleGroup {
	public static void main(String[] args) {
		BiFunction<Integer, String, Apple> c = Apple::new;
		List<Apple> apples = Arrays.asList(
			c.apply(100, "red"), c.apply(150, "green"), c.apply(130, "red"), 
			c.apply(180, "red"), c.apply(100, "green"), c.apply(90, "red"),
			c.apply(200, "red")
		);
		
		Map<String, List<Apple>> mapApple = apples.stream()
				.filter(a -> a.getWeight() > 100)
				.collect(Collectors.groupingBy(Apple::getColor));
		
		System.out.println(mapApple.get("red"));
		System.out.println(mapApple.get("green"));
	}
}
