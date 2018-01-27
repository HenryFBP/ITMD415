package lab1;

public class HLib
{	
	/***
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
	
	
}
