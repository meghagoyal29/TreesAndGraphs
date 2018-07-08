package TreesAndGraphs;

import java.util.HashMap;
import java.util.HashSet;

public class GraphValidTree {
	public static void main(String[] args) {
		int[][] edges = {{0,1},{2,3}};//{{1,2},{2,3},{0,3}, {0,1}};
		System.out.println(validTree(edges,4));
	}
	public static boolean validTree(int[][] edges,int n) {
		if(edges.length!=n-1) {
			return false;
		}
		HashMap<Integer,HashSet<Integer>>nodeToChildrenMap = new HashMap<>();
		for(int i=0;i<n;i++) {
			nodeToChildrenMap.put(i, new HashSet<Integer>());
		}
		for(int[]edge:edges) {
			
			if(!updateNeighborsAndCheckCycle(nodeToChildrenMap,edge[0],edge[1]))
				return false;
		}
		return true;
	}
	private static boolean updateNeighborsAndCheckCycle(HashMap<Integer, HashSet<Integer>> edgeMap, int nodea, int nodeb) {
		
		for(Integer neighbor: edgeMap.get(nodea)) {
			{
				if(!edgeMap.get(neighbor).add(nodeb)||!edgeMap.get(nodeb).add(neighbor))
					return false;
			}
		}
		if(!edgeMap.get(nodeb).add(nodea)||!edgeMap.get(nodea).add(nodeb))
			return false;
		return true;
	}
}
