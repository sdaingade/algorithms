package algorithms.graphs;

import java.util.Stack;

public class TopologicalSort {
	private Digraph g;
	private boolean[] marked;
	private Stack<Integer> reversePostOrder;

	public TopologicalSort(Digraph g) throws Exception {
		this.g = g;
		marked = new boolean[g.getNumVertices()];
		reversePostOrder = new Stack<Integer>();
		
		for(int i = 0; i < g.getNumVertices(); i++) {
			marked[i] = false;
		}
		for(int i = 0; i < g.getNumVertices(); i++) {
			if (!marked[i]) {
				dfs(i);
			}
		}
	}

	private void dfs(int s) throws Exception {
		marked[s] = true;
		for(int v : g.getAdjacent(s)) {
			if(!marked[v]) {
				dfs(v);
			}
		}
		reversePostOrder.push(s);
	}

	public Iterable<Integer> getSorted() {
		return reversePostOrder;
	}
}
