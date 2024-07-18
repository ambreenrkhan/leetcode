package leetCode.matrix;

import java.util.stream.Stream;

public class LongestIncreasingPath {
    public int longestIncreasingPath(int[][] grid) {
        int longestIncreasingPath = 0;
        if(grid == null || grid.length == 0) return longestIncreasingPath;

        int numberOfRows = grid.length;
        int numberOfCols = grid[0].length;

        int[][] cache = new int[numberOfRows][numberOfCols];

        for(int r=0; r<numberOfRows; r++){
            for(int c=0; c<numberOfCols; c++){
                int currentMax = traverseNeighbours(r,c,grid,cache,-1);
                longestIncreasingPath = Math.max(longestIncreasingPath, currentMax);
            }
        }

        return longestIncreasingPath;
    }

    private int traverseNeighbours(int row, int column, int[][] grid, int[][] cache, int currentValue){
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length ) {
            return 0;
        }

        if(grid[row][column] <= currentValue){
            return 0;
        }

        if(cache[row][column]>0){
            return cache[row][column];
        }

        int current = grid[row][column];
        int right = traverseNeighbours(row+1, column, grid, cache, current);
        int bottom = traverseNeighbours(row, column+1, grid, cache, current);
        int left = traverseNeighbours(row-1, column, grid, cache, current);
        int top = traverseNeighbours(row, column-1, grid, cache, current);
        cache[row][column] = Stream.of(right, bottom, left, top).max(Integer::compareTo).get() + 1;

        return cache[row][column];
    }

    public static void main(String[] args){
        int[][] grid = {{1}};
        var lip = new LongestIncreasingPath();
        System.out.println(lip.longestIncreasingPath(grid));
    }
}
