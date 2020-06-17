package e5_copy_constructor;
//author -Eleanor Ezimah

import java.util.Stack;

import external_package.Bag;
import external_package.Graph;
import external_package.In;
import external_package.StdOut;
public class CopyConstructor {
	public class GraphCopy { 
    private final int vertices;
    private int edges;
    private Bag<Integer>[] adjacent;

    @SuppressWarnings("unchecked")
	public GraphCopy(int vertices) {
        this.vertices = vertices;
        this.edges = 0;
        adjacent = (Bag<Integer>[]) new Bag[vertices];

        for(int i = 0; i < vertices; i++) {
            adjacent[i] = new Bag<>();
        }
    }

    public GraphCopy(In in) {
        this(in.readInt());
        int edges = in.readInt();

        for(int i = 0; i < edges; i++) {
            int vertex1 = in.readInt();
            int vertex2 = in.readInt();
            addEdge(vertex1, vertex2);
        }
    }

    @SuppressWarnings("unchecked")
	public GraphCopy(Graph graph) {
        if (graph == null) {
            vertices = 0;
        } else {
            this.vertices = graph.vertices();
            this.edges = graph.edges();
            adjacent = (Bag<Integer>[]) new Bag[vertices];

            for(int i = 0; i < vertices; i++) {
                adjacent[i] = new Bag<>();
            }

            for(int vertex = 0; vertex < graph.vertices(); vertex++) {
                // Reverse so that adjacency list is in the same order as original
                Stack<Integer> stack = new Stack<>();
                for (int neighbor : graph.getAdjacencyList()[vertex]) {
                    stack.push(neighbor);
                }
                for (int neighbor : stack) {
                    adjacent[vertex].add(neighbor);
                }
            }
        }
    }

    public int vertices() {
        return vertices;
    }

    public int edges() {
        return edges;
    }

    public void addEdge(int vertex1, int vertex2) {
        adjacent[vertex1].add(vertex2);
        adjacent[vertex2].add(vertex1);
        edges++;
    }

    public Iterable<Integer> adjacent(int vertex) {
        return adjacent[vertex];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(int vertex = 0; vertex < vertices(); vertex++) {
            stringBuilder.append(vertex).append("| ");

            for(int neighbor : adjacent(vertex)) {
                stringBuilder.append(neighbor).append(" ");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }}

public static void main(String[] args) {
    CopyConstructor copyconstructor = new CopyConstructor();
    System.out.println("Author - Eleanor Ezimah");
    System.out.println();
    Graph graph = new Graph(5);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(0, 3);
    graph.addEdge(1, 2);
    graph.addEdge(1, 4);
    graph.addEdge(2, 3);

    GraphCopy graphCopy = copyconstructor.new GraphCopy(graph);
    System.out.println("New copy of graph after original graph is created");
    StdOut.println(graphCopy);

    graph.addEdge(0, 4);
    System.out.println("Copy of graph after original graph is modified(Stays the same)");
    StdOut.println(graphCopy);
    
    System.out.println("Original graph after modification");
    StdOut.println(graph);
    StdOut.println("Edges in original graph: " + graph.edges());
    StdOut.println("Edges in copy graph: " + graphCopy.edges());
}

}
