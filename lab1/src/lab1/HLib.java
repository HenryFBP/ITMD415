package lab1;

public class HLib
{
	/***
	 * Searches the string 'haystack' for the string 'needle'.
	 * 
	 * @param haystack The string to be searched for needle.
	 * @param needle
	 * @return If the String needle is in the String haystack.
	 */
	public static boolean contains(String haystack, String needle)
	{
		if(haystack.compareTo(needle) == 0)
		{
			return true;
		}

		return false;
	}

	/***
	 * 
	 * @param in Input string.<br>
	 * @param quit Marker that tells you when to quit<br>
	 * @return Whether or not the input string wants to quit.<br>
	 *         Example: <code>sC("i wanna quit","quit") -> True</code>
	 */
	public static boolean shouldContinue(String in, String quit)
	{
		if(contains(in, quit))
		{
			return false;
		}
		return true;
	}
	
	/**
	 * @see {@link HLib#shouldContinue(String, String)}
	 */
	public static boolean shouldContinue(String in, char q)
	{
		return shouldContinue(in, String.valueOf(q));
	}

}
