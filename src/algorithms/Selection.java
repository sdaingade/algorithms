package algorithms;

public class Selection {
	private Comparable[] array;
	
	public Comparable select(Comparable[] array, int k) {
		int len = array.length;
		this.array = array;

		int lo = 0;
		int hi = len - 1;
		
		while (lo <= hi) {
			int j = partition(lo, hi);
			if (j < k) {
				lo = j + 1;
			} else if (j > k) {
				hi = j - 1;
			} else {
				return array[k];
			}
		}
		return array[k];
	}
	
	public int partition(int lo, int hi) {
		int i = lo + 1;
		int j = hi;
		
		while (true) {
			while(less(array[i], array[lo])) {
				i++;
			}
			while(less(array[lo], array[j])) {
				j--;
			}
			if (i > j) {
				break;
			}
			exch(i, j);
		}
		exch(lo, j);
		return j;
	}
	
	public static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	public void exch(int i, int j) {
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
