package org.jfree.data.test;

import org.jfree.data.test.range.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        IntersectsTests.class,
        CombineTests.class,
        ContainsTests.class,
        ConstrainTests.class,
        ExpandToIncludeTests.class,
        AllGetterTests.class,
        HashCodeTests.class,
        MinMaxTests.class,
        ScaleTests.class})
public class RangeTest {

}
