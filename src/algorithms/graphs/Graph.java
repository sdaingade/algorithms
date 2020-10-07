package algorithms.graphs;

public interface Graph {
	/**
	 * Add an edge v-w
	 */
	void addEdge(int v, int w) throws Exception;
	
	/**
	 * get Vertices adjacent to v
	 */
	Iterable<Integer> getAdjacent(int v) throws Exception;

	/**
	 * Return number of vertices
	 */
	int getNumVertices();

	/**
	 * Return number of edges
	 */
	int getNumEdges();

	/**
	 * String representation of the graph
	 */
	String toString();
	
	/**
	 * Is v a valid index 
	 */
	boolean isIndexValid(int v);

}
