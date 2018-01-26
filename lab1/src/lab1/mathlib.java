package lab1;

import java.util.ArrayList;
import java.util.function.Function;

public class mathlib
{
	
	/**
	 * @param o The string operator (+-/*%).
	 * @return A {@link Function} that takes two numbers in an {@link ArrayList} and
	 * applies the operator that matches with it.
	 * 
	 */
	public static Function<ArrayList<Double>, Double> operator(String o)
	{
		if(lib.contains(o, mathe.DIVIDEF.s()))
		{
			return (n) -> Math.floor(n.get(0) / n.get(1));
		}
		else if(lib.contains(o, mathe.POW.s()))
		{
			return (n) -> Math.pow(n.get(0), n.get(1));
		}
		else if(lib.contains(o, mathe.PLUS.s()))
		{
			return (n) -> n.get(0) + n.get(1);
		}
		else if(lib.contains(o, mathe.MINUS.s()))
		{
			return (n) -> n.get(0) - n.get(1);
		}
		else if(lib.contains(o, mathe.TIMES.s()))
		{
			return (n) -> n.get(0) * n.get(1);
		}

		else if(lib.contains(o, mathe.DIVIDE.s()))
		{
			return (n) -> n.get(0) / n.get(1);
		}
		else if(lib.contains(o, mathe.MODULO.s()))
		{
			return (n) -> n.get(0) % n.get(1);
		}
		return null;
	}
}
