package algorithms.graphs;

public class GraphUtils {

	public static int degree(Graph g, int v) throws Exception {
		int degree = 0;
		Iterable<Integer> iterable = g.getAdjacent(v);
		for (Integer i : iterable) {
			degree++;
		}
		return degree;
	}

	public static int maxDegree(Graph g) throws Exception {
		int max = 0;
		for (int i = 0; i < g.getNumVertices(); i++) {
			int vertDegree = degree(g, i);
			if (vertDegree > max) {
				max = vertDegree;
			}
		}
		return max;
	}

	public static double averageDegree(Graph g) {
		return (2.0 * g.getNumEdges())/g.getNumVertices();
	}

	public static int numberOfSelfLoops(Graph g) throws Exception {
		int selfLoopCount = 0;
		for (int i = 0; i < g.getNumVertices(); i++) {
			Iterable<Integer> iterable = g.getAdjacent(i);
			for (int j : iterable) {
				if (i == j) {
					selfLoopCount++;
				}
			}
		}
		return selfLoopCount/2; //Each self loop counted twice
	}
}
