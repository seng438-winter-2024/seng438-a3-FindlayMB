package org.jfree.data.test.datautilities;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.security.InvalidParameterException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class GetCumulativePercentagesTests {
    private Mockery mockingContext;
    private KeyedValues values;

    private final double delta = 0.000000001d;

    @Before
    public void setUp() {
        // Setup
        mockingContext = new Mockery();
        values = mockingContext.mock(KeyedValues.class);
        mockingContext.checking(new Expectations() {
            {
                allowing(values).getItemCount(); will(returnValue(3));
                allowing(values).getKey(0); will(returnValue(0));
                allowing(values).getValue(0); will(returnValue(5d));
                allowing(values).getKey(1); will(returnValue(1));
                allowing(values).getValue(1); will(returnValue(9d));
                allowing(values).getKey(2); will(returnValue(2));
                allowing(values).getValue(2); will(returnValue(2d));
            }
        });
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();


    /**
     * Test getCumulativePercentages with empty keyed values
     * data = DefaultKeyedValues{}
     * size of resulting KeyedValues = 0
     */
    @Test
    public void validData_EmptyKeyedValues() {
        DefaultKeyedValues expected = new DefaultKeyedValues();
        assertEquals(expected,DataUtilities.getCumulativePercentages(new DefaultKeyedValues()));
    }


    /**
     * Test getCumulativePercentages with empty keyed values
     * data = DefaultKeyedValues{}
     * size of resulting KeyedValues = 0
     */
    @Test
    public void validData_SingleKeyedValue() {
        mockingContext.checking(new Expectations() {
            {
                allowing(values).getItemCount(); will(returnValue(1));
                one(values).getValue(0); will(returnValue(1d));
                one(values).getKey(0); will(returnValue(0));
            }
        });

        DefaultKeyedValues expected = new DefaultKeyedValues();
        expected.addValue((Comparable<?>)0, 1.0);

        KeyedValues results = DataUtilities.getCumulativePercentages(values);

        assertEquals(expected, results);
    }

    /**
     * Test getCumulativePercentages with empty keyed values
     * data = DefaultKeyedValues{}
     * size of resulting KeyedValues = 0
     */
    @Test
    public void validKeyedValues_AllPositive() {
        DefaultKeyedValues expected = new DefaultKeyedValues();
        expected.addValue((Comparable<?>)0, 0.3125);
        expected.addValue((Comparable<?>)1, 0.875);
        expected.addValue((Comparable<?>)2, 1.0);

        KeyedValues results = DataUtilities.getCumulativePercentages(values);
        assertEquals(expected, results);
    }

    /**
     * Test getCumulativePercentages with empty keyed values
     * data = DefaultKeyedValues{}
     * size of resulting KeyedValues = 0
     */
    @Test
    public void validKeyedValues_WithNegatives() {
        DefaultKeyedValues expected = new DefaultKeyedValues();
        expected.addValue((Comparable<?>)0, 0.3125);
        expected.addValue((Comparable<?>)1, 0.875);
        expected.addValue((Comparable<?>)2, 0.75);

        KeyedValues results = DataUtilities.getCumulativePercentages(values);

        assertEquals(expected, results);
    }


    /**
     * Test getCumulativePercentages with keyed values with the keys being strings
     * data = DefaultKeyedValues{}
     * size of resulting KeyedValues = 0
     */
    @Test
    public void validKeyedValues_StringKeys() {
        mockingContext.checking(new Expectations() {
            {
                allowing(values).getItemCount(); will(returnValue(3));
                allowing(values).getKey(0); will(returnValue("A"));
                allowing(values).getValue("A"); will(returnValue(5d));
                allowing(values).getValue(0); will(returnValue(5d));
                allowing(values).getKey(1); will(returnValue("B"));
                allowing(values).getValue("B"); will(returnValue(9d));
                allowing(values).getValue(1); will(returnValue(9d));
                allowing(values).getKey(2); will(returnValue("C"));
                allowing(values).getValue("C"); will(returnValue(2d));
                allowing(values).getValue(2); will(returnValue(2d));
            }
        });
        DefaultKeyedValues expected = new DefaultKeyedValues();
        expected.addValue("A", 0.3125);
        expected.addValue("B", 0.875);
        expected.addValue("C", 1.0);

        KeyedValues results = DataUtilities.getCumulativePercentages(values);

        assertEquals(expected, results);
    }


    /**
     * Test getCumulativePercentages with a null value for data
     * this should throw an InvalidParameterException
     */
    @Test
    public void nullData_ThrowInvalidParameterException() {
        exceptionRule.expect(InvalidParameterException.class);
        KeyedValues result = DataUtilities.getCumulativePercentages(null);
    }

    /**
     * Test getCumulativePercentages with a null value inside of data
     * this should throw an InvalidParameterException
     */
    @Test
    public void partialNullData_ThrowInvalidParameterException() {
        exceptionRule.expect(InvalidParameterException.class);
        KeyedValues result = DataUtilities.getCumulativePercentages(null);
    }
}
