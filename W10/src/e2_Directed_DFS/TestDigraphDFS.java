package e2_Directed_DFS;
import e1_Digraph.Digraph;
//author - Eleanor Ezimah
import external_package.StdOut;

public class TestDigraphDFS {
	  public static void main(String[] args) {
	    	System.out.println("Author - Eleanor Ezimah");
	        System.out.println();
	        System.out.println("TinyG.txt");
	    	int V = 13;
	        Digraph digraph = new Digraph(V);
	        digraph.addEdge(0, 5);
	        digraph.addEdge(4, 3);
	        digraph.addEdge(0, 1);
	        digraph.addEdge(9, 12);
	        digraph.addEdge(6, 4);
	        digraph.addEdge(5, 4);
	        digraph.addEdge(0, 2);
	        digraph.addEdge(11, 12);
	        digraph.addEdge(9, 10);
	        digraph.addEdge(0, 6);
	        digraph.addEdge(7, 8);
	        digraph.addEdge(9, 11);
	        digraph.addEdge(5, 3);
	        StdOut.println(digraph);
	    }

}
