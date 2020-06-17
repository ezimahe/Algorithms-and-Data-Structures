package e7_proof_of_connectivity;
//author -Eleanor Ezimah
import external_package.Graph;
import external_package.StdOut;

public class ProofOfConnectivity {
	public class ConnectedDFS {
        private boolean[] visited;
        private int count;
        private int vertexThatCanBeRemoved;

        private Graph graph;
        private int sourceVertex;

        public ConnectedDFS(Graph graph, int sourceVertex) {
            visited = new boolean[graph.vertices()];

            this.graph = graph;
            this.sourceVertex = sourceVertex;
        }

        public int findVertexThatCanBeRemoved() {
            dfs(graph, sourceVertex);
            return vertexThatCanBeRemoved;
        }

        private void dfs(Graph graph, int vertex) {
            visited[vertex] = true;
            count++;

            boolean areAllNeighborsMarked = true;

            for(int neighbor : graph.adjacent(vertex)) {
                if (!visited[neighbor]) {
                    areAllNeighborsMarked = false;
                    dfs(graph, neighbor);
                }
            }

            if (areAllNeighborsMarked) {
                vertexThatCanBeRemoved = vertex;
            }
        }

        public boolean marked(int vertex) {
            return visited[vertex];
        }

        public int count() {
            return count;
        }
	}

    public static void main(String[] args) {
    	ProofOfConnectivity proofofconnectivity = new ProofOfConnectivity();

    	System.out.println("Author - Eleanor Ezimah");
        System.out.println();
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        
        System.out.println("Graph Output");
        StdOut.println(graph);
        ConnectedDFS depthFirstSearchConnected = proofofconnectivity.new ConnectedDFS(graph, 0);
        StdOut.println("The vertex that can be removed: " + depthFirstSearchConnected.findVertexThatCanBeRemoved());
    }

}
