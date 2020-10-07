package algorithms;

public class UnionFind {

	private int[] id;
	
	/**
	 * Initialize union find data structure with N Objects
	 * (0 to N-1)
	 * @param n
	 */
	public UnionFind(int n) {
		id = new int[n];

		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}
	
	/**
	 * Add connection between p and q
	 * 
	 * @param p
	 * @param q
	 */
	public void union(int p, int q){
		int i = findRoot(p);
		int j = findRoot(q);
		id[i] = j;
	}
	
	/**
	 * Find the root of node i
	 * 
	 * @param i
	 * @return
	 */
	private int findRoot(int i) {
		while (id[i] != i) {
			i = id[i];
		}
		return i;
	}

	/**
	 * Are p and q in the same connected component
	 *
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean connected(int p, int q) {
		return findRoot(p) == findRoot(q);
	}
	
	/**
	 * Find the component to which p belongs
	 * 
	 * @param p
	 * @return
	 */
	public int findComponent(int p) {
		return id[p];
	}
}
