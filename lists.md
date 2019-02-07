

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


# Assert an attribute of an element via Truth

```java
List<String> list = Arrays.asList("abc", "d", "a", "ab");

// Assert that the list contains an element with length 3
assertThat(list).comparingElementsUsing(QUESTION).contains(3);
```

## Answer

```java
private static final Correspondence<String, Integer> STRING_LENGTH =
    new Correspondence<String, Integer>() {
      public boolean compare(String actual, Integer expected) {
        return expected.equals(actual.length());
      }

      public String toString() {
        return "has length equal to";
      }
    };
```