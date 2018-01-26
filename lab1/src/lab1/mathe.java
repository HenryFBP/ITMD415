package lab1;

public enum mathe
{
	
	HOST("localhost"),

	/*** This matches any math operator (*, **, /, //, %, -, +), but not dots (.). ***/
	RX_ONLY_OP	("[^\\s\\d\\.]+"),
	
	PLUS		("+"),
	MINUS		("-"),
	TIMES		("*"),
	POW			("**"),
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
