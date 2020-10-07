package client;

import algorithms.graphs.ConnectedComponents;
import algorithms.graphs.ConnectedComponentsImpl;
import algorithms.graphs.GraphImpl;

public class ConnectedComponentsClient {

	public static void main(String[] args) throws Exception {
		String path = "G:/Coursera Algorithms2/tinyG.txt";
		GraphImpl graph = new GraphImpl(path);
		System.out.println("Graph loaded from file " + path);
		
		ConnectedComponents cc = new ConnectedComponentsImpl(graph);
		System.out.println("The number of connected components is " + cc.count());
		System.out.println("The components id for 6 is " + cc.id(6));
		System.out.println("The components id for 8 is " + cc.id(8));
		System.out.println("The components id for 10 is " + cc.id(10));
		
		System.out.println("Do vertices 2 and 4 belong to the same connected component? " + cc.connected(2, 4));
		System.out.println("Do vertices 6 and 10 belong to the same connected component? " + cc.connected(6, 10));
	}

}
