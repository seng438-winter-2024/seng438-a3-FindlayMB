package org.jfree.data.test;

import org.jfree.data.Range;
import org.jfree.data.test.range.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.SuiteMethod;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.security.InvalidParameterException;

/**
 * Run all tests that are related to Range
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        IntersectsTests.class,
        CombineTests.class,
        ContainsTests.class,
        ConstrainTests.class,
        ExpandTests.class,
        ExpandToIncludeTests.class,
        AllGetterTests.class,
        HashCodeTests.class,
        ScaleTests.class,
        })
public class RangeTest {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void rangeConstructorInvalidParameters() {
        exceptionRule.expect(IllegalArgumentException.class);
        Range result = new Range(5, 0);
    }
}
