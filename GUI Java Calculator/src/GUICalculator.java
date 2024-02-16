/**
 * Class Name:			GUICalculator.java
 * Purpose:				A GUI class which instantiates a Calculator object and performs calculator operations on that object 
 * Coder:				Ivan Kepseu
 * Program Date:		Apr. 2, 2021
 */

import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;


public class GUICalculator extends JFrame {

	//Declaring useful fields and objects
	Calculator C1;
	private JMenu file, convert, help;
	private JMenuItem exit, hex, dec, oct, bin, howToUse, about;
	private JTextField calcInput;
	private JPanel buttonPanel;
	private JButton [] numberButtons;	
	private JButton clear, backSpace, percentage, plusMinus, square, squareRoot, blank;
	private Font font;
	private Font infoDisplay = new Font("Monospaced", Font.ITALIC, 15);
	
	private String calcDisplay;
	
	//Class Constructor
	public GUICalculator()
	{
		//Call to superclass constructor
		super("Calculator");
		
		//Set the layout manager
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setSize(300, 365);  	 			//suggested size 
		this.setResizable(false);  

		
		// Initialize class variables
		calcDisplay = "";
		C1 = new Calculator();
		
		//Create a customized font
		font = new Font("SansSerif", Font.PLAIN,22);
		
		//Calling the help methods to build the frame content
		buildMenu();
		buildInputField();
		buildButtonPanel();
		
		//Render the frame visible
		this.setVisible(true);
	}//End of the constructor
	
	/**	Method Name: buildMenu
	*	Purpose:	 A help method used to build the menu of the application 
	*	Accepts:	 No Argument
	*	Returns:	 Nothing
	*/
	public void buildMenu()
	{
		JMenuBar bar = new JMenuBar();
		MenuListener listener = new MenuListener();
		
		//Creating the menu options
		file = new JMenu("File");
		convert = new JMenu("Convert");
		help = new JMenu("Help");
		
		//Creating the menu items and adding a listener to them 
		exit = new JMenuItem("Exit");
		exit.addActionListener(listener);
		
		hex = new JMenuItem("Hex");
		hex.addActionListener(listener);
		dec = new JMenuItem("Dec");
		dec.addActionListener(listener);
		oct = new JMenuItem("Oct");
		oct.addActionListener(listener);
		bin = new JMenuItem("Bin");
		bin.addActionListener(listener);
		
		howToUse = new JMenuItem("How To Use");
		howToUse.addActionListener(listener);
		about = new JMenuItem("About");
		about.addActionListener(listener);
		
		//Adding the menu items to their respective options
		file.add(exit);
		
		convert.add(hex);
		convert.add(dec);
		convert.add(oct);
		convert.add(bin);
		
		help.add(howToUse);
		help.add(about);
		
		//Adding the options to the menu bar and setting the bar on the frame
		this.setJMenuBar(bar);
		bar.add(file);
		bar.add(convert);
		bar.add(help);
		
	}//End of buildMenu
	
	/**	Method Name: buildInputField
	*	Purpose:	 A help method used to build the input field of the application 
	*	Accepts:	 No Argument
	*	Returns:	 Nothing
	*/
	public void buildInputField()
	{
		//Creating the input field and styling it
		calcInput = new JTextField("0.0");
		calcInput.setFont(font);
		
		calcInput.setEditable(false);
		calcInput.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		calcInput.setBackground(Color.WHITE);
		calcInput.setHorizontalAlignment(JTextField.RIGHT);
		
		this.add(calcInput, BorderLayout.NORTH);
	}//End of builInputField
	
	/**	Method Name: buildButtonPanel
	*	Purpose:	 A help method used to build the container containing the buttons  of the application 
	*	Accepts:	 No Argument
	*	Returns:	 Nothing
	*/
	public void buildButtonPanel()
	{
		//Creating a panel for all our buttons and defining its layout
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(6,4,1,1));
		FunctionalButtonHandler function = new FunctionalButtonHandler(); 
		NumberButtonHandler number = new NumberButtonHandler();
		
		//Image objects ofr our icons
		Image bs_icon = new ImageIcon(this.getClass().getResource("/Backspace_Icon.jpg")).getImage();
		Image xSq_icon = new ImageIcon(this.getClass().getResource("/XSquare_Icon.png")).getImage();
		Image SquRt_icon = new ImageIcon(this.getClass().getResource("/SquareRoot_Icon.png")).getImage();
		
		//Creating, formatting and adding listeners to our buttons
		clear = new JButton("C");
		clear.addActionListener(function);
		clear.setBackground(Color.WHITE);
		clear.setFont(font);
		
		backSpace = new JButton();
		backSpace.addActionListener(function);
		backSpace.setBackground(Color.WHITE);
		backSpace.setIcon(new ImageIcon(bs_icon));
		backSpace.setPreferredSize(new Dimension(40, 40));
		
		percentage = new JButton("%");
		percentage.addActionListener(function);
		percentage.setBackground(Color.WHITE);
		percentage.setFont(font);
		
		plusMinus = new JButton("+/-");
		plusMinus.addActionListener(function);
		plusMinus.setBackground(Color.WHITE);
		plusMinus.setFont(font);
		
