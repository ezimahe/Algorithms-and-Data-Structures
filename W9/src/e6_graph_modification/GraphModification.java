package e6_graph_modification;
//author -Eleanor Ezimah
import external_package.Graph;
import external_package.StdOut;
public class GraphModification{
	public class GraphNoParallelEdgesAndNoSelfLoops extends Graph {

	        public GraphNoParallelEdgesAndNoSelfLoops(int vertices) {
	            super(vertices);
	        }

	        @Override
	        public void addEdge(int vertex1, int vertex2) {
	            if (vertex1 == vertex2
	                    || hasEdge(vertex1, vertex2)) {
	                return;
	            }

	            super.addEdge(vertex1, vertex2);
	        }

	        private boolean hasEdge(int vertex1, int vertex2) {
	            for(int neighbor: adjacent(vertex1)) {
	                if (neighbor == vertex2) {
	                    return true;
	                }
	            }

	            return false;
	        }
	    
	}
	    public static void main(String[] args) {
	    	GraphModification graphmodification = new GraphModification();
	        GraphNoParallelEdgesAndNoSelfLoops GraphNoParallelEdgesAndNoSelfLoops =
	        		graphmodification.new GraphNoParallelEdgesAndNoSelfLoops(5);

	        GraphNoParallelEdgesAndNoSelfLoops.addEdge(0, 1);
	        GraphNoParallelEdgesAndNoSelfLoops.addEdge(1, 4);
	        GraphNoParallelEdgesAndNoSelfLoops.addEdge(2, 3);
	        System.out.println("Author - Eleanor Ezimah");
	        System.out.println();
	        StdOut.println("Total number of edges after creation of graph:" + GraphNoParallelEdgesAndNoSelfLoops.edges());
	        System.out.println();
	        
	        System.out.println("Test of Parallel Edge");
	        GraphNoParallelEdgesAndNoSelfLoops.addEdge(1, 0);
	        StdOut.println("Number of edges: " + GraphNoParallelEdgesAndNoSelfLoops.edges());
	        System.out.println();
	        
	        System.out.println("Total number of edges after new edge is added");
	        GraphNoParallelEdgesAndNoSelfLoops.addEdge(2, 4);
	        StdOut.println("Number of edges: " + GraphNoParallelEdgesAndNoSelfLoops.edges());
	        System.out.println();
	        
	        System.out.println("Test of Self Loop");
	        GraphNoParallelEdgesAndNoSelfLoops.addEdge(4, 4);
	        StdOut.println("Number of edges: " + GraphNoParallelEdgesAndNoSelfLoops.edges());
	    }

	}
