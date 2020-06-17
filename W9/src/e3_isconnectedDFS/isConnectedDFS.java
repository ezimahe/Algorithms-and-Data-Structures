package e3_isconnectedDFS;
//author - Eleanor Ezimah
import java.util.Iterator;
import java.util.Stack;

import external_package.Graph;

public class isConnectedDFS implements CCInterface {

	    private boolean[] visited;
	    private int[] id;
	    private int count;

	    public isConnectedDFS(Graph graph) {
	        visited = new boolean[graph.vertices()];
	        id = new int[graph.vertices()];

	        for(int source = 0; source < graph.vertices(); source++) {
	            if (!visited[source]) {
	                depthFirstSearchIterative(graph, source);
	                count++;
	            }
	        }
	    }

	    private void depthFirstSearchIterative(Graph graph, int sourceVertex) {
	        Stack<Integer> stack = new Stack<>();
	        stack.push(sourceVertex);
	        visited[sourceVertex] = true;
	        id[sourceVertex] = count;

	      
	        @SuppressWarnings("unchecked")
			Iterator<Integer>[] adjacentIterators = (Iterator<Integer>[]) new Iterator[graph.vertices()];

	        for (int vertexId = 0; vertexId < adjacentIterators.length; vertexId++) {
	            if (graph.getAdjacencyList()[vertexId] != null) {
	                adjacentIterators[vertexId] = graph.getAdjacencyList()[vertexId].iterator();
	            }
	        }

	        while (!stack.isEmpty()) {
	            int currentVertex = stack.peek();

	            if (adjacentIterators[currentVertex].hasNext()) {
	                int neighbor = adjacentIterators[currentVertex].next();

	                if (!visited[neighbor]) {
	                    stack.push(neighbor);
	                    visited[neighbor] = true;
	                    id[neighbor] = count;
	                }
	            } else {
	                stack.pop();
	            }
	        }
	    }

	    public boolean connected(int vertex1, int vertex2) {
	        return id[vertex1] == id[vertex2];
	    }

	    public int id(int vertex) {
	        return id[vertex];
	    }

	    public int count() {
	        return count;
	    }

	}

