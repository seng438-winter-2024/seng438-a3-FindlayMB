package org.jfree.data.test.range;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.jfree.data.Range;

public class AllGetterTests {
    private Range range1;
    private Range range3;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        range1 = new Range(2, 9);
        range3 = new Range(-2, 2);
;
    }

    @Test
    public void getLengthShouldReturnLength() {
        assertEquals("Expected 7",
                7, range1.getLength(),.000000001d);
    }

    /*
    *   This does not cover the illegalException thrown in the getLength function
    *   because the object of Range lower > upper will not be created
    */
    @Test
    public void getLengthShouldThrowException() {
        try {
            Range range2 = new Range(5, 3);
            range2.getLength();
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            String expectedMessage = "Range(double, double): require lower (" + 5.0 + ") <= upper (" + 3.0 + ").";
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    public void getCentralValueShouldReturn3_5() {
        assertEquals("Expected 3.5",
                3.5, range1.getCentralValue(),.000000001d);
    }

}
