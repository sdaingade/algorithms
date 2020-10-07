package algorithms.graphs;

import java.util.ArrayList;

public abstract class PathsBase implements Paths{
	protected boolean[] marked;

	protected int[] edgeTo;

	protected Graph g; //graph

	protected int s; //source

	public PathsBase(Graph g, int s) throws Exception {
		marked = new boolean[g.getNumVertices()];
		edgeTo = new int[g.getNumVertices()];

		for(int i = 0; i < g.getNumVertices(); i++) {
			marked[i] = false;
			edgeTo[i] = -1;
		}
		
		this.g = g;
		this.s = s;
	}

	/**
	 * Check of there is a path from s to v
	 *
	 * @param v
	 * @return
	 */
	@Override
	public boolean hasPathTo(int v) {
		return marked[v];
	}

	/**
	 * Return path from s to v
	 *
	 * @param v
	 * @return
	 */
	@Override
	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v)) return null;

		ArrayList<Integer> list = new ArrayList<Integer>();
		while(v != -1) {
			list.add(v);
			v = edgeTo[v];
		}

		return list;
	}
}
