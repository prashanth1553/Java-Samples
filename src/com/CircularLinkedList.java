package com;

public class CircularLinkedList<Item> {

	Node head, tail;

	class Node {
		Item item;
		Node next;

		public Node(Item item, Node next) {
			this.item = item;
			this.next = next;
		}

	}

	public void insert(Item item) {
		if (head == null) {
			head = tail = new Node(item, null);
			return;
		}
		head = new Node(item, head);
		tail.next = head;

	}
}
