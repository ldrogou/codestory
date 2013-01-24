package org.laurent.codestory.math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This is a Builder implementation for the exp4j API used to create a Calculable instance for the user
 * 
 * @author frank asseg
 * 
 */
public class ExpressionBuilder {

	/**
	 * Property name for unary precedence choice. You can set System.getProperty(PROPERTY_UNARY_HIGH_PRECEDENCE,"false")
	 * in order to change evaluation from an expression like "-3^2" from "(-3)^2" to "-(3^2)"
	 */
	public static final String PROPERTY_UNARY_HIGH_PRECEDENCE = "exp4j.unary.precedence.high";

	private final Map<String, BigDecimal> variables = new LinkedHashMap<String, BigDecimal>();

	
	private final Map<String, CustomOperator> builtInOperators;

	private Map<String, CustomOperator> customOperators = new HashMap<String, CustomOperator>();

	private final List<Character> validOperatorSymbols;

	private final boolean highUnaryPrecedence;

	private String expression;

	/**
	 * Create a new ExpressionBuilder
	 * 
	 * @param expression
	 *            the expression to evaluate 
	 */
	public ExpressionBuilder(String expression) {
		if (expression.trim().isEmpty()) {
			throw new IllegalArgumentException("Expression can not be empty!.");
		}
		this.expression = expression;
		highUnaryPrecedence = System.getProperty(PROPERTY_UNARY_HIGH_PRECEDENCE) == null
				|| !System.getProperty(PROPERTY_UNARY_HIGH_PRECEDENCE).equals("false");
		builtInOperators = getBuiltinOperators();
		validOperatorSymbols = getValidOperators();
	}

	private List<Character> getValidOperators() {
		return Arrays.asList('!', '#', '$', '&', ';', ':', '~', '<', '>', '|', '=');
	}

	private Map<String, CustomOperator> getBuiltinOperators() {
		CustomOperator add = new CustomOperator("+") {
			@Override
			protected BigDecimal applyOperation(BigDecimal[] values) {
				return values[0].add(values[1], MathContext.UNLIMITED);
			}
                        
		};
		CustomOperator sub = new CustomOperator("-") {
			@Override
			protected BigDecimal applyOperation(BigDecimal[] values) {
				return values[0].subtract(values[1], MathContext.UNLIMITED);
			}
		};
		CustomOperator div = new CustomOperator("/", 3) {
			@Override
			protected BigDecimal applyOperation(BigDecimal[] values) {
				if (values[1].compareTo(BigDecimal.ZERO) == 0) {
					throw new ArithmeticException("Division by zero!");
				}
				return values[0].divide(values[1]);
			}
		};
		CustomOperator mul = new CustomOperator("*", 3) {
			@Override
			protected BigDecimal applyOperation(BigDecimal[] values) {
				return values[0].multiply(values[1]);
			}
		};
		
		Map<String, CustomOperator> operations = new HashMap<String, CustomOperator>();
		operations.put("+", add);
		operations.put("-", sub);
		operations.put("*", mul);
		operations.put("/", div);
		return operations;
	}


	/**
	 * build a new {@link Calculable} from the expression using the supplied variables
	 * 
	 * @return the {@link Calculable} which can be used to evaluate the expression
	 * @throws UnknownFunctionException
	 *             when an unrecognized function name is used in the expression
	 * @throws UnparsableExpressionException
	 *             if the expression could not be parsed
	 */
	public Calculable build() throws UnknownFunctionException, UnparsableExpressionException {
		for (CustomOperator op : customOperators.values()) {
			for (int i = 0; i < op.symbol.length(); i++) {
				if (!validOperatorSymbols.contains(op.symbol.charAt(i))) {
					throw new UnparsableExpressionException("" + op.symbol
							+ " is not a valid symbol for an operator please choose from: !,#,§,$,&,;,:,~,<,>,|,=");
				}
			}
		}
		for (String varName : variables.keySet()) {
			checkVariableName(varName);
		}
		builtInOperators.putAll(customOperators);
		return RPNConverter.toRPNExpression(expression, variables, builtInOperators);
	}

	private void checkVariableName(String varName) throws UnparsableExpressionException {
		char[] name = varName.toCharArray();
		for (int i = 0; i < name.length; i++) {
			if (i == 0) {
				if (!Character.isLetter(name[i]) && name[i] != '_') {
					throw new UnparsableExpressionException(varName + " is not a valid variable name: character '"
							+ name[i] + " at " + i);
				}
			} else {
				if (!Character.isLetter(name[i]) && !Character.isDigit(name[i]) && name[i] != '_') {
					throw new UnparsableExpressionException(varName + " is not a valid variable name: character '"
							+ name[i] + " at " + i);
				}
			}
		}
	}

	/**
	 * set the value for a variable
	 * 
	 * @param variableName
	 *            the variable name e.g. "x"
	 * @param value
	 *            the value e.g. 2.32d
	 * @return the {@link ExpressionBuilder} instance
	 */
	public ExpressionBuilder withVariable(String variableName, BigDecimal value) {
		variables.put(variableName, value);
		return this;
	}

	/**
	 * set the variables names used in the expression without setting their values
	 * 
	 * @param variableNames
	 *            vararg {@link String} of the variable names used in the expression
	 * @return the ExpressionBuilder instance
	 */
	public ExpressionBuilder withVariableNames(String... variableNames) {
		for (String variable : variableNames) {
			variables.put(variable, null);
		}
		return this;
	}

	/**
	 * set the values for variables
	 * 
	 * @param variableMap
	 *            a map of variable names to variable values
	 * @return the {@link ExpressionBuilder} instance
	 */
	public ExpressionBuilder withVariables(Map<String, BigDecimal> variableMap) {
		for (Entry<String, BigDecimal> v : variableMap.entrySet()) {
			variables.put(v.getKey(), v.getValue());
		}
		return this;
	}

	/**
	 * set a {@link CustomOperator} to be used in the expression
	 * 
	 * @param operation
	 *            the {@link CustomOperator} to be used
	 * @return the {@link ExpressionBuilder} instance
	 */
	public ExpressionBuilder withOperation(CustomOperator operation) {
		customOperators.put(operation.symbol, operation);
		return this;
	}

	/**
	 * set a {@link Collection} of {@link CustomOperator} to use in the expression
	 * 
	 * @param operations
	 *            the {@link Collection} of {@link CustomOperator} to use
	 * @return the {@link ExpressionBuilder} instance
	 */
	public ExpressionBuilder withOperations(Collection<CustomOperator> operations) {
		for (CustomOperator op : operations) {
			withOperation(op);
		}
		return this;
	}

	/**
	 * set the mathematical expression for parsing
	 * 
	 * @param expression
	 *            a mathematical expression
	 * @return the {@link ExpressionBuilder} instance
	 */
	public ExpressionBuilder withExpression(String expression) {
		this.expression = expression;
		return this;
	}
}
