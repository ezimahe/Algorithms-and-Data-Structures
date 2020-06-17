package e4_isconnectedTrace;
//author - Eleanor Ezimah
import e3_isconnectedDFS.CCInterface;
import external_package.GraphInterface;

public class IsConnectedTrace implements CCInterface {
	private boolean[] visited;
	    private int[] id;
	    private int count;

	    public IsConnectedTrace(GraphInterface graph) {
	        visited = new boolean[graph.vertices()];
	        id = new int[graph.vertices()];

	        for(int source = 0; source < graph.vertices(); source++) {
	            if (!visited[source]) {
	                dfs(graph, source);
	                count++;
	            }
	        }
	    }

	    private void dfs(GraphInterface graph, int vertex) {
	        visited[vertex] = true;
	        id[vertex] = count;

	        for(int neighbor : graph.adjacent(vertex)) {
	            if (!visited[neighbor]) {
	                dfs(graph, neighbor);
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

