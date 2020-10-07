package client;

import algorithms.graphs.GraphImpl;
import algorithms.graphs.Paths;
import algorithms.graphs.DfsPaths;
import algorithms.graphs.BfsPaths;

public class GraphClient {

	public static void main(String[] args) {
		try {
			String path = "G:/Coursera Algorithms2/graph.txt";
			GraphImpl graph = new GraphImpl(path);
			System.out.println("Graph loaded from file " + path);
			
			Paths paths = new DfsPaths(graph, 0);
			System.out.println("Computed paths from 0 to other nodes");

			Iterable<Integer> iterable = paths.pathTo(4);
			if (iterable != null) {
				for (int i : iterable) {
					System.out.print(i + " --> ");
				}
			}
			
			iterable = paths.pathTo(12);
			if (iterable != null) {
				for (int i : iterable) {
					System.out.print(i + " --> ");
				}
			}
			
			path = "G:/Coursera Algorithms2/tinyCG.txt";
			graph = new GraphImpl(path);
			System.out.println("Graph loaded from file " + path);
			paths = new BfsPaths(graph, 0);

			iterable = paths.pathTo(4);
			for( int i : iterable) {
				System.out.print(i+ " --> ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
