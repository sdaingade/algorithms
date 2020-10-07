package algorithms.graphs;

public interface Digraph {

	/**
	 * Add a directed edge from vertex v to w
	 * @param v
	 * @param w
	 * @throws Exception
	 */
	public void addEdge(int v, int w) throws Exception;

	/**
	 * Get vertices poining from vertex v
	 * @param v
	 * @return
	 * @throws Exception
	 */
	public Iterable<Integer> getAdjacent(int v) throws Exception;

	public int getNumVertices();

	public int getNumEdges();

	/**
	 * Get reverse of the Digraph
	 * @return
	 * @throws Exception
	 */
	public Digraph reverse() throws Exception;

	public String toString();

}