		square = new JButton();
		square.addActionListener(function);
		square.setBackground(Color.WHITE);
		square.setIcon(new ImageIcon(xSq_icon));
		square.setPreferredSize(new Dimension(40, 40));
		
		squareRoot = new JButton();
		squareRoot.addActionListener(function);
		squareRoot.setBackground(Color.WHITE);
		squareRoot.setIcon(new ImageIcon(SquRt_icon));
		squareRoot.setPreferredSize(new Dimension(40, 40));
		
		blank = new JButton("");
		blank.setBackground(Color.WHITE);
		
		//Adding all our functional buttons to the panel
		buttonPanel.add(clear);
		buttonPanel.add(backSpace);
		buttonPanel.add(percentage);
		buttonPanel.add(plusMinus);
		buttonPanel.add(square);
		buttonPanel.add(squareRoot);
		buttonPanel.add(blank);
		
		//This array will store all our no-functional buttons i.e numbers and operators
		numberButtons = new JButton[17];
		
		//Filling the array
		numberButtons[0] = new JButton("/");
		numberButtons[1] = new JButton("7");
		numberButtons[2] = new JButton("8");
		numberButtons[3] = new JButton("9");
		numberButtons[4] = new JButton("x");
		numberButtons[5] = new JButton("4");
		numberButtons[6] = new JButton("5");
		numberButtons[7] = new JButton("6");
		numberButtons[8] = new JButton("-");
		numberButtons[9] = new JButton("1");
		numberButtons[10] = new JButton("2");
		numberButtons[11] = new JButton("3");
		numberButtons[12] = new JButton("+");
		numberButtons[13] = new JButton("");
		numberButtons[14] = new JButton("0");
		numberButtons[15] = new JButton(".");
		numberButtons[16] = new JButton("=");
		
		//Styling and adding listeners to our buttons in the array
		for (int i = 0; i < numberButtons.length; i++)
		{
			numberButtons[i].setFont(font);
			numberButtons[i].setBackground(Color.WHITE);
			numberButtons[i].addActionListener(number);
		}
		
		//Add all buttons to panel
		for (int i = 0; i < numberButtons.length; i++)
			buttonPanel.add(numberButtons[i]);
		
