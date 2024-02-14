Notes taken by Findlay while increasing coverage

Inital coverage

# DataUtilitiesTests

| Test suite                    | Class % | Method % | Line % | Branch % |
| ----------------------------- | ------- | -------- | ------ | -------- |
| CalculateColumnTotalTests     | 100%    | 100%     | 92%    | 50%      |
| CalculateRowTotalTests        | 100%    | 100%     | 92%    | 50%      |
| CreateNumberArrayTests        | 100%    | 100%     | 96%    | 100%     |
| CreateNumberArray2DTests      | 100%    | 100%     | 96%    | 100%     |
| GetCumulativePercentagesTests | 100%    | 100%     | 93%    | 100%     |

# RangeTests

| Test suite           | Class % | Method % | Line % | Branch % |
| -------------------- | ------- | -------- | ------ | -------- |
| IntersectsTests      | 100%    | 100%     | 100%   | 100%     |
| ExpandToIncludeTests | 100%    | 100%     | 100%   | 100%     |
| ContainsTests        | 100%    | 100%     | 100%   | 100%     |
| ConstrainTests       | 100%    | 100%     | 100%   | 100%     |
| CombineTests         | 100%    | 100%     | 100%   | 100%     |

# Improve coverage

Remove any print statements.

Remove result variable and call the function inside of the assert.

```java
double result = DataUtilities.calculateColumnTotal(values, 2);
assertEquals(5.0, result, delta);
```

Will become

```java
assertEquals(5.0, DataUtilities.calculateColumnTotal(values, 2), delta);
```

## GetCumulativePercentagesTests

Instead of creating an expected object and iterating through each key-value pair to check if the result matchs the expected.
Create a matching object and check if it is matching the resulting object from the method called.
To compare the two objects use the DefaultKeyedValues function `boolean equals(Object obj)`

```javagit s
HashMap<Comparable<?>, Double> expected = new HashMap<>();
expected.put(0, 0.3125);
expected.put(1, 0.875);
expected.put(2, 1.0);

for (Comparable<?> key : expected.keySet()) {
    assertEquals(expected.get(key), results.getValue(key).doubleValue(), delta);
}
```

Will become

```java
DefaultKeyedValues expected = new DefaultKeyedValues();
expected.addValue((Comparable<?>)0, 0.3125);
expected.addValue((Comparable<?>)1, 0.875);
expected.addValue((Comparable<?>)2, 1.0);

assertEquals(expected, results);
```

Also removed helper function that displays the key-value pairs.
