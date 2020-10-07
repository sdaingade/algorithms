package algorithms;

public class QuickSort {
	private Comparable[] arrayToSort;
	
	public void sort(Comparable[] array) {
		arrayToSort = array;
		int len = array.length;

		//Shuffle before beginning sort
		sort(0, len -1);
	}
	
	private void sort(int lo, int hi) {
		if(lo >= hi) {
			return;
		}
		int pos = partition(lo, hi);
		sort(lo, pos - 1);
		sort(pos + 1, hi);
	}
	
	private int partition(int lo, int hi) {
		int i = lo + 1;
		int j = hi;
		
		while (true) {
			while(less(arrayToSort[i], arrayToSort[lo])) {
				i++;
			}
			while(less(arrayToSort[lo], arrayToSort[j])) {
				j--;
			}

			if(i >= j) { //This has to be before the exchange!!!
				break;
			}
			exch(i,j);
		}
		exch(lo, j);
		return j;
	}

	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	private void exch(int i, int j) {
		Comparable temp = arrayToSort[i];
		arrayToSort[i] = arrayToSort[j];
		arrayToSort[j] = temp;
	}
}
