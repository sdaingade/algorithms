package algorithms.graphs;

public class ConnectedComponentsImpl implements ConnectedComponents{
	private boolean[] marked;
	private int[] ccId;
	private Graph graph;
	private int count = 0;

	public ConnectedComponentsImpl(Graph g) throws Exception {
		marked = new boolean[g.getNumVertices()];
		ccId = new int[g.getNumVertices()];
		this.graph = g;

		for(int i = 0; i < g.getNumVertices(); i++) {
			marked[i] = false;
			ccId[i] = -1;
		}
		
		for(int i = 0; i < g.getNumVertices(); i++) {
			if (!marked[i]) {
				dfs(i);
				count++;
			}
		}
	}

	private void dfs(int s) throws Exception{
		if(!isIndexValid(s)) {
			throw new Exception("Invalid Index");
		}
		marked[s] = true;
		ccId[s] = count;

		for(int i : graph.getAdjacent(s)) {
			if (!marked[i]) {
				dfs(i);
			}
		}
	}

	private boolean isIndexValid(int i) {
		if (i < 0 && i >= graph.getNumVertices())
			return false;
		return true;
	}

	@Override
	public boolean connected(int u, int v) throws Exception {
		if(!isIndexValid(u) || !isIndexValid(v)) {
			throw new Exception("Invalid Index");
		}
		return ccId[u] == ccId[v];
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public int id(int v) throws Exception {
		if(!isIndexValid(v)) {
			throw new Exception("Invalid Index");
		}
		return ccId[v];
	}
}
