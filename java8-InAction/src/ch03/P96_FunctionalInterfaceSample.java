package ch03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class P96_FunctionalInterfaceSample {
	
	public static void main(String[] args) {
		List<String> srcStrs = Arrays.asList("abcd", "1213kmin", "a");
		List<String> longStrings = filter(srcStrs, s -> s.length() > 4);
		
		forEach(longStrings, s -> System.out.println(s));
		List<Integer> srcLengths = map(srcStrs, s -> s.length());
		forEach(srcLengths, s -> System.out.println(s));
		
	}
	
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> results = new ArrayList<>();
		for(T e : list) {
			if(p.test(e)) {
				results.add(e);
			}
		}
		return results;
	}
	
	public static <T> void forEach(List<T> list, Consumer<T> c) {
		for(T e : list) {
			c.accept(e);
		}
	}
	
	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> results = new ArrayList<>();
		for(T e : list) {
			results.add(f.apply(e));
		}
		return results;
	}
}
