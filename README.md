# MyCustomGraph.java
## Description 
'MyCustomGraph' is a Java class that implements a graph data structure. This class extends the 'UnweightedGraph' class and includes methods for reading in a graph from a file, checking if the graph is complete, checking if two vertices are adjacent, checking if the graph is connected, finding the shortest path between two vertices, and checking if the graph has a cycle.
## Constructors 
The class includes five constructors that allow for the creation of a graph object. These are:

- 'MyCustomGraph()': Creates an empty graph.
- 'MyCustomGraph(int[][] edges, int numberOfVertices)': Creates a graph with the specified edges and number of vertices.
- 'MyCustomGraph(List<Edge> edges, int numberOfVertices)': Creates a graph with the specified edges and number of vertices.
- 'MyCustomGraph(List<V> vertices, List<Edge> edges)': Creates a graph with the specified vertices and edges.
- 'MyCustomGraph(V[] vertices, int[][] edges)': Creates a graph with the specified vertices and edges.

  ## Requirements 
  
  
  ## Usage 
  
  To use the 'MyCustomGraph' class, first create an instance of the class with one of the provided constructors or by calling the 'readFile' method to read in a graph from a file. Once you have a 'MyCustomGraph' object, you can use the following methods to perform operations on the graph:

- isComplete(): Returns true if the graph is complete (i.e., every vertex is connected to every other vertex), and false otherwise.
- areAdjacent(int v1, int v2): Returns true if vertex v1 is adjacent to vertex v2, and false otherwise.
- isConnected(): Returns true if the graph is connected (i.e., there is a path between every pair of vertices), and false otherwise.
- getShortestPath(int begin, int end): Returns a list of integers representing the shortest path between vertices begin and end, or null if there is no path between them.
- hasCycle(): Returns true if the graph contains a cycle (i.e., there is a path from a vertex back to itself), and false otherwise.
