package com.algorithm.training.tree.redundant_connection;

public class Solution {
    int[] parents;
    public int[] findRedundantConnection(int[][] edges) {
        parents = new int[1001];
        for(int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        int[] result = null;
        for(int[] edge : edges) {
            int parent1 = find(edge[0]);
            int parent2 = find(edge[1]);
            if(parent1 == parent2) result = edge; 
            parents[parent2] = parent1;
        }
        return result;
    }
    
    public int find(int point) {
        if(parents[point] == point) return point;
        return find(parents[point]);
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.findRedundantConnection(new int[][]{{1,2},{1,3},{2,3}}); //2,3
        result = solution.findRedundantConnection(new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}}); //1,4
        result = solution.findRedundantConnection(new int[][]{{1,4},{3,4},{1,3},{1,2},{4,5}}); //1,3
        System.out.println(result[0] + ", " + result[1]);
    }
}
