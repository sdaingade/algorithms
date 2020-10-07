package client;

import algorithms.graphs.Edge;
import algorithms.graphs.EdgeWeightedGraph;
import algorithms.graphs.MST;

public class MSTClient {

	public static void main(String[] args) throws Exception {
		EdgeWeightedGraph g = new EdgeWeightedGraph("G:/Coursera Algorithms2/tinyEWG.txt");
		/*
		MST mst = new MST(g);
		
		for(Edge e : mst.edges()) {
			System.out.println(e.toString());
		}

		System.out.println("Weight of the MST is : " mst.weight());
		*/
	}

}
