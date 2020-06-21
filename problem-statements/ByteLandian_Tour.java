package HackerRank;

import java.util.ArrayList;

public class ByteLandian_Tour {
	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}

	public static boolean checkEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		for (int i = 0; i < adj.get(u).size();) {
			if (adj.get(u).get(i) == v) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public static int countPaths(ArrayList<ArrayList<Integer>> newRoadGraph) {
		int size=newRoadGraph.size() ;
		int possiblePath=0 ;
		int nonPossiblePath ;
		int count=0 ;
		for(int i=0;i<size;i++) {
			for(int j=0;j<newRoadGraph.get(i).size();j++) {
				if(newRoadGraph.get(i).get(j)==0) {
					possiblePath++ ;
					break ;
				}
			}
		}
		nonPossiblePath = size - possiblePath-1 ;
		
		if(possiblePath==0) {
			count=count+possiblePath ;
		}
		else
		{
			int fact=1 ;
			for(int i=1 ;i<=possiblePath;i++) {
				fact=fact*i ;
			}
			count=count+fact ;
		}
		
		if(nonPossiblePath==0) {
			count=count+nonPossiblePath ;
		}
		else
		{
			int fact=1 ;
			for(int i=1 ;i<=nonPossiblePath;i++) {
				fact=fact*i ;
			}
			count=count+fact ;
		}
		System.out.println("possible ways :  " + possiblePath);
		System.out.println("non possible ways : "+nonPossiblePath) ;
		return count ;
	}
	
	private static ArrayList<ArrayList<Integer>> addNewRoads(ArrayList<ArrayList<Integer>> oldRoadGraph,
			ArrayList<ArrayList<Integer>> newRoadGraph) {

		for (int i = 0; i < oldRoadGraph.size(); i++) {

			if (oldRoadGraph.get(i).size() >= 2) {

				for (int j = 0; j < oldRoadGraph.get(i).size() - 1; j++) {
					
					  if(!checkEdge(oldRoadGraph,oldRoadGraph.get(i).get(j),oldRoadGraph.get(i).get(j+1) )) 
					  {
						  addEdge(newRoadGraph,oldRoadGraph.get(i).get(j),oldRoadGraph.get(i).get(j+1)); 
					  }
				}
			}
		}
		;
		//printGraph(newRoadGraph);
		return newRoadGraph ;
	}

	public static void printGraph(ArrayList<ArrayList<Integer>> adj)

	{
		for (int i = 0; i < adj.size(); i++) {
			System.out.println("\nAdjacency list of vertex : " + i);
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(" -> " + adj.get(i).get(j));
			}
			System.out.println();
		}
	}

	public static int bytelandianTours(int n, int[][] roads) {

		ArrayList<ArrayList<Integer>> oldGraph = new ArrayList<ArrayList<Integer>>(n);
		ArrayList<ArrayList<Integer>> newGraph = new ArrayList<ArrayList<Integer>>(n);
		
		for (int i = 0; i < n; i++) {
			oldGraph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < 1; j++) {
				addEdge(oldGraph, roads[i][j], roads[i][j + 1]);
			}

		}
		for (int i = 0; i < n; i++) {
			newGraph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < 1; j++) {
				addEdge(newGraph, roads[i][j], roads[i][j + 1]);
			}

		}
		
		newGraph=addNewRoads(oldGraph,newGraph) ;
		int count = countPaths(newGraph) ; 

		return count ;
	}

	public static void main(String[] args) {

		int num = 5;
		int roads[][] = { { 0, 1 }, { 1, 2 },{2,3} ,{2,4} };
		int result;

		result = bytelandianTours(num, roads);
		System.out.println("Number of ways to reach : " + result);

	}
}
