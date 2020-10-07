package algorithms.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DirectedBFS {
	public boolean[] marked;
	public int[] edgeTo;
	public Digraph digraph;

	public DirectedBFS(Digraph g, int source) throws Exception {
		marked = new boolean[g.getNumVertices()];
		edgeTo = new int[g.getNumVertices()];
		this.digraph = g;
		
		for(int i = 0; i < g.getNumVertices(); i++) {
			marked[i] = false;
			edgeTo[i] = -1;
		}

		bfs(source);
	}
	
	private void bfs(int source) throws Exception {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		marked[source] = true;

		while(!queue.isEmpty()) {
			int v = queue.remove();

			for(int i : digraph.getAdjacent(v)) {
				if(!marked[i]) {
					queue.add(i);
					marked[i] = true;
					edgeTo[i] = v;
				}
			}
		}
	}
}
