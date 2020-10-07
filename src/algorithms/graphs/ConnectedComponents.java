package algorithms.graphs;

public interface ConnectedComponents {
	/**
	 * Are vertices u and v connected ?
	 * @param u
	 * @param v
	 * @return
	 */
	public boolean connected(int u, int v) throws Exception;
	
	/**
	 * Number of connected components
	 * @return
	 */
	public int count();
	
	/**
	 * Component identifier for vertex v
	 * @param v
	 */
	public int id(int v) throws Exception;

}
