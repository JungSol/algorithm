package com.algorithm.training.depth_first_search.pacific_atlantic_water_flow;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int[][] matrix;
    static boolean[][] visit;
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> points = new ArrayList<>();
        if(matrix.length == 0) return points;
        Solution.matrix = matrix;
        visit = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(canFlow(i, j) == 3) {
                    points.add(new int[]{i, j});
                }
            }
        }
        return points;
    }
    private int canFlow(int i, int j) {
        int path = 0;
        if(i == 0 || j == 0) path |= (1<<0);
        if(i == matrix.length-1 || j == matrix[i].length-1) path |= (1<<1);
        
        visit[i][j] = true;
        if(path < 3 && i < matrix.length-1 && !visit[i+1][j] && matrix[i][j] >= matrix[i+1][j]) { //아래
            path |= canFlow(i+1, j);
        }
        if(path < 3 && i > 0 && !visit[i-1][j] && matrix[i][j] >= matrix[i-1][j]) { //위
            path |= canFlow(i-1, j);
        }
        if(path < 3 && j < matrix[0].length-1 && !visit[i][j+1] && matrix[i][j] >= matrix[i][j+1]) { //오른쪽
            path |= canFlow(i, j+1);
        }
        if(path < 3 && j > 0 && !visit[i][j-1] && matrix[i][j] >= matrix[i][j-1]) { //왼쪽
            path |= canFlow(i, j-1);
        }
        visit[i][j] = false;
        return path;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<int[]> points = solution.pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}});
        for(int[] point : points) {
            System.out.print("[" + point[0] + ", " + point[1] + "] ");
        }
        System.out.println();
        points = solution.pacificAtlantic(new int[][]{{1,1},{1,1},{1,1}});
        for(int[] point : points) {
            System.out.print("[" + point[0] + ", " + point[1] + "] ");
        }
        System.out.println();
        points = solution.pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}});
        for(int[] point : points) {
            System.out.print("[" + point[0] + ", " + point[1] + "] ");
        }
        System.out.println();
        points = solution.pacificAtlantic(new int[][]{
            {11,3,2,4,14,6,13,18,1,4,12,2,4,1,16},
            {5,11,18,0,15,14,6,17,2,17,19,15,12,3,14},
            {10,2,5,13,11,11,13,19,11,17,14,18,14,3,11},
            {14,2,10,7,5,11,6,11,15,11,6,11,12,3,11},
            {13,1,16,15,8,2,16,10,9,9,10,14,7,15,13},
            {17,12,4,17,16,5,0,4,10,15,15,15,14,5,18},
            {9,13,18,4,14,6,7,8,5,5,6,16,13,7,2},
            {19,9,16,19,16,6,1,11,7,2,12,10,9,18,19},
            {19,5,19,10,7,18,6,10,7,12,14,8,4,11,16},
            {13,3,18,9,16,12,1,0,1,14,2,6,1,16,6},
            {14,1,12,16,7,15,9,19,14,4,16,6,11,15,7},
            {6,15,19,13,3,2,13,7,19,11,13,16,0,16,16},
            {1,5,9,7,12,9,2,18,6,12,1,8,1,10,19},
            {10,11,10,11,3,5,12,0,0,8,15,7,5,13,19},
            {8,1,17,18,3,6,8,15,0,9,8,8,12,5,18},
            {8,3,6,12,18,15,10,10,12,19,16,7,17,17,1},
            {12,13,6,4,12,18,18,9,4,9,13,11,5,3,14},
            {8,4,12,11,2,2,10,3,11,17,14,2,17,4,7},
            {8,0,14,0,13,17,11,0,16,13,15,17,4,8,3},
            {18,15,8,11,18,3,10,18,3,3,15,9,11,15,15}});
        for(int[] point : points) {
            System.out.print("[" + point[0] + ", " + point[1] + "] ");
        }
    }
}
