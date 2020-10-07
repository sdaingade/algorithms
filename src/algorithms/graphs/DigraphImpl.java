package algorithms.graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DigraphImpl implements Digraph {
	private int numVertices = 0;
	private int numEdges = 0;
	private ArrayList<Integer>[] adjList = null; 

	public DigraphImpl(String path) throws Exception {
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(path));
			numVertices = Integer.parseInt(input.readLine());
			numEdges = Integer.parseInt(input.readLine());
			
			initDigraph();

			for (int i = 0; i < numEdges; i++) {
				String line = input.readLine();
				String[] vertices = line.split(" ");
				if (vertices == null || vertices.length < 2) {
					System.out.println(" Ignoring line " + line);
				}
				int v = Integer.parseInt(vertices[0]);
				int w = Integer.parseInt(vertices[1]);
				addEdge(v, w);
				System.out.println("Added edge " + v + " -> " + w);
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void initDigraph() {
		adjList = (ArrayList<Integer>[])new ArrayList[numVertices];

		for (int i = 0; i < numVertices; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
	}

	@Override
	public void addEdge(int v, int w) throws Exception {
		if(!isIndexValid(v) || !isIndexValid(w)) {
			throw new Exception("Invalid Index");
		}

		adjList[v].add(w);
	}

	private boolean isIndexValid(int v) {
		if(v < 0 || v >= numVertices)
			return false;
		return true;
	}

	@Override
	public Iterable<Integer> getAdjacent(int v) throws Exception {
		if(!isIndexValid(v)) {
			throw new Exception("Invalid Index");
		}
		return adjList[v];
	}

	@Override
	public int getNumVertices() {
		return numVertices;
	}

	@Override
	public int getNumEdges() {
		return numEdges;
	}

	@Override
	public Digraph reverse() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
