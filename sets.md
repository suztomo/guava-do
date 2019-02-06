
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