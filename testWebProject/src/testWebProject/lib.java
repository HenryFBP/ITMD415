package testWebProject;

import java.util.Random;

public class lib
{
	 public static double randomNumber()
	 {
	   Random r = new Random();
	   double d = r.nextDouble() * 100;
	   
	   return d;
	 }
}
