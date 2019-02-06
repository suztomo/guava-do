# Graphs

Guava's Graph library provides basic functionality to traverse graph data structure.

## List reachable nodes from a set of classes through edges in a graph

```java

Graph<String> graph = ...;
Set<String> entryPoints = ...;

Set<String> reachableNodes = QUESTION(graph, entryPoints);
```


### Answer

```java
ImmutableSet.copyOf(Traverser.forGraph(graph).breadthFirst(fromNodes));
```
