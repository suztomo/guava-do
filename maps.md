# Maps

This page demonstrates how to create instance of `Map`.

## Create map from collection

```java
List<String> input = ImmutableList.of("USA", "Japan", "Mexico");

// { "USA" => 3, "Japan" => 5, "Mexico" => 6 }
Map<String, Integer> wordLength = QUESTION(input);
```

### Answer

```java
Maps.toMap(input, String::length);
```

## Create Multimap from collection by grouping

```java
List<String> input = ImmutableList.of("abc-foo", "ddd-bar", "abc-baz");

// { "abc" => ["abc-foo", "abc-baz"],
//   "ddd" => ["ddd"] }
ImmutableMultiMap<String, String> prefixMap = QUESTION(input);
```

### Answer

```java
Multimaps.index(input, element -> element.split("-")[0]);
```
