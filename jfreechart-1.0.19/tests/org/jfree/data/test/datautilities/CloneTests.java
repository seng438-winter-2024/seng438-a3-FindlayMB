package org.jfree.data.test.datautilities;

import org.jfree.data.DataUtilities;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

public class CloneTests {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();


    @Test
    public void validSource_2D_doubleArray_returnValidClone(){
        double[][] expected = new double[][]{{1,2},{3,4}};
        assertArrayEquals(expected, DataUtilities.clone(expected));
    }


    @Test
    public void validSource_containsNull_returnClone() {
        double[][] expected = new double[][]{null,{1,2}};
        assertArrayEquals(expected, DataUtilities.clone(expected));
    }

    @Test
    public void emptySource_returnEmptyArray(){
        double[][] expected = new double[][]{};
        assertArrayEquals(expected, DataUtilities.clone(expected));
    }

    @Test
    public void partialEmptySource_returnClone() {
        double[][] expected = new double[][]{{},{1,2}};
        assertArrayEquals(expected, DataUtilities.clone(expected));
    }

    /**
     * Testing double[][] clone(double[][] source)
     * Where source = null
     * Expected to throw IllegalArgumentException
     */
    @Test
    public void nullSource_throwIllegalArgumentException(){
        exceptionRule.expect(IllegalArgumentException.class);
        double[][] clone = DataUtilities.clone(null);
    }
}
