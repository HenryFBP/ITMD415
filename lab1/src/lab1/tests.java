package lab1;

import java.util.ArrayList;
import java.util.function.Function;

public class tests
{
	public static void runTests()
	{
		System.out.println("MATH FUNCTION TEST:");
		tests.testsMathLib();
		System.out.println();
		
		System.out.println("STATEMENT PARSING TEST:");
		tests.testsStatementMatching();
		System.out.println();
	}
	
	public static void testMathlib(String op, double x, double y)
	{
		
		Function<ArrayList<Double>, Double> f = mathlib.operator(op);
		
		ArrayList<Double> ops = new ArrayList<>();

		ops.add(x);
		ops.add(y);
		
		double b = f.apply(ops);
		
		System.out.println(String.format("%.2f %s %.2f = %.2f", ops.get(0), op, ops.get(1), b));
	}
	
	public static void testStatementMatching(String str)
	{
		Statement s = new Statement(str);
		
		System.out.println(String.format("'%15s' -> %s",str,s.toString()));
	}
	
	public static void testsStatementMatching()
	{
		tests.testStatementMatching("1 + 1");
		tests.testStatementMatching("1.3-1.023");
		tests.testStatementMatching("2 **3.0");
		tests.testStatementMatching("200.0// 1.5");
		tests.testStatementMatching("200.0  /  1.5");
	}
	
	
	public static void testsMathLib()
	{
		tests.testMathlib("+", 2.0, 5.5);
		tests.testMathlib("*", 4.0, 4.0);
		tests.testMathlib("-", 2.0, 5.5);
		tests.testMathlib("/", 2.0, 5.5);
		tests.testMathlib("//", 101.0, 5.0);
		tests.testMathlib("/", 101.0, 5.0);
	}
}