		//Adding the panel to the frame
		this.add(buttonPanel, BorderLayout.SOUTH);
	}//End of buildButtonPanel
	
	/**
	 * Class Name:			MenuListener
	 * Purpose:				A private inner class that implements ActionListener of the menu options
	 * Coder:				Ivan Kepseu
	 */
	private class MenuListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == exit)
			{
				System.exit(0);
			}
			if(e.getSource() == hex)
			{
				try
				{
					calcDisplay = C1.convertHex(C1.getOperand());
					calcInput.setText(calcDisplay);
				}
				catch (EmptyOperandException e1)
				{
					calcInput.setText(e1.getMessage());
				}
				catch (LongOperandException e1)
				{
					calcInput.setText(e1.getMessage());
				}
			}
			if(e.getSource() == oct)
			{
				try
				{
					calcDisplay = C1.convertOct(C1.getOperand());
					calcInput.setText(calcDisplay);
				}
				catch (EmptyOperandException e1)
				{
					calcInput.setText(e1.getMessage());
				}
				catch (LongOperandException e1)
				{
					calcInput.setText(e1.getMessage());
				}
			}
			if(e.getSource() == bin)
			{
				try
				{
					calcDisplay = C1.convertBin(C1.getOperand());
					calcInput.setText(calcDisplay);
				}
				catch (EmptyOperandException e1)
				{
					calcInput.setText(e1.getMessage());
				}
				catch (LongOperandException e1)
				{
					calcInput.setText(e1.getMessage());
				}
			}
			if(e.getSource() == dec)
			{
					calcInput.setText(C1.getOperand());
			}
			
			if(e.getSource() == howToUse)
			{
				JTextArea manual = new JTextArea();
				
				manual.setFont(infoDisplay);
				manual.setEditable(false);
				manual.setBackground(Color.LIGHT_GRAY);
				manual.setText("Convert to any format using the convert option:\n"
								+ "Bin = Binary, Hex = Hexadecimal, Oct = Octadecimal, Dec = Decimal.\n"
								+ "Exit to exit the application.\n"
								+ "Click on a number, a decimal, or the +/- sign to enter an operand, then click on an operator\n"
								+ "Add another operand then click on the equal sign to proceed./n"
								+ " C = Clear, to clear after an operation");
				
				JOptionPane.showMessageDialog(null, manual,
						"How To Use", JOptionPane.INFORMATION_MESSAGE);
			}
			if(e.getSource() == about)
			{
				JTextArea ab = new JTextArea();
				
				ab.setFont(infoDisplay);
				ab.setEditable(false);
				ab.setBackground(Color.LIGHT_GRAY);
				ab.setText("Made by Ivan Kepseu\n"
							+ "Version 1.0\n"
							+ "Hope you Enjoy it ;)");
				
				JOptionPane.showMessageDialog(null, ab,
						"How To Use", JOptionPane.INFORMATION_MESSAGE);
			}	
		}
	}//End of private class MenuListener
	
	/**
	 * Class Name:			FunctionalButtonHandler
	 * Purpose:				A private inner class that implements a listener for all the functional buttons
	 * Coder:				Ivan Kepseu
	 */
	private class FunctionalButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == clear)
			{
				C1.clear();
				calcInput.setText("0.0");
			}
			else if(e.getSource() == backSpace)
			{		
				
				try{
					calcInput.setText(C1.backspace(C1.getOperand()));
					calcDisplay = calcInput.getText();
					C1.setOperand(calcDisplay);
				}
				catch (EmptyOperandException e1)
				{				
					calcInput.setText(e1.getMessage());
				}
				if(calcInput.getText().length() == 0)
				{
					calcInput.setText("0.0");
				}
			}
			else if(e.getSource() == percentage)
			{
				calcDisplay = calcInput.getText();
				try
				{
					calcInput.setText(C1.findPercentage(C1.getOperand()));
				}
				catch (EmptyOperandException e1)
				{
					calcInput.setText(e1.getMessage());
				}
			}
			else if(e.getSource() == plusMinus)
			{
				try {
					boolean flag = true;
					C1.setOperand(C1.togglePlusMinus(flag));
					calcInput.setText(C1.getOperand());
					calcDisplay = calcInput.getText();
					
				} catch (EmptyOperandException e1) {
					calcInput.setText(e1.getMessage());
				}
			}
			else if(e.getSource() == square)
			{
				try {
					C1.setOperand(C1.findSquared(C1.getOperand()));
					calcInput.setText(C1.getOperand());
				} catch (EmptyOperandException e1) {
					calcInput.setText(e1.getMessage());
				}
			}
			else if(e.getSource() == squareRoot)
			{
				try {
					C1.setOperand(C1.findSquareRoot(C1.getOperand()));
					calcInput.setText(C1.getOperand());
				} catch (EmptyOperandException e1) {
					calcInput.setText(e1.getMessage());
				}
			}
		}
		
	}//End of private class FunctionalButtonHandler
	
	/**
	 * Class Name:			NumberButtonHandler
	 * Purpose:				A private inner class that implements a listener for all the number buttons and operators button
	 * Coder:				Ivan Kepseu
	 */
	private class NumberButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			for(int x = 0; x < numberButtons.length; x++)
			{
				if(e.getSource() == numberButtons[0])
				{
					calcInput.setText(C1.getOperand() + "/");
					try {
						C1.buildExpression("/");
						C1.setOperator("/");
					} catch (LongOperandException e1) {
						calcInput.setText(e1.getMessage());
					}
					catch(ArithmeticException e1)
					{
						e1.printStackTrace();
						System.out.println("Not divisible by 0");
					}
				}
				else if(e.getSource() == numberButtons[4])
				{
					calcInput.setText(C1.getOperand() + "x");
					try {
						C1.buildExpression("x");
						C1.setOperator("x");
					} catch (LongOperandException e1) {
						calcInput.setText(e1.getMessage());
					}
				}
				else if(e.getSource() == numberButtons[8])
				{
					calcInput.setText(C1.getOperand() + "-");
					try {
						C1.buildExpression("-");
						C1.setOperator("-");
					} catch (LongOperandException e1) {
						calcInput.setText(e1.getMessage());
					}
				}
				else if(e.getSource() == numberButtons[12])
				{
					calcInput.setText(C1.getOperand() + "+");
					try {
						C1.buildExpression("+");
						C1.setOperator("+");
					} catch (LongOperandException e1) {
						calcInput.setText(e1.getMessage());
					}
				}
				else if(e.getSource() == numberButtons[16])
				{
					try {
						C1.buildOperand(C1.calculate() + "");
						calcInput.setText(C1.getOperand());
					}  catch (EmptyOperandException e1) {
						calcInput.setText(e1.getMessage());
					} catch (ArithmeticException e1) {
						calcInput.setText("0.0");
					}catch (LongOperandException e1) {
						calcInput.setText(e1.getMessage());
					}
				}
				else if(e.getSource() == numberButtons[15])
				{
					if(!C1.isDecimalPressed())
					{
						try {
							C1.buildOperand(".");
							calcInput.setText(C1.getOperator() + C1.getOperand());
						} catch (LongOperandException e1) {
							calcInput.setText(e1.getMessage());
						}	
					}
					C1.setDecimalPressed(true);
				}
				else if (e.getSource() == numberButtons[x])
				{
					try {
						C1.buildOperand(String.valueOf(numberButtons[x].getText()));
						calcInput.setText(C1.getOperator() + C1.getOperand());
					} catch (LongOperandException e1) {
						calcInput.setText(e1.getMessage());
					}					
				}
			}
		}
	}//End of private class NumberButtonHandler
	
	private static void setLookAndFeel()
	{
		try
		{
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}	
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}	
	}//End of setLookAndFeel method
	
	/**	Method Name: main
	*	Purpose:	 A main method to test our program
	*/
	public static void main (String[] args)
	{
		setLookAndFeel();
		new GUICalculator();
	}
}
//End of class