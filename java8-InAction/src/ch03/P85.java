package ch03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P85 {
	public static void main(String[] args) {
		List<Apple> srcApples = new ArrayList<>();
		srcApples.addAll(Arrays.asList(new Apple(300), new Apple(100), new Apple(200)));
		
		Comparator<Apple> appleAsc = new Comparator<Apple>() {
			@Override
			public int compare(Apple o1, Apple o2) {
				return Integer.compare(o1.getWeight(), o2.getWeight());
			}
		};
		
		srcApples.sort(appleAsc);
		System.out.println(srcApples);
		
		// 파라미터 리스트, 화살표, 람다의 바디
		Comparator<Apple> appleDesc = (a, b) -> -Integer.compare(a.getWeight(), b.getWeight());
		
		srcApples.sort(appleDesc);
		System.out.println(srcApples);
	}
}
