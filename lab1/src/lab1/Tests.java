package lab1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

public class Tests
{
	public static void main(String[] args)
	{
		Tests.runTests(); // test library funcs

		// localClient();

		MathServerSocket mathServerSocket = new MathServerSocket(MathE.HOST.s());

		mathServerSocket.start();

	}

	/***
	 * Pretend to be a CLI client that can ask the 'math server' (not a server here)
	 * some math. Used to test the statement parser.
	 */
	public static void localClient()
	{
		String in = "";
		Scanner s = new Scanner(System.in);

		System.out.println("(Q) will quit.");
		while(in.compareToIgnoreCase("Q") != 0)
		{
			System.out.print("Enter statement to be parsed by MathOTron9000: \n > ");
			in = s.nextLine();

			testStatementMatching(in);
		}
	}

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
		Statement statement = new Statement(str);

		System.out.println(String.format("'%15s' -> %s", str, statement.toString()));
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
