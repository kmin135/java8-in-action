package seminar;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareSomething {
	public static void main(String[] args) {
		
		// Java 7
		List<String> myStrs = Arrays.asList("samsung", "apple", "facebook");
		Collections.sort(myStrs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		System.out.println(myStrs);
		
		// Java 8
		myStrs = Arrays.asList("samsung", "apple", "facebook");
		myStrs.sort((String s1, String s2) -> { return s1.compareTo(s2); });
		myStrs.sort((s1, s2) -> s1.compareTo(s2));
		myStrs.sort(String::compareTo);
		
		System.out.println(myStrs);
	}
}
