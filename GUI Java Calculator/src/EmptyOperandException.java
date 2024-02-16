/**
 * Class Name:			EmptyOperandException.java
 * Purpose:				An exception class which will throw an exception if no operand has been entered
 * Coder:				Ivan Kepseu
 * Program Name:		Apr. 2, 2021
 */

public class EmptyOperandException extends Exception{

	EmptyOperandException()
	{
		super("0.0");
	}
}
//End of class