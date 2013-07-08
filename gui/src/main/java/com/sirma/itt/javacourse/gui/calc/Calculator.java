package com.sirma.itt.javacourse.gui.calc;

import com.sirma.itt.javacourse.gui.config.Config;

/**
 * Calculator class. Generate numbers and perform all needed calculation
 * operation.
 * 
 * @version 1.1 14 June 2013
 * @author Stella Djulgerova
 */
public class Calculator {

	// class private members
	private StringBuilder firstNumber = new StringBuilder();
	private StringBuilder secondNumber = new StringBuilder();

	private String operator = "";
	private String result = "";
	private boolean sign = false;

	/**
	 * Determine which operand is currently in use.
	 * 
	 * @return - operand in use
	 */
	private StringBuilder getOperand() {
		if ("".equals(operator)) {
			return firstNumber;
		} else {
			return secondNumber;
		}
	}

	/**
	 * Concatenate entered chars in one string.
	 * 
	 * @param value
	 *            - entered char
	 * @return - operand
	 */
	public String generateNumber(String value) {

		if (getOperand().length() == Config.MAX_SIZE) {
			return getOperand().toString();
		}

		if ("0".equals(value) && getOperand().length() == 0) {
			return "0";
		}

		return getOperand().append(value).toString();
	}

	/**
	 * Set operation chosen by user.
	 * 
	 * @param value
	 *            - entered operator
	 */
	public void setOperator(String value) {
		if (!"".equals(firstNumber.toString())
				&& "".equals(secondNumber.toString())) {
			operator = value;
		}
	}

	/**
	 * Set point to operand.
	 * 
	 * @return - operand
	 */
	public String setDot() {
		if (getOperand().length() == Config.MAX_SIZE) {
			return getOperand().toString();
		}

		if (getOperand().length() == 0) {
			return "0";
		}

		if (getOperand().indexOf(".") == -1) {
			getOperand().append(".");
		}

		return getOperand().toString();
	}

	/**
	 * Set sign to operand.
	 * 
	 * @return - operand
	 */
	public String setSign() {

		if (getOperand().length() == Config.MAX_SIZE) {
			return getOperand().toString();
		}

		if (getOperand().length() == 0) {
			return "0";
		}

		if (sign) {
			sign = false;
			return getOperand().deleteCharAt(0).toString();
		} else {
			sign = true;
			return getOperand().insert(0, "-").toString();
		}
	}

	/**
	 * Execute chosen buy user operation and return result.
	 * 
	 * @return - result after calculation
	 */
	public String calculate() {
		
		if("".equals(firstNumber.toString()) || "".equals(secondNumber.toString())) {
			clear();
			return "0";
		}
		
		if ("".equals(operator)) {
			if (getOperand().length() == 0) {
				clear();
				return "0";
			}
			result = getOperand().toString();
		}

		if ("+".equals(operator)) {
			result = Double.toString(Double.parseDouble(firstNumber.toString())
					+ Double.parseDouble(secondNumber.toString()));
		}

		if ("-".equals(operator)) {
			result = Double.toString(Double.parseDouble(firstNumber.toString())
					- Double.parseDouble(secondNumber.toString()));
		}

		if ("*".equals(operator)) {
			result = Double.toString(Double.parseDouble(firstNumber.toString())
					* Double.parseDouble(secondNumber.toString()));
		}

		if ("/".equals(operator)) {
			if ("0".equals(secondNumber.toString())) {
				clear();
				return "Division by zero";
			}
			result = Double.toString(Double.parseDouble(firstNumber.toString())
					/ Double.parseDouble(secondNumber.toString()));
		}

		clear();
		return filter(result);
	}

	/**
	 * Clear display and all variables.
	 */
	public void clear() {
		firstNumber.setLength(0);
		secondNumber.setLength(0);
		operator = "";
		sign = false;
	}

	/**
	 * Remove useless zero digits from result.
	 * 
	 * @return - formated result
	 */
	public String filter(String result) {
		if (result.indexOf(".") != -1) {
			while (result.endsWith("0")) {
				result = result.substring(0, result.length() - 1);
				if (result.endsWith(".")) {
					result = result.substring(0, result.length() - 1);
					break;
				}
			}
		}
		return result;
	}

	/**
	 * Clear last symbol from currently used operand.
	 * 
	 * @return - operand
	 */
	public String clearLastDigit() {

		if (getOperand().length() == 1) {
			getOperand().deleteCharAt(getOperand().length() - 1);
			return "0";
		}

		if (getOperand().length() > 1) {
			return getOperand().deleteCharAt(getOperand().length() - 1)
					.toString();
		} else {
			return "0";
		}
	}
}