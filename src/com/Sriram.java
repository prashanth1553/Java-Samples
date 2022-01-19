package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Sriram {

	public Sriram() {

		System.out.println("" + (new Test2()).test1());
	}

	private boolean flag() {
		return true;
	}

	public static void main1(String args[]) {
        Timer timer = new Timer();

		List<String> votes = new ArrayList<>();
		votes.add("1");
		votes.add("1");
		votes.add("1");

		votes.add("2");
		votes.add("2");

		votes.add("3");
		votes.add("3");
		votes.add("3");

		System.out.println(method(votes));
	}

	class Test1 {

	}

	class Test2 extends Sriram {

		public boolean test1() {
			return Sriram.this.flag();
		}

	}

	public static String method(List<String> votes) {

		TreeSet<String> maxCountSweets = new TreeSet<>();
		Map<String, Integer> eachSweetCount = new TreeMap<>();
		int maxCount = 0;
		for (String sweet : votes) {
			if (eachSweetCount.containsKey(sweet)) {
				eachSweetCount.put(sweet, eachSweetCount.get(sweet) + 1);
			} else {
				eachSweetCount.put(sweet, 1);
			}
			int currentSweetVotes = eachSweetCount.get(sweet);
			if (currentSweetVotes > maxCount) {
				maxCount = currentSweetVotes;
				maxCountSweets.clear();
				maxCountSweets.add(sweet);
			} else if (currentSweetVotes == maxCount) {
				maxCountSweets.add(sweet);
			}

		}
		return maxCountSweets.last();

	}

	public static void main(String[] args) {
		List<Integer> power = new ArrayList<Integer>();

		Integer[] a = { -5, 4, -2, 3, 1 };

		for (int s : a) {
			power.add(s);
		}

		int netChange = 0;
		int answer = 0;

		for (int i = 0; i < power.size(); i++) {
			int netChangeTemp = netChange + power.get(i);
			if (netChangeTemp == 0) {
				answer++;
				netChange = 1;
			} else if (netChangeTemp < 0) {
				answer += Math.abs(netChangeTemp) + 1;
				netChange = 1;
			} else {
				netChange = netChangeTemp;
			}

		}

		System.out.println(answer);
	}
	
	
}
