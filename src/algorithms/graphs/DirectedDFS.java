package algorithms.graphs;

public class DirectedDFS {

	public boolean[] marked;

	public int[] edgeTo;
	
	Digraph digraph;
	
	public DirectedDFS(Digraph g, int source) throws Exception {
		marked = new boolean[g.getNumVertices()];
		edgeTo = new int[g.getNumVertices()];
		this.digraph = g;

		for (int i = 0; i < g.getNumVertices(); i++) {
			marked[i] = false;
			edgeTo[i] = -1;
		}
		
		dfs(source);
	}

	private void dfs(int s) throws Exception {
		if(!isIndexValid(s)) {
			throw new Exception("Invalid index");
		}
		marked[s] = true;
		for(int i: digraph.getAdjacent(s)) {
			if(!marked[i]) {
				dfs(i);
				edgeTo[i] = s;
			}
		}
	}

	private boolean isIndexValid(int i) {
		if (i < 0 || i >= digraph.getNumVertices())
			return false;
		return true;
	}
	
}
