package ch03;

import java.util.function.IntUnaryOperator;

import org.junit.Assert;
import org.junit.Test;

public class P119_ChainingFunction {
	@Test public void
	successAllFunction() {
		IntUnaryOperator f = x -> x + 1;
		IntUnaryOperator g = x -> x * 2;
		// g(f(x))
		IntUnaryOperator fg = f.andThen(g);
		// f(g(x))
		IntUnaryOperator gf = f.compose(g);
		
		Assert.assertEquals(8, fg.applyAsInt(3));
		Assert.assertEquals(7, gf.applyAsInt(3));
	}
}
