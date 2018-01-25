package lab1;

public enum mathe
{

	HOST("localhost"),

	PLUS		("+"),
	MINUS		("-"),
	TIMES		("*"),
	DIVIDE		("/"),
	DIVIDEF		("//"),
	MODULO		("%"),
	
	;

	private String constants;

	private mathe(String s)
	{
		this.constants = s;
	}

	@Override
	public String toString()
	{
		return this.constants;
	}

	public String s()
	{
		return this.toString();
	}


}
