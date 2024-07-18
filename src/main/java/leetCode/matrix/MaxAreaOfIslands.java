package leetCode.matrix;

public class MaxAreaOfIslands {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        if(grid == null || grid.length == 0) return maxArea;

        for(int r=0; r< grid.length; r++){
            for(int c=0; c< grid[0].length; c++){
                if(grid[r][c] == 1){
                    CurrentArea currentArea = new CurrentArea();
                    traverseNeighbours(r,c,grid,currentArea);
                    maxArea = Math.max(maxArea, currentArea.value);
                }
            }
        }

        return maxArea;
    }

    private void traverseNeighbours(int row, int column, int[][] grid, CurrentArea currentArea){
        if(row<0 || column<0 || row>=grid.length || column>=grid[0].length || grid[row][column] == 0 || grid[row][column] == 2){
            return;
        }

        if(grid[row][column] == 1){
            currentArea.value = currentArea.value+1;
            grid[row][column] = 2;
        }

        traverseNeighbours(row+1, column, grid, currentArea);
        traverseNeighbours(row-1, column, grid, currentArea);
        traverseNeighbours(row, column+1, grid, currentArea);
        traverseNeighbours(row, column-1, grid, currentArea);
    }

    private static class CurrentArea{
        private int value;
    }

    public static void main(String[] args){
        int[][] grid = {{0,0,0,0,0,0,0,0}};
        var maxAreaOfIslands = new MaxAreaOfIslands();
        System.out.println(maxAreaOfIslands.maxAreaOfIsland(grid));
    }
}
