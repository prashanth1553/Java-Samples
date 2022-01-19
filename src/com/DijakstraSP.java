package com;

public class DijakstraSP {

	private double distanceTo[];
	private DirectedEdge edgeTo[];

	public DijakstraSP(DirectedEdgeWeightedGraph g, int s) {

		distanceTo = new double[g.V()];
		edgeTo = new DirectedEdge[g.V()];
		
		for (int v = 0; v < g.V(); v++)
			distanceTo[v] = Double.POSITIVE_INFINITY;
		
		IndexMinPQ<Double> pq = new IndexMinPQ<>(g.V());
		distanceTo[s] = 0;
		pq.insert(s, 0.0);
		while (!pq.isEmpty()) {

			int v = pq.delMin();
			for(DirectedEdge e : g.adjList(v)) {
				relax(e, pq);
			}
			
			
		}

	}

	private void relax(DirectedEdge e, IndexMinPQ<Double> pq) {
		int v = e.from(), w = e.to();
		if (distanceTo[w] > distanceTo[v] + e.weigth()) {
			distanceTo[w] = distanceTo[v] + e.weigth();
			edgeTo[w] = e;
			if (pq.contains(w)) {
				pq.decreaseKey(w, e.weigth());
			} else {
				pq.insert(w, e.weigth());
			}
		}

	}

}
