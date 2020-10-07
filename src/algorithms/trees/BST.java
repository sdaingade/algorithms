package algorithms.trees;

public class BST<Key extends Comparable<Key>, Value> {

	private Node root;

	private class Node {
		private Key key;
		private Value value;
		private Node right, left;
		
		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
		}

	}
	
	public Value get(Key key) {
		Node x = root;
		while(x != null) {
			int cmp = key.compareTo(x.key);
			if (cmp < 0) {
				x = x.left;
			} else if (cmp > 0) {
				x = x.right;
			} else {
				return x.value;
			}
		}
        // Key not found.
		return null;
	}

}
