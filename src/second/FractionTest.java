package second;

/*
 * TODO
 *
 * Subclass of Number
 * Fraction is immutable
 * Fraction has BigInteger Zähler und Nenner
 * implements interface Comparable
 *
 * Methods:
 * getNumerator
 * getDenominator
 * Fraction(bigInteger)
 * Fraction(String)
 * Fraction(long)
 * parseFraction
 * Fraction add (Fraction r)
 * Fraction subtract (Fraction r)
 * Fraction multiply (Fraction r)
 * Fraction divide (Fraction r)
 * reduceFraction
 * boolean isInteger()
 * public String toString()
 * compareTo
 * int intValue
 * long longValue
 * float floatValue
 * double doubleValue
 * equals
 */


import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class FractionTest {


    @Test
    void testIntValue() {
        Fraction roundToZero = new Fraction(9, 10);
        assertEquals(0, roundToZero.intValue());
        Fraction negativeNumerator = new Fraction(-10, 5);
        assertEquals(-2, negativeNumerator.intValue());
        Fraction negativeDenominator = new Fraction(10, -5);
        assertEquals(-2, negativeDenominator.intValue());

        assertThrows(ArithmeticException.class, () -> {
            Fraction zeroDenominator = new Fraction(10, 0);
        });



    }

    @Test
    void testLongValue() {
        Fraction roundToZero = new Fraction(9, 10);
        assertEquals(0, roundToZero.longValue());
        Fraction negativeNumerator = new Fraction(-10, 5);
        assertEquals(-2, negativeNumerator.longValue());
        Fraction negativeDenominator = new Fraction(10, -5);
        assertEquals(-2, negativeDenominator.longValue());
    }

    @Test
    void testFloatValue() {
        Fraction almostEqual = new Fraction(2, 5);
        assertTrue(Math.abs(almostEqual.floatValue() - 0.4f) < 0.0001f);
        Fraction negativeNumerator = new Fraction(-10, 5);
        assertEquals(-2.0f, negativeNumerator.floatValue(), 0.0001);
        Fraction negativeDenominator = new Fraction(10, -5);
        assertEquals(-2.0f, negativeDenominator.floatValue(), 0.0001);
    }

    @Test
    void testDoubleValue() {
        Fraction almostEqual = new Fraction(2, 5);
        assertTrue(Math.abs(almostEqual.doubleValue() - 0.4f) < 0.0001f);
        Fraction negativeNumerator = new Fraction(-10, 5);
        assertEquals(-2.0f, negativeNumerator.doubleValue(), 0.0001);
        Fraction negativeDenominator = new Fraction(10, -5);
        assertEquals(-2.0f, negativeDenominator.doubleValue(), 0.0001);
    }
}
