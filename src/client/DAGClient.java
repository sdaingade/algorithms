package client;

import algorithms.graphs.Digraph;
import algorithms.graphs.DigraphImpl;
import algorithms.graphs.TopologicalSort;

/**
 * Perform topological sort on a graph
 * 
 * @author home
 *
 */
public class DAGClient {

	public static void main(String[] args) throws Exception {
		Digraph g = new DigraphImpl("G:/Coursera Algorithms2/dag.txt");

		TopologicalSort tSort = new TopologicalSort(g);
		System.out.println("Elements printed in topological sorted order are :");

		for(int i : tSort.getSorted()) {
			System.out.println(i + "\t");
		}
	}
}
