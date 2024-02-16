# GUI Calculator Project README

## Overview

Welcome to the GUI Calculator project! This Java project is designed to provide a graphical user interface for a simple calculator. It allows users to perform basic arithmetic operations, as well as additional functionalities such as percentage calculation, square root, and more.

## Project Structure

### 1. Calculator.java

#### Purpose:

This class represents the core logic of the calculator. It includes methods for basic arithmetic operations, handling exceptions, and converting numbers between different bases (binary, octal, decimal, hexadecimal).

#### Key Methods:

- `clear()`: Clear all fields.
- `backspace(String value)`: Remove the last number or decimal from the value.
- `findPercentage(String value)`: Return the current value as a percentage in decimal format.
- `togglePlusMinus(boolean flag)`: Add or remove "-" to the beginning of the operand.
- `findSquared(String value)`: Return the square of the current value.
- `findSquareRoot(String value)`: Return the square root of the current value.
- `buildOperand(String value)`: Concatenate the current value to the operand.
- `buildExpression(String value)`: Assign the value to the operator and add both the operand and operator to the list.
- `calculate()`: Add the current operand to the list and calculate the answer using the values in the list applying the rules of BEDMAS.
- `convertHex(String value)`: Return value converted to its hexadecimal equivalent.
- `convertOct(String value)`: Return value converted to its octal equivalent.
- `convertBin(String value)`: Return value converted to its binary equivalent.

#### Relationships:

- This class is used by the GUI to perform calculations based on user input.

### 2. EmptyOperandException.java

#### Purpose:

An exception class that is thrown if no operand has been entered.

#### Relationships:

- Used by Calculator.java to handle cases where an operand is expected but not provided.

### 3. LongOperandException.java

#### Purpose:

An exception class that is thrown if an operand is too long for the text field display area.

#### Relationships:

- Used by Calculator.java to handle cases where the operand exceeds the allowable length for display.

### 4. GUICalculator.java

#### Purpose:

This class represents the graphical user interface of the calculator. It utilizes Java Swing for building the GUI components.

#### Key Methods:

- `buildMenu()`: Build the menu of the application.
- `buildInputField()`: Build the input field of the application.
- `buildButtonPanel()`: Build the container containing the buttons of the application.
- `main(String[] args)`: Main method to test the program.

#### Relationships:

- Utilizes Calculator.java for performing calculations based on user input.
- Utilizes EmptyOperandException.java and LongOperandException.java for handling exceptions.

#### Running the Application
- Compile and run the GUICalculator class to start the GUI Calculator application.

## How to Use

### Menu Options

- **File:** Provides the option to exit the application.
  
- **Convert:** Allows conversion between different number bases (Hex, Dec, Oct, Bin).

- **Help:** Provides information on how to use the calculator and details about the application.

### Functional Buttons

- **C (Clear):** Clears all fields.

- **Backspace:** Removes the last character from the operand.

- **% (Percentage):** Converts the operand to a percentage.

- **+/- (Toggle Plus/Minus):** Adds or removes a negative sign from the operand.

- **x² (Square):** Calculates the square of the operand.

- **√ (Square Root):** Calculates the square root of the operand.

### Number Buttons and Operators

- Click on numbers, decimal points, or the +/- sign to enter operands.

- Click on operators (+, -, x, /) to perform arithmetic operations.

- Click on "=" to calculate the result.

### Conversion

- Use the "Convert" menu to switch between different number bases.

- Access the "How To Use" option in the "Help" menu for a detailed guide on using the calculator.

#### Dependencies
- The application uses the Nimbus Look and Feel for styling.

## Features

- Basic arithmetic operations (addition, subtraction, multiplication, division).
- Additional functionalities such as percentage, square root, and more.
- Conversion of numbers between binary, octal, decimal, and hexadecimal.
- User-friendly graphical user interface.

#### Additional Notes
- The application supports a user-friendly interface with input fields, buttons, and menus.
- Exception handling ensures proper error messages for various scenarios.
- Conversion options provide versatility in working with different number bases.

## Acknowledgments

- **Author:** Ivan Kepseu
- **Version:** 1.0 (Apr. 2, 2021)

## Version Control

- This README corresponds to version 1.0 of the GUI Calculator project.

Enjoy using the GUI Calculator! If you have any questions or feedback, feel free to contact the author.
