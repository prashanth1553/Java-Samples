package com.smi;

public class FindNodesAtKDistance {

	private Node root;

	private int nodesAtL;

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}

	}

	public void put(int data) {
		root = put(root, data);
	}

	private Node put(Node x, int data) {
		if (x == null) {
			return new Node(data);

		}
		if (x.data == data) {
			return x;
		} else if (x.data > data) {
			x.left = put(x.left, data);

		} else {
			x.right = put(x.right, data);
		}
		return x;
	}

	private int childNodesAtDistanceK(Node x, int k) {
		if (x == null || k < 0) {
			return 0;
		}
		if (k == 0) {
			return 1;
		}

		return childNodesAtDistanceK(x.left, k - 1) + childNodesAtDistanceK(x.right, k - 1);

	}

	public int nodesAtK(int data, int K) {
		nodesAtL = 0;
		nodesAtK(root, data, K);
		return nodesAtL;
	}

	private int nodesAtK(Node x, int data, int K) {
		if (x == null) {
			return -1;
		}
		if (x.data == data) {
			nodesAtL += childNodesAtDistanceK(x, K);
			return K - 1;

		} else if (x.data > data) {
			int kAtCurrent = nodesAtK(x.left, data, K);
			if (kAtCurrent < 0) {
				return -1;
			}
			if (kAtCurrent == 0) {
				nodesAtL++;
				return -1;
			}
			childNodesAtDistanceK(x.right, kAtCurrent - 1);
			return kAtCurrent - 1;
		} else {
			int kAtCurrent = nodesAtK(x.right, data, K);
			if (kAtCurrent < 0) {
				return -1;
			}
			if (kAtCurrent == 0) {
				nodesAtL++;
				return -1;
			}
			childNodesAtDistanceK(x.left, kAtCurrent - 1);
			return kAtCurrent - 1;
		}

	}

	public static void main(String args[]) {
		int array[] = { 10, 5, 15, 20, 6 };
		FindNodesAtKDistance obj = new FindNodesAtKDistance();
		for (int i : array) {
			obj.put(i);
		}
		System.out.println(obj.nodesAtK(10, 2));

	}

}
