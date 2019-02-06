
## Merge sets

```java
ImmutableList<ImmutableSet<String>> input = ImmutableList.of(
    ImmutableSet.of("hello", "world"),
    ImmutableSet.of("good", "evening")
);

ImmutableSet<String> mergedSet = QUESTION(input);
```

### Answer

```java
ImmutableSet<String> mergedSet = input.stream().flatMap(Collection::stream)
    .collect(toImmutableSet());
```

## Do only if none of elements in a list matches

```java
int lengthLimit = 5;
ImmutableSet<String> input = ImmutableSet.of("a", "foo", "aiueo");

if (QUESTION(input, lengthLimit)) {
  System.out.println("None of the input string is longer than the length");
}

```

### Answer

```java
input.stream().noneMatch(element -> element.length() > lengthLimit)
```