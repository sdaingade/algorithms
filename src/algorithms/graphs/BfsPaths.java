package algorithms.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BfsPaths extends PathsBase{

	/**
	 * Find path from source s to all vertices in graph g
	 * 
	 * @param g
	 * @param s
	 * @throws Exception
	 */
	public BfsPaths(Graph g, int s) throws Exception {
		super(g, s);

		bfs();
	}

	/**
	 * Perform a iterative breadth first search on graph g from source s
	 * 
	 * @param g
	 * @param s
	 * @throws Exception
	 */
	private void bfs() throws Exception {
		Queue<Integer> queue = new LinkedList<Integer>();
		//Queue<Integer> queue = new ArrayList<Integer>();
		queue.add(s);
		marked[s] = true;

		while(!queue.isEmpty()) {
			int v = queue.remove();
			for (int i : g.getAdjacent(v)) {
				if (!marked[i]) {
					queue.add(i);
					marked[i] = true;
					edgeTo[i] = v;
				}
			}
		}
	}
}
