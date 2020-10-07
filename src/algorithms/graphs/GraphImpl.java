package algorithms.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;

public class GraphImpl implements Graph {
	private int numVertices;
	private int numEdges;
	private ArrayList<Integer>[] adjList; // Array of ArrayList
	//private LinkedList<Integer>[] adjList;

	public GraphImpl(int numVertices, int numEdges) throws Exception {
		initGraph(numVertices, numEdges);
	}
	
	public GraphImpl(String path) throws Exception {
		System.out.println("Reading file " + path);

		BufferedReader input =  new BufferedReader(new FileReader(path));
		try {
			String line = null;
			line = input.readLine();
			int vertexCount = Integer.parseInt(line);
			line = input.readLine();
			int edgeCount = Integer.parseInt(line);

			initGraph(vertexCount, edgeCount);

			for (int i = 0; i < edgeCount; i++) {
				line = input.readLine();
				String[] vertices = line.split(" ");
				if (vertices == null || vertices.length < 2) {
					System.out.println("Ignoring line " + line);
					continue; // Ignore the file entry 
				}
				int v = Integer.parseInt(vertices[0]);
				int w = Integer.parseInt(vertices[1]);
				addEdge(v, w);
				System.out.println("Added edge " + v + " " + w);
			}
		} catch (Exception e) {
			System.out.println("Failed to create Graph object");
			throw e;
		}
		finally {
			input.close();
		}
	}

	@SuppressWarnings("unchecked")	
	public void initGraph(int numVertices, int numEdges) throws Exception {
		if (numVertices < 1) {
			throw new Exception("Invalid input size");
		}
		if (numEdges < 0) {
			throw new Exception("Invalid input size");
		}

		this.numVertices = numVertices;
		this.numEdges = numEdges;

		adjList = (ArrayList<Integer>[]) new ArrayList[numVertices];
		//adjList = (LinkedList<Integer>[]) new LinkedList[numVertices];
		System.out.println("Creating graph with " + numVertices + "vertices and " + numEdges + " edges");

		for(int i = 0; i < numVertices; i++) {
			adjList[i] = new ArrayList<Integer>();
			//adjList[i] = new LinkedList<Integer>();
		}
	}

	@Override
	public synchronized void addEdge(int v, int w) throws Exception {
		if (!isIndexValid(v) || !isIndexValid(w)) {
			throw new Exception("Invalid input index");
		}
		adjList[v].add(w);
		adjList[w].add(v);
		System.out.println("Adding edge " + v + " - " + w);
	}

	@Override
	public synchronized Iterable<Integer> getAdjacent(int v) throws Exception {
		if (!isIndexValid(v)) {
			throw new Exception("Invalid input index");
		}
		return adjList[v];
	}

	@Override
	public synchronized int getNumVertices() {
		return numVertices;
	}

	@Override
	public synchronized int getNumEdges() {
		return numEdges;
	}

	@Override
	public boolean isIndexValid(int v) {
		return (v >= numVertices || v < 0) ? false : true; 
	}
}
