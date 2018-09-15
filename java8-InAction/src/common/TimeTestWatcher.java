package common;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TimeTestWatcher extends TestWatcher {
    private long time;

    @Override
    protected void starting(Description description) {
        time = System.currentTimeMillis();
    }

    @Override
    protected void finished(Description description) {
        String testName = description.getMethodName();
        System.out.println(String.format("Test %s took %d ms.", testName, (System.currentTimeMillis() - time)));
    }
};