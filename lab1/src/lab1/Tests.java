package lab1;

import java.util.ArrayList;
import java.util.function.Function;

public class Tests
{
	public static void runTests()
	{
		System.out.println("MATH FUNCTION TEST:");
		Tests.testsMathLib();
		System.out.println();
		
		System.out.println("STATEMENT PARSING TEST:");
		Tests.testsStatementMatching();
		System.out.println();
	}
	
	public static void testMathlib(String op, double x, double y)
	{
		
		Function<ArrayList<Double>, Double> f = MathLib.operator(op);
		
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
		Tests.testStatementMatching("1 + 1");
		Tests.testStatementMatching("1.3-1.023");
		Tests.testStatementMatching("2 **3.0");
		Tests.testStatementMatching("200.0// 1.5");
		Tests.testStatementMatching("200.0  /  1.5");
	}
	
	
	public static void testsMathLib()
	{
		Tests.testMathlib("+", 2.0, 5.5);
		Tests.testMathlib("*", 4.0, 4.0);
		Tests.testMathlib("-", 2.0, 5.5);
		Tests.testMathlib("/", 2.0, 5.5);
		Tests.testMathlib("//", 101.0, 5.0);
		Tests.testMathlib("/", 101.0, 5.0);
	}
}