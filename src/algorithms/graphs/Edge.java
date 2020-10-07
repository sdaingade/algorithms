package algorithms.graphs;

public class Edge implements Comparable<Edge> {
	
	public int v;
	public int w;
	public double weight;
	

	public Edge (int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	/**
	 * Return one of the two vertices
	 * @return
	 */
	public int either() {
		return v;
	}

	/**
	 * Given first vertex, return the other one
	 * @param vertex
	 * @return
	 * @throws Exception
	 */
	public int other(int vertex) throws Exception {
		if (vertex == v)
			return w;
		else if(vertex == w)
			return v;
		else
			throw new Exception("Invalid Argument");
	}

	/**
	 * Compare two edges
	 * 
	 * @param that
	 * @return
	 */
	@Override
	public int compareTo(Edge that) {
		if(this.weight < that.weight)
			return -1;
		else if (this.weight > that.weight)
			return 1;
		else
			return 0;
	}
	
	public String toString() {
		return v + "-" + w + " " + weight;
	}
}
