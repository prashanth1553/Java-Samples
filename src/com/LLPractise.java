package com;

public class LLPractise {

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	ListNode head, tail;

	public void add(int data) {
		ListNode newN = new ListNode(data);
		if(head == null) {
			head = tail = newN;
		}else {
			tail.next = newN;
			tail = newN;
		}
		
	}

	public ListNode reverseList(ListNode A, int B) {
		if (A == null || B == 0 || B == 1) {
			return A;
		}

		ListNode dummy = new ListNode(0);
		ListNode tDummy = dummy;
		while (A != null) {
			int k = B;
			ListNode rev = null;
			ListNode firstNodeInReverse = null;
			while (A != null && k > 0) {
				if (firstNodeInReverse == null) {
					firstNodeInReverse = A;
				}
				ListNode nextT = A.next;
				A.next = rev;
				rev = A;
				A = nextT;
				k--;
			}
			tDummy.next = rev;
			tDummy = firstNodeInReverse;

		}

		return dummy.next;

	}

	public static void main(String args[]) {
		LLPractise obj = new LLPractise();

		obj.add(1);
		obj.add(2);
		obj.add(3);
		obj.add(4);
		obj.add(5);
		obj.add(6);
		ListNode reverse = obj.reverseList(obj.head, 2);
		while (reverse != null) {
			System.out.println(reverse.val);
			reverse = reverse.next;
		}

	}
}
