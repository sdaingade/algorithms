package algorithms;

public class SelectionSort {

	/**
	 * Invariant
     * 2.1 slide 17
	 * 
	 */
	public static void sort(Comparable[] array) {
		int len = array.length;
		for (int i = 0; i < len; i++) {
			int min = i;
			for (int j = i + 1; j < len; j++) {
				if(less(array[j], array[min])) {
					min = j;
				}
			}
			exch(array, i, min);
		}
	}
	
	public static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	public static void exch(Comparable[] array, int index1, int index2) {
		Comparable temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
