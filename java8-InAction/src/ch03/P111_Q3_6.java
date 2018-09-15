package ch03;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;

public class P111_Q3_6 {
	@Test public void
	sameResultLamdaAndMethodReference() {
		// 1. 정적 메서드 레퍼런스
		Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
		Function<String, Integer> stringToIntegerMR = Integer::parseInt;
		
		String srcInt = "123";
		Assert.assertEquals(
			stringToInteger.apply(srcInt), 
			stringToIntegerMR.apply(srcInt)
		);
		
		// 2. 다양한 형식의 인스턴스 메서드 레퍼런스
		BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
		BiPredicate<List<String>, String> containsMR = List::contains;
		
		List<String> srcList = Arrays.asList("abc", "happy", "smith");
		String targetStr = "happy";
		Assert.assertEquals(
			contains.test(srcList, targetStr),
			containsMR.test(srcList, targetStr)
		);
	}
}
