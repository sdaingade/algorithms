package tests;

public class Squares {

	public static void main(String[] args) {
		long product = 1;
		for(int i = 1; i < 100; i++) {
			product = i * product;
			System.out.println(i + "! = " + product);
		}
	}
}

