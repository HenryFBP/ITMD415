package lab1;

import java.util.ArrayList;
import java.util.function.Function;

public class mathlib
{
	
	/**
	 * @param o The string operator (+-/*%).
	 * @return A function that takes two numbers in an ArrayList and 
	 */
	public static Function<ArrayList<Double>, Double> operator(String o)
	{
		if(o.compareToIgnoreCase(mathe.PLUS.s()) == 0)
		{
			return (it) -> it.get(0) + it.get(1);
		}
		else if(o.compareToIgnoreCase(mathe.MINUS.s()) == 0)
		{
			return (it) -> it.get(0) - it.get(1);
		}
		//TODO add more ifs
		return null;
	}
	
	public static double parseMath(String m)
	{
		return 0;
	}
}
