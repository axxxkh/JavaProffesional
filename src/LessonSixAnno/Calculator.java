package LessonSixAnno;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Oleksii Khomyshen
 * 18/12/2021
 * ver. 0.1
 */

public class Calculator {

    /**
     * first number to use in calculations
     */
    public int firstNumber;

    /**
     * second number to use in calculations
     */
    public int secondNumber;

    /**
     * to multiply two numbers
     *
     * @return result of the operation
     */
    public int mul(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    /**
     * to divide two numbers
     *
     * @return result
     */
    @CalculationAnnotation(firstNumber = 1, secondNumber = 0)
    public int div(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }

    /**
     * to calculate sum of the two numbers
     *
     * @return sum
     */
    @CalculationAnnotation(
            firstNumber = 3,
            secondNumber = 4)
    public int sum(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    /**
     * to calculate first number - second number
     *
     * @return result
     */
    @CalculationAnnotation(
            firstNumber = 5,
            secondNumber = 6)
    public int minus(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    /**
     * @param firstNumber  first number to calculate
     * @param secondNumber second number to calculate
     */
    @CalculationAnnotation(
            firstNumber = 10,
            secondNumber = 20)
    public Calculator(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    /**
     * default constructor
     */
    public Calculator() {
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            for (Method method : calculator.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(CalculationAnnotation.class)) {
                    CalculationAnnotation annotation = method.getAnnotation(CalculationAnnotation.class);
                    System.out.println(annotation);
                    method.invoke(calculator, annotation.firstNumber(), annotation.secondNumber());
                }
            }
        } catch (IllegalAccessException e) {
            System.out.println(e);
        } catch (InvocationTargetException e) {
            System.out.println(e);
        }
    }
}
