Notes taken by Findlay while increasing coverage

# Inital coverage

| SUT           | Class % | Method % | Line % | Branch % |
| ------------- | ------- | -------- | ------ | -------- |
| DataUtilities | 100%    | 55%      | 46%    | 31%      |
| Range         | 100%    | 43%      | 39%    | 39%      |

# Improve coverage

Increasing method coverage will increase both branch and line coverage.

## Implement tests

Following methods need to have tests written about them to increase method coverage:

### DataUtilities

- `boolean equal(double[][] a, double[][] b)`
- `double[][] clone(double[][] source)`
- `double calculateColumnTotal(Values2D data, int column, int[] validRows)`
- `calculateRowTotal(Values2D data, int row, int[] validCols)`

### Range

- `double getLength()`
- `double getCentralValue()`
- `boolean intersects(Range range)`
- `Range combineIgnoringNaN(Range range1, Range range2)`
- `double min(double d1, double d2)`
- `double max(double d1, double d2)`
- `Range expand(Range range, double lowerMargin, double upperMargin)`
- `Range shift(Range base, double delta)`
- `Range shift(Range base, double delta, boolean allowZeroCrossing)`
- `double shiftWithNoZeroCrossing(double value, double delta)`
- `Range scale(Range base, double factor)`
- `boolean isNaNRange()`
- `int hashCode()`

## Increase amount of tests

Following methods need to have more tests written to increase line and branch coverage:

### DataUtilities

- `double calculateColumnTotal(Values2D data, int column)` : line and branch
- `double calculateRowTotal(Values2D data, int row)` : line and branch
- `KeyedValues getCumulativePercentages(KeyedValues data)` : line and branch

### Range

- `Range(double lower, double upper)` : line and branch
- `double getLowerBound()` : line and branch
- `double getUpperBound()` : line and branch
- `boolean contains(double value)` : branch
- `boolean intersects(double b0, double b1)` : branch
- `double constrain(double value)` : branch
- `Range combine(Range range1, Range range2)` : line and branch
- `boolean equals(Object obj)` : line and branch

# Plan

Create test files that have the tests for the methods that don't have a test file already.
Some methods that are overloads of already tested methods can have their tests placed in the same file. Just be sure to indicate that the test is for the overload method or the normal one.

Increase the tests for the methods that already have tests. We have to do this since some of the methods have had code added to them.
