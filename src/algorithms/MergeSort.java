package algorithms;

public class MergeSort {
	private Comparable[] arrayToSort;
	private Comparable[] auxArray; 
	
	/**
	 * merge 2 arrays lo to mid and mid+1 to hi
	 * 
	 * @param array
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	private void merge (int lo, int mid, int hi) {
		for (int i = lo; i <= hi; i++) {
			auxArray[i] = arrayToSort[i];
		}
		
		// Use i as index for left sub array, j as index for right sub array and k as index for merged array
		int i = lo;
		int j = mid + 1;

		for(int k = lo; k <= hi; k++) {
			if (i > mid ) {
				arrayToSort[k] = auxArray[j++];
			} else if (j > hi) {
				arrayToSort[k] = auxArray[i++];
			} else if (less(auxArray[j], auxArray[i])) {
				arrayToSort[k] = auxArray[j];
			} else {
				arrayToSort[k] = auxArray[i];
			}
		}
	}

	
	
	public void sort(Comparable[] array) {
		int len = array.length;
		arrayToSort = array;
		auxArray = new Comparable[len];
		
		sort(0, len -1);
	}
	
	private void sort(int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		
		int mid = lo + ((hi - lo)/2);

		sort(lo, mid);
		sort(mid + 1, hi);
		merge(lo, mid, hi);
	}
	
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
}
