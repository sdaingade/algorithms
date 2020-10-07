package client;

import java.io.BufferedReader;
import java.io.FileReader;

import algorithms.UnionFind;

public class UnionFindClient {

	public static void main(String[] args) throws Exception {
		String path = "";
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(path));
			// Total number of objects
			int objectCount = Integer.parseInt(reader.readLine());
			// Total number of unions to perform
			int unionCount = Integer.parseInt(reader.readLine());

			UnionFind uf = new UnionFind(objectCount);
			for (int i = 0; i < unionCount; i++) {
				String connection = reader.readLine();
				String[] objs = connection.split(" ");
				if (objs.length < 2)
					continue;

				int p = Integer.parseInt(objs[0]);
				int q = Integer.parseInt(objs[1]);

				if (!uf.connected(p, q)) {
					uf.union(p, q);
					System.out.println(p + " union " + q);
				}
			}
		} catch (Exception e) {
			System.out.println("Failed to create UnionFind data structure to count connected components");
			throw e;
		} finally {
			reader.close();
		}
	}
}
