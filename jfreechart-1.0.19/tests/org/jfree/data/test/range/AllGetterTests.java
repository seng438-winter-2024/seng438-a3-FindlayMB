package org.jfree.data.test.range;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.jfree.data.Range;

public class AllGetterTests {
    private Range range1;
    private Range range2;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        range1 = new Range(2, 9);
        range2 = new Range(-2, 3.5);

    }

    /**
     * This test tests getLength function with inputs of a range
     * from [2, 9]
     * Expected outcome: returns a length of 7.
     */
    @Test
    public void getLengthBasic() {
        assertEquals("Expected 7",
                7, range1.getLength(),.000000001d);
    }

    /**
     * This test tests getLength function with inputs of a range
     * from [-2, 3.5]
     * Expected outcome: returns a length of 5.5.
     */
    @Test
    public void getLengthNegativeAndPositive() {
        assertEquals("Expected 5.5",
                5.5, range2.getLength(),.000000001d);
    }

    /**
     * This test tests getLength function with inputs of a range
     * from [5.0, 2.0]
     * Expected outcome: throws IllegalArgumentException.
     *
     * This does not cover the illegalException thrown in the getLength function
     * because the object of Range lower > upper will not be created
     */
    @Test(expected = IllegalArgumentException.class)
    public void getLengthShouldThrowException() {
        Range range = new Range(5.0, 2.0);
        range.getLength();
    }

    /**
     * This test tests getCentralValue function with inputs of a range
     * from [2, 9]
     * Expected outcome: returns a value of 5.5.
     */
    @Test
    public void getCentralValueShouldReturn3_5() {
        assertEquals("Expected 3.5",
                3.5, range1.getCentralValue(),.000000001d);
    }

}
