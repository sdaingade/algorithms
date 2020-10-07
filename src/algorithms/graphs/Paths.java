package algorithms.graphs;

public interface Paths {

	/**
	 * Check of there is a path from s to v
	 *
	 * @param v
	 * @return
	 */
	public boolean hasPathTo(int v);

	/**
	 * Return path from s to v
	 *
	 * @param v
	 * @return
	 */
	public Iterable<Integer> pathTo(int v);

}
