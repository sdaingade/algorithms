package algorithms.graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class EdgeWeightedGraph {
	private ArrayList<Edge>[] adjList;
	private int numVertices;
	private int numEdges;
	
	public EdgeWeightedGraph(String path) throws Exception {
		System.out.println("Reading file " + path);
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(path));
			numVertices = Integer.parseInt(reader.readLine());
			numEdges = Integer.parseInt(reader.readLine());
			
			adjList = (ArrayList<Edge>[]) new ArrayList[numVertices];

			for(int i = 0; i < numVertices; i++) {
				adjList[i] = new ArrayList<Edge>();
			}
			
			for(int i = 0; i < numEdges; i++) {
				String edge = reader.readLine();
				String[] edgeComponents = edge.split(" ");
				if (edgeComponents.length < 2)
					continue; // We expect vertex v, vertex w and weight of the edge
				Edge newEdge = new Edge(Integer.parseInt(edgeComponents[0]),
                                        Integer.parseInt(edgeComponents[1]),
                                        Double.parseDouble(edgeComponents[2]));
				addEdge(newEdge);
			}
		} catch (Exception e) {
			System.out.println("Failed to create graph object");
			throw e;
		} finally {
			reader.close();
		}
	}

	public void addEdge(Edge e) throws Exception {
		int v = e.either();
		int w = e.other(v);
		
		if(!isIndexValid(v) || ! isIndexValid(w)) {
			throw new Exception("Invalid Argument");
		}

		adjList[v].add(e);
		adjList[w].add(e);
	}
	
	public Iterable<Edge> adj(int v) throws Exception {
		if(!isIndexValid(v)) {
			throw new Exception("Invalid Argument");
		}
		return adjList[v];
	}

	//public Iterable<Edge> edges() {
		
	//}
	
	public int getNumVertices() {
		return numVertices;
	}
	
	public int getNumEdges() {
		return numEdges;
	}

	private boolean isIndexValid(int v) {
		if (v < 0 || v > numVertices - 1 )
			return false;
		else
			return true;
	}
}
