package seminar;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Comparator.comparing;
import java.util.List;
import java.util.function.BiFunction;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;

import ch03.Apple;

public class AppleStream {
	public static void main(String[] args) {
		BiFunction<Integer, String, Apple> c = Apple::new;
		List<Apple> apples = Arrays.asList(
			c.apply(100, "red"), c.apply(150, "green"), c.apply(130, "red"), 
			c.apply(180, "red"), c.apply(100, "green"), c.apply(90, "red"),
			c.apply(200, "red")
		);
		
		List<Apple> filteredApplesOld = new ArrayList<>();
		for(Apple a : apples) {
			if(a.getWeight() > 100 && "red".equals(a.getColor())) {
				filteredApplesOld.add(a);
			}
		}
		Collections.sort(filteredApplesOld, new Comparator<Apple>() {
			@Override
			public int compare(Apple a1, Apple a2) {
				return -Integer.compare(a1.getWeight(), a2.getWeight());
			}
		});
		filteredApplesOld = filteredApplesOld.subList(0, 2);
		System.out.println(filteredApplesOld);
		
		/*
		SELECT *
		FROM apple
		WHERE weight > 100 && color = 'red'
		ORDER BY weight DESC
		LIMIT 2
		 */
		List<Apple> filteredApples = apples.stream()
				.filter(a -> a.getWeight() > 100)
				.filter(a -> "red".equals(a.getColor()))
				.sorted(comparing(Apple::getWeight).reversed())
				.limit(2)
				.collect(toList());
		
		System.out.println(filteredApples);
	}
}
