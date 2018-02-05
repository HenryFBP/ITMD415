package testWebProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import javax.servlet.ServletContext;

public class lib
{
	public static double randomNumber()
	{
		return (new Random()).nextDouble() * 100;
	}

	public static String fileToString(String s)
	{
		return fileToString(new File(s));
	}

	public static String fileToString(File f)
	{
		Scanner s = null;
		String line = "";
		String lines = "";

		try
		{
			s = new Scanner(f);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			return "";
		}

		while(s.hasNext())
		{
			line = s.nextLine();
			lines += line;
		}

		s.close();

		return lines;
	}
}
