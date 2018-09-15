package ch03;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

import org.junit.Rule;
import org.junit.Test;

import common.TimeTestWatcher;

public class P99_PrimitiveType {
	@Rule
	public TimeTestWatcher watcher = new TimeTestWatcher();
	
	@Test public void
	usePredicate() {
		// autoboxing used
		Predicate<Integer> oddNums = i -> i % 2 == 1;
		
		for(int i=0;i<Integer.MAX_VALUE;i++) {
			oddNums.test(i);
		}
	}
	
	@Test public void
	useIntPredicate() {
		// no autoboxing
		IntPredicate evenNums = i -> i % 2 == 0;
		
		for(int i=0;i<Integer.MAX_VALUE;i++) {
			evenNums.test(i);
		}
	}
}
