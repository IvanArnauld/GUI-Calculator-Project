/**
 * Class Name:			Calculator.java
 * Purpose:				A class to be used to create a Calculator object and all its methods
 * Coder:				Ivan Kepseu
 * Program Name:		Apr. 2, 2021
 */

import java.util.ArrayList;

public class Calculator {

	//Declaring private variables
	private String operand;
	private String operator;
	private boolean decimalPressed;
	private ArrayList<String> list;
	
	//Declaring helping variables
	int k = 0;
	int l = 1;
	int m = 2;
	String op;
	
	//No-argument constructor, which initializes fields
	public Calculator() 
	{
		this.operand = "";
		this.operator = "";
		this.decimalPressed = false;
		this.list = new ArrayList<String>();
	}

	//Accessors (getters)
	public String getOperand() {
		return operand;
	}
	public String getOperator() {
		return operator;
	}
	public boolean isDecimalPressed() {
		return decimalPressed;
	}

	//Mutators (setters)
	public void setOperand(String operand) {
		this.operand = operand;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public void setDecimalPressed(boolean decimalPressed) {
		this.decimalPressed = decimalPressed;
	}
	
	/**	Method Name: clear
	*	Purpose:	 Clear all fields(back to their default).
	*	Accepts:	 No Argument
	*	Returns:	 Nothing
	*/
	public void clear()
	{
		this.operand = "";
		this.operator = "";
		this.decimalPressed = false;
	}//End of method
	
	/**	Method Name: backspace
	*	Purpose:	 Return value with the last number or decimal removed, if value is not empty 
	*	Accepts:	 String
	*	Returns:	 String
	*/
	public String backspace(String value) throws EmptyOperandException
	{
		if(this.operand.isEmpty())
		{
			throw new EmptyOperandException();
		}
		
		String newValue = "backspace";
		newValue = value.substring(0, value.length()-1);
		
		return newValue;
	}//End of method
	
	/**	Method Name: findPercentage
	*	Purpose:	 Return the current value as a percentage in decimal format, if value is not empty 
	*	Accepts:	 String
	*	Returns:	 String
	*/
	public String findPercentage(String value) throws EmptyOperandException
	{
		if(this.operand.isEmpty())
		{
			throw new EmptyOperandException();
		}
		
		String newValue = "findPercentage";
		newValue = value;
		double percent = Double.parseDouble(newValue);
		percent = percent / 100.0;
		newValue = percent + "";
		
		return newValue;
	}//End of method
	
	/**	Method Name: togglePlusMinus
	*	Purpose:	 Add “-“ to the beginning of operand or remove “-“ from the operand
	*	Accepts:	 boolean
	*	Returns:	 String
	*/
	public String togglePlusMinus(boolean flag) throws EmptyOperandException
	{
		if(this.operand.isEmpty())
		{
			throw new EmptyOperandException();
		}
		
		String sign = "";
		if(flag == true)
		{
			sign = "-";
		}
		else
		{
			sign = "";
		}
		
		if(this.operand.substring(0, 1).equals("-"))
		{
			sign = "";
			this.operand = this.operand.substring(1, this.operand.length());
		}
		
		this.operand = sign + this.operand;
		op = this.operand;
		return this.operand;
	}//End of method
	
	/**	Method Name: findSquared
	*	Purpose:	 Return the square of the current value  
	*	Accepts:	 String
	*	Returns:	 String
	*/
	public String findSquared(String value) throws EmptyOperandException
	{
		if(this.operand.isEmpty())
		{
			throw new EmptyOperandException();
		}
		
		String newValue = value;
		double squaredVal = Double.parseDouble(newValue);
		squaredVal = squaredVal * squaredVal;
		newValue = Double.toString(squaredVal);
		return newValue;
	}//End of method
	
	/**	Method Name: findSquareRoot
	*	Purpose:	 Return the square root of the current value 
	*	Accepts:	 String
	*	Returns:	 String
	*/
	public String findSquareRoot(String value) throws EmptyOperandException
	{
		if(this.operand.isEmpty())
		{
			throw new EmptyOperandException();
		}
		
		String newValue = value;
		double squarerootVal = Double.parseDouble(newValue);
		squarerootVal = Math.sqrt(squarerootVal);
		newValue = Double.toString(squarerootVal);
		return newValue;
	}//End of method
	
	/**	Method Name: buildOperand
	*	Purpose:	 Concatenate the current value to operand
	*	Accepts:	 String
	*	Returns:	 Nothing
	*/
	public void  buildOperand(String value) throws LongOperandException
	{
		if(this.operand.length() > 12)
		{
			throw new LongOperandException();
		}
		this.operand = this.operand + value;
		op = this.operand;
	}//End of method
	
	/**	Method Name: buildExpression
	*	Purpose:	 Assign the value to operator and add both the operand and operator to the list 
	*	Accepts:	 String
	*	Returns:	 Nothing
	*/
	public void buildExpression(String value) throws LongOperandException
	{
		if(this.operand.length() > 12)
		{
			throw new LongOperandException();
		}
		
		
		setOperator(value);
		list.add(k, op);
		list.add(l, operator);
		clear();
	}//End of method
	
	/**	Method Name: calculate
	*	Purpose:	 Add the current operand to the list, calculate the answer, using the values in the list applying the rules of BEDMAS 
	*	Accepts:	 String
	*	Returns:	 A double
	*/
	public double calculate()  throws EmptyOperandException, ArithmeticException
	{
		
		if(this.operand.isEmpty())
		{
			throw new EmptyOperandException();
		}
		this.list.add(l, operator);
		this.list.add(m, this.operand);
		String division = "/";
		String multiplication = "x";
		String addition = "+";
		//String substraction = "-";
		double op1 = Double.parseDouble(list.get(k));
		double op2 = Double.parseDouble(list.get(m));
		double answer;
		
		if(list.get(l).equals(division))
		{
			if(op2 == 0)
			{
				throw new ArithmeticException();
			}
			answer = (double)op1 / op2;
		}
		else if(list.get(l).equals(multiplication))
		{
			answer = (double)op1 * op2;
		}
		else if(list.get(l).equals(addition))
		{
			answer = op1 + op2;
		}
		else
		{
			answer = op1 - op2;
		}
		
		clear();
		
		return answer;
	}//End of method
	
	/**	Method Name: convertHex
	*	Purpose:	 Return value converted to its hexadecimal equivalent
	*	Accepts:	 String
	*	Returns:	 String
	*/
	public String convertHex(String value) throws EmptyOperandException, LongOperandException
	{
		if(this.operand.isEmpty())
		{
			throw new EmptyOperandException();
		}
		
		if(this.operand.length() > 12)
		{
			throw new LongOperandException();
		}
		
		char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		int remainder;
		String hexValue = "";
		
		double newValue = Double.parseDouble(value);
		newValue = Math.round(newValue);
		int intValue = (int)newValue;
		
		while(intValue > 0)
	     {
			remainder = intValue % 16; 
			hexValue = hex[remainder] + hexValue; 
	       intValue = intValue / 16;
	     }
		
		return hexValue;
	}//End of method
	
	/**	Method Name: convertOct
	*	Purpose:	 Return value converted to its octal equivalent 
	*	Accepts:	 String
	*	Returns:	 String
	*/
	public String convertOct(String value) throws EmptyOperandException, LongOperandException
	{
		if(this.operand.isEmpty())
		{
			throw new EmptyOperandException();
		}
		
		if(this.operand.length() > 12)
		{
			throw new LongOperandException();
		}
		
		char oct[]={'0','1','2','3','4','5','6','7'};
		int remainder;
		String octValue = "";
		
		double newValue = Double.parseDouble(value);
		newValue = Math.round(newValue);
		int intValue = (int)newValue;
		
		while(intValue > 0)
	     {
			remainder = intValue % 8; 
			octValue = oct[remainder] + octValue; 
	       intValue = intValue / 8;
	     }
		
		return octValue;
	}//End of method
	
	/**	Method Name: convertBin
	*	Purpose:	 Return value converted to its binary equivalent  
	*	Accepts:	 String
	*	Returns:	 String
	*/
	public String convertBin(String value) throws EmptyOperandException, LongOperandException
	{
		if(this.operand.isEmpty())
		{
			throw new EmptyOperandException();
		}
		
		if(this.operand.length() > 12)
		{
			throw new LongOperandException();
		}
		
		char bin[]={'0','1'};
		int remainder;
		String binValue = "";
		
		double newValue = Double.parseDouble(value);
		newValue = Math.round(newValue);
		int intValue = (int)newValue;
		
		while(intValue > 0)
	     {
			remainder = intValue % 2; 
			binValue = bin[remainder] + binValue; 
	       intValue = intValue / 2;
	     }
		
		return binValue;
	}//End of method

	/**	Method Name: toString
	*	Purpose:	 Return a String representation of a Calculator object 
	*	Accepts:	 No Argument
	*	Returns:	 String
	*/
	@Override
	public String toString() {
		return "Calculator [Operand = " + this.operand + 
							", Operator = " + this.operator + 
							", Decimal Pressed? = " + this.decimalPressed + 
							", List = " + this.list + "]";
	}//End of method
}
//End of class