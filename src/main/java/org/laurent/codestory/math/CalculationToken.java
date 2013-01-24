package org.laurent.codestory.math;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Stack;

abstract class CalculationToken extends Token {

	CalculationToken(String value) {
		super(value);
	}

	abstract void mutateStackForCalculation(Stack<BigDecimal> stack, Map<String, BigDecimal> variableValues);

}