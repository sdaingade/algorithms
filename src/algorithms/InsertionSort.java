package algorithms;

public class InsertionSort {
	
	public static void sort(Comparable[] array) {
		int len = array.length;
		for(int i = 0; i < len; i++) {
			for(int j = i; j > 0; j--) {
				if(less(array[j], array[j -1 ])) {
					exch(array, j, j -1);
				} else {
					break;
				}
			}
		}
	}

	public static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	public static void exch(Comparable[] array, int i, int j) {
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
