package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorTest {
    private Calculator calculator = new Calculator();
    private final double DELTA = 0.001;

    @BeforeEach
    public void clearCalculator() {
        calculator.reset();
    }

    @Test
    public void testAdd() {
        calculator.add(1);
        calculator.add(2);
        assertEquals(3, calculator.getResult(), DELTA, "The sum of numbers 1 and 2 is incorrect");  // Fixed: was 4, should be 3
    }

    @Test
    public void testSubtract() {
        calculator.add(10);
        calculator.subtract(2);
        assertEquals(8, calculator.getResult(), DELTA, "The difference between 10 and 2 is incorrect");
    }

    @Test
    @DisplayName("Test division 8 / 2")
    public void testDivide() {
        calculator.add(8);
        calculator.divide(2);
        assertEquals(4, calculator.getResult(), DELTA, "Division 8/2 is incorrect");  // Fixed: was 5, should be 4
    }

    @Test
    @DisplayName("Test division by zero")
    public void testDivideByZero() {
        ArithmeticException exception =
                assertThrows(ArithmeticException.class, () -> calculator.divide(0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    @DisplayName("Test multiply 5 * 3")
    public void testMultiply() {
        calculator.add(5);
        calculator.multiply(3);
        assertEquals(15, calculator.getResult(), DELTA, "Multiplication 5 * 3 is incorrect");
    }

    @Test
    @DisplayName("Test multiply by zero")
    public void testMultiplyByZero() {
        calculator.add(10);
        calculator.multiply(0);
        assertEquals(0, calculator.getResult(), DELTA, "Multiplication by 0 should be 0");
    }

    @Test
    @DisplayName("Test square root of 4")
    public void testSquareRoot() {
        calculator.squareRoot(4);
        assertEquals(2, calculator.getResult(), DELTA, "Square root of 4 is incorrect");
    }

    @Test
    @DisplayName("Test square root of 9")
    public void testSquareRoot9() {
        calculator.squareRoot(9);
        assertEquals(3, calculator.getResult(), DELTA, "Square root of 9 is incorrect");
    }

    @Test
    @DisplayName("Test square root of negative number")
    public void testSquareRootNegative() {
        assertThrows(IllegalArgumentException.class, () -> calculator.squareRoot(-4));
    }
}
