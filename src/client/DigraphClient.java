package client;

import algorithms.graphs.DigraphImpl;
import algorithms.graphs.DirectedDFS;
import algorithms.graphs.DirectedBFS;

public class DigraphClient {

	public static void main(String[] args) throws Exception {
		String path = "G:/Coursera Algorithms2/tinyDG.txt";
		DigraphImpl digraph = new DigraphImpl(path);
		System.out.println("Loaded digraph from " + path);
		
		DirectedDFS directedDFS = new DirectedDFS(digraph, 0);
		System.out.println("Done with dfs on digraph in file " + path);
		
		DirectedBFS directedBFS = new DirectedBFS(digraph, 0);
		System.out.println("Done with bfs on digraph in file " + path);
	}
}
