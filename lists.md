

# Sort lists by multiple attributes of its elements

```java
Comparator<String> comparator = QUESTIUON();

List<String> list = Arrays.asList("abc", "d", "a", "ab");

// Sort by length first, and then content
Collections.sort(list, comparator);
```

## Answer

```java
Comparator.comparing(String::length).thenComparing(Function.identity());
```
