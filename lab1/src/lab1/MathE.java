package lab1;

public enum MathE
{
	
	HOST("localhost"),
	PORT(1234),

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

	private Object constants;

	private MathE(String s)
	{
		this.constants = s;
	}
	
	private MathE(int i)
	{
		this.constants = i;
	}

	@Override
	public String toString()
	{
		return (String) this.constants;
	}

	public int toInt()
	{
		return (int) this.constants;
	}
	
	public String s()
	{
		return this.toString();
	}

	public int i()
	{
		return this.toInt();
	}

}
