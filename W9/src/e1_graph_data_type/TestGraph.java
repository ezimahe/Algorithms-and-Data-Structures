package e1_graph_data_type;
//author - Eleanor Ezimah
import external_package.StdOut;

public class TestGraph {
	  public static void main(String[] args) {
	    	System.out.println("Author - Eleanor Ezimah");
	        System.out.println();
	        System.out.println("TinyG.txt");
	    	int V = 13;
	        Graph graph = new Graph(V);
	        graph.addEdge(0, 5);
	        graph.addEdge(4, 3);
	        graph.addEdge(0, 1);
	        graph.addEdge(9, 12);
	        graph.addEdge(6, 4);
	        graph.addEdge(5, 4);
	        graph.addEdge(0, 2);
	        graph.addEdge(11, 12);
	        graph.addEdge(9, 10);
	        graph.addEdge(0, 6);
	        graph.addEdge(7, 8);
	        graph.addEdge(9, 11);
	        graph.addEdge(5, 3);
	        StdOut.println(graph);
	    }

}
