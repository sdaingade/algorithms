package algorithms;

public class QuickFind {
	private int size;
	private int[] id;

	public QuickFind(int n) {
		size = n;
		id = new int[n];
		
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}
	
	public void union(int p, int q) {
		if (!isConnected(p, q)) {
			int idP = id[p];
			int idQ = id[q];
			for(int i = 0; i < size; i++) {
				if(id[i] == idP) {
					id[i] = idQ;
				}
			}
		}
	}

	public boolean isConnected(int p, int q) {
		if(id[p] == id[q])
			return true;
		return false;
	}
	
	int findComponent(int p) {
		return id[p];
	}
}
