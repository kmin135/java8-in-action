package ch03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P115_ComparingApple {
	public static void main(String[] args) {
		List<Apple> apples = P112_ConstructorReference.mapWeightTo(Arrays.asList(333, 222, 111), Apple::new);
		
		// 1. 익명 클래스 사용
		Comparator<Apple> anonymousComparator = new Comparator<Apple>() {
			@Override
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight() - a2.getWeight();
			}
		};
		
		apples.sort(anonymousComparator);
		System.out.println(apples);
		
		apples = P112_ConstructorReference.mapWeightTo(Arrays.asList(666, 555, 444), Apple::new);
		
		// 2. 람다 사용
		Comparator<Apple> lamdaComparator = (a1, a2) -> Integer.compare(a1.getWeight(), a2.getWeight());
		apples.sort(lamdaComparator);
		System.out.println(apples);
		
		apples = P112_ConstructorReference.mapWeightTo(Arrays.asList(999, 888, 777), Apple::new);
		
		// 3. 메서드 레퍼런스 사용
		Comparator<Apple> methodReferenceComparator = Comparator.comparing(Apple::getWeight);
		apples.sort(methodReferenceComparator);
		System.out.println(apples);
		
		// 4. 메서드 레퍼런스 사용 (역정렬)
		Comparator<Apple> methodReferenceComparatorReverse = Comparator.comparing(Apple::getWeight).reversed();
		apples.sort(methodReferenceComparatorReverse);
		System.out.println(apples);
	}
}
