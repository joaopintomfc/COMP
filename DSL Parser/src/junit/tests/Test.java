package junit.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Test {

	@org.junit.Test
	public void test() {
		Result result = JUnitCore.runClasses(ExampleTests.class);
	    for (Failure failure : result.getFailures()) {
	      System.out.println(failure.toString());
	    }
	    Result resultSuite = JUnitCore.runClasses(DSLTestSuite.class);
	    for (Failure failure : resultSuite.getFailures()) {
	      System.out.println(failure.toString());
	    }
	}

}
