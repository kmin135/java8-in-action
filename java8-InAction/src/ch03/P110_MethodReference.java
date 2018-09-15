package ch03;

import java.util.Arrays;
import java.util.List;

public class P110_MethodReference {
	public static void main(String[] args) {
		List<String> srcs = Arrays.asList("b", "a", "C", "A");
		srcs.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		System.out.println(srcs);
		
		srcs = Arrays.asList("d", "a", "F", "A");
		srcs.sort(String::compareToIgnoreCase);
		System.out.println(srcs);
	}
}
