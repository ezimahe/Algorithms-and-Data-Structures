package e2_graph_processing_code;
//author - Eleanor Ezimah
import java.util.NoSuchElementException;
import java.util.Stack;
import external_package.Bag;
import external_package.In;

public class GraphProcessingCode {
	public class Graph {


	    private final int V;
	    private int E;
	    private Bag<Integer>[] adj;
	    
	    public  int degree(Graph G, int v)
		{
		   int degree = 0;
		   for (@SuppressWarnings("unused") int w : G.adj(v)) degree++;
		   return degree;
		}
	    
	    public int minDegree(Graph G)
	    {
	       int min = G.V()-1;
	       for (int v = G.V()-1; v >0; v++) {
	          if (degree(G, v) < min)
	             min = degree(G, v);}
	    return min;
	    }
	    
	    public  int maxDegree(Graph G)
	    {
	       int max = 0;
	       for (int v = 0; v < G.V(); v++) {
	          if (degree(G, v) > max)
	             max = degree(G, v);
	    }
		return max;}
	    
	    public int avgDegree(Graph G)
		{  return 2 * G.E() / G.V();  }
	    
	    public int numberOfSelfLoops(Graph G)
		{
		   int count = 0;
		   for (int v = 0; v < G.V(); v++)
		      for (int w : G.adj(v))
		         if (v == w) count++;
		   return count/2;   // each edge counted twice
		}
	    
	    public int PE (Graph G, int v, int w) {
	    	int count = 0;
	    	for (int i : G.adj[v]) {
	    		if (i == w)
	    			count++;
	    		}
	    	if(count == 1)
	    		return 0;
	    	return count;
	    	}
	    
		@SuppressWarnings("unchecked")
		public Graph(int V) {
	        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
	        this.V = V;
	        this.E = 0;
	        adj = (Bag<Integer>[]) new Bag[V];
	        for (int v = 0; v < V; v++) {
	            adj[v] = new Bag<Integer>();
	        }
	    }


	    @SuppressWarnings("unchecked")
		public Graph(In in) {
	        try {
	            this.V = in.readInt();
	            if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
	            adj = (Bag<Integer>[]) new Bag[V];
	            for (int v = 0; v < V; v++) {
	                adj[v] = new Bag<Integer>();
	            }
	            int E = in.readInt();
	            if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
	            for (int i = 0; i < E; i++) {
	                int v = in.readInt();
	                int w = in.readInt();
	                validateVertex(v);
	                validateVertex(w);
	                addEdge(v, w); 
	            }
	        }
	        catch (NoSuchElementException e) {
	            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
	        }
	    }



	    public Graph(Graph G) {
	        this(G.V());
	        this.E = G.E();
	        for (int v = 0; v < G.V(); v++) {
	            // reverse so that adjacency list is in same order as original
	            Stack<Integer> reverse = new Stack<Integer>();
	            for (int w : G.adj[v]) {
	                reverse.push(w);
	            }
	            for (int w : reverse) {
	                adj[v].add(w);
	            }
	        }
	    }

	    public int V() {
	        return V;
	    }

	    public int E() {
	        return E;
	    }

	    // throw an IllegalArgumentException unless {@code 0 <= v < V}
	    private void validateVertex(int v) {
	        if (v < 0 || v >= V)
	            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
	    }


	    public void addEdge(int v, int w) {
	        validateVertex(v);
	        validateVertex(w);
	        E++;
	        adj[v].add(w);
	        adj[w].add(v);
	    }



	    public Iterable<Integer> adj(int v) {
	        validateVertex(v);
	        return adj[v];
	    }


	    public int degree(int v) {
	        validateVertex(v);
	        return adj[v].size();
	    }



	    public String toString() {
	        StringBuilder s = new StringBuilder();
	        s.append(V + " vertices, " + E + " edges\n ");
	        for (int v = 0; v < V; v++) {
	            s.append(v + ": ");
	            for (int w : adj[v]) {
	                s.append(w + " ");
	            }
	            s.append("\n");
	        }
	        return s.toString();
	    }



}}