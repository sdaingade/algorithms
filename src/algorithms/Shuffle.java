package algorithms;

import java.util.Random;

public class Shuffle {
	
	public static void shuffle(Comparable[]  array) {
		int len = array.length;
		Random random = new Random();
		int r;

		for (int i = 0; i < len; i++) {
			r = random.nextInt(i + 1); // 0 to i
			exch(array, i, r);
		}
	}

	public static void exch(Comparable[] array, int i, int j) {
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
