/*
MyCustomGraph.java
Mohammad Garada
Graph Methods implementation
Mohammad Garada
 */

package cmsc256;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

//constructors
public class MyCustomGraph<V> extends UnweightedGraph<V> {
    public MyCustomGraph() {
        super();
    }

    public MyCustomGraph(int[][] edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }

    public MyCustomGraph(List<Edge> edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }

    public MyCustomGraph(List<V> vertices, List<Edge> edges) {
        super(vertices, edges);
    }

    public MyCustomGraph(V[] vertices, int[][] edges) {
        super(vertices, edges);
    }

    //accept a file name including the file extension as a String parameter to create and return a MyCustomGraph object
    public MyCustomGraph<V> readFile(String fileName) throws FileNotFoundException {
        List<Edge> edge = new ArrayList<Edge>();
       //create variable x
        int x = 0;
       //start of try catch block
        try {
           //create file object
            File file = new File(fileName);
            //scan in file object
            Scanner scan = new Scanner(new File(fileName));
            //create a string array called "values"
            String[] values = new String[0];
          //first line in the file is the number of vertices, which will be stored into x
            x = Integer.parseInt(scan.nextLine());
            //start of while loop
            while (scan.hasNextInt()) {
                values = scan.nextLine().split(" ");
                //start of second try catch block
                try {
                    //going through the array
                    for (int i = 1; i < values.length; i++) {
                       //add the edges
                        edge.add(new Edge(Integer.parseInt(values[0]), Integer.parseInt(values[i])));
                    }
                    //catch for NumberFormatExceptions
                } catch (NumberFormatException e) {
                    throw new NumberFormatException();
                }
            }
            //catch for FileNotFoundExceptions
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        //return statement
        return new MyCustomGraph<V>(edge, x);
    }


    //returns true if this graph is complete
    public boolean isComplete() {
        //if statement to check if the formula fits
        if (neighbors.size() == vertices.size() * (vertices.size() - 1)) {
            //if it does, return true
            return true;
        } else {
            //else return false
            return false;
        }
    }


    //returns true if v1 is adjacent to v2
    public boolean areAdjacent(int v1, int v2) {
        //if statement that uses getNeighbors to check for the neighbors in v1 and if v2 is contained within them
        if (getNeighbors(v1).contains(v2)) {
           //return true is the case is true
            return true;
        } else {
            //return false if not
            return false;
        }
    }

    //returns true if this graph is connected and false otherwise.
    public boolean isConnected() {
        //checks if there is less than 2 vertices in the graph
        if (vertices.size() < 2) {
           //if condition is right, th graph is not connected, thus return false
            return false;
        }
        //conducts a dfs to search for the number of vertices in the search tree.
        boolean result = (dfs(0).getNumberOfVerticesFound() == vertices.size());
        return result;
    }


    public List<Integer> getShortestPath(int begin, int end) {
        List<Integer> shortP = (List<Integer>) bfs(end).getPath(begin);
       //checxks if the second parameter, end, is != to the final value in the list.
        if (end != shortP.get(shortP.size() - 1)) {
           //if so, return null
            return null;
        }
        //if not, return the list
        return shortP;
    }

    //determines whether there is a cycle in the graph
   public boolean hasCycle() {
    // Iterate over each vertex in the graph
    for (V vertex : vertices) {
        // Create a list to keep track of visited vertices
        List<V> visited = new ArrayList<>();
        // Use dfs() to check for cycles starting at this vertex
        if (dfs(vertex, visited, null)) {
            // If a cycle is found, return true
            return true;
        }
    }
    // If no cycles are found, return false
    return false;
}

// Recursive dfs helper function to check for cycles
private boolean dfs(V vertex, List<V> visited, V parent) {
    // Add the current vertex to the visited list
    visited.add(vertex);
    // Iterate over each neighbor of the current vertex
    for (V neighbor : getNeighbors(vertex)) {
        // If the neighbor has not been visited yet, recursively call dfs()
        if (!visited.contains(neighbor)) {
            if (dfs(neighbor, visited, vertex)) {
                // If a cycle is found, return true
                return true;
            }
        // If the neighbor has been visited and it is not the parent of the current vertex, a cycle is found
        } else if (!neighbor.equals(parent)) {
            return true;
        }
    }
    // If no cycles are found, return false
    return false;
    }
}

