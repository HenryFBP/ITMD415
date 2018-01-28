package lab1;

import java.util.ArrayList;
import java.util.function.Function;

public class MathLib
{

	/**
	 * @param o The string operator (+-/*%).
	 * @return A {@link Function} that takes two numbers in an {@link ArrayList} and
	 *         applies the operator that matches with it.
	 * 
	 */
	public static Function<ArrayList<Double>, Double> operator(String o)
	{
		if(HLib.contains(o, MathE.DIVIDEF.s()))
		{
			return (n) -> Math.floor(n.get(0) / n.get(1));
		}
		else if(HLib.contains(o, MathE.POW.s()))
		{
			return (n) -> Math.pow(n.get(0), n.get(1));
		}
		else if(HLib.contains(o, MathE.PLUS.s()))
		{
			return (n) -> n.get(0) + n.get(1);
		}
		else if(HLib.contains(o, MathE.MINUS.s()))
		{
			return (n) -> n.get(0) - n.get(1);
		}
		else if(HLib.contains(o, MathE.TIMES.s()))
		{
			return (n) -> n.get(0) * n.get(1);
		}

		else if(HLib.contains(o, MathE.DIVIDE.s()))
		{
			return (n) -> n.get(0) / n.get(1);
		}
		else if(HLib.contains(o, MathE.MODULO.s()))
		{
			return (n) -> n.get(0) % n.get(1);
		}
		return null;
	}
}
