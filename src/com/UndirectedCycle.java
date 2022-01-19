package com;

import java.util.Stack;

public class UndirectedCycle {

	boolean marked[];
	Stack<Integer> cycle = new Stack<>();
	boolean hasCycle;

	int edgeTo[];

	public UndirectedCycle(Graph g) {

		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		for (int i = 0; i < g.V(); i++) {

			if (!marked[i]) {

				dfs(g, -1, i);
			}
		}

	}

	private void dfs(Graph g, int u, int v) {

		marked[v] = true;
		for (int w : g.adjList(v)) {

			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(g, v, w);
			} else if (u != w) {

				for (int i = v; i != w; i = edgeTo[i]) {

					cycle.push(i);
				}
				cycle.push(w);
				cycle.push(v);

			}

		}

	}

}
