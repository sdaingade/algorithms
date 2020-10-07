package tests;

public interface MaxPriorityQueue<Key extends Comparable<Key>> {
  void insert(Key k);

  Key delMax();

  boolean isEmpty();

  Key max();

  int size();
}
