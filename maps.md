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


## Filter values of Multimap

```java
ImmutableListMultimap.Builder<String, Integer> builder = ImmutableListMultimap.builder();
builder.putAll("even", 2, 4, 6, 8, 10);
builder.putAll("odd", 1, 3, 5, 7, 9);
ImmutableListMultimap<String, Integer> multimap = builder.build();

// Filter only values less than 5
ImmutableListMultimap<String, Integer> filteredMultimap = QUESTION(multimap);
Truth.assertThat(filteredMultimap.values()).hasSize(4); // 1, 2, 3, 4
```

### Answer

```java
ImmutableListMultimap.copyOf(Multimaps.filterValues(multimap, value -> value < 5));
```