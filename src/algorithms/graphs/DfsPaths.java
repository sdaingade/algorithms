package algorithms.graphs;

import java.util.ArrayList;

public class DfsPaths extends PathsBase {

	/**
	 * Find path from s to all vertices in g
	 *
	 * @param g
	 * @param s
	 */
	public DfsPaths(Graph g, int s) throws Exception {
		super(g, s);

		if(!g.isIndexValid(s)) {
			throw new Exception("Invalid input index");
		}

		dfs(s);
	}

	/**
	 * Perform a recursive depth first search on graph g with source s
	 * 
	 * @param s
	 * @throws Exception
	 */
	private void dfs(int s) throws Exception {
		System.out.println("Currently visiting vertex " + s);

		marked[s] = true;
		for(int i : g.getAdjacent(s)) {
			if(!marked[i]) {
				edgeTo[i] = s;
				dfs(i);
			}
		}
		System.out.println("Done visiting vertex " + s);
	}
}
