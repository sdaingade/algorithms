package algorithms.graphs;

public interface MST {

	/**
	 * Returns edges in the MST
	 * @return
	 */
	public Iterable<Edge> edges();
	
	/**
	 * Returns weight of the MST
	 * @return
	 */
	public double weight();

}
