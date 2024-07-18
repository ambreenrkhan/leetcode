package leetCode.matrix;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int totalIslands = 0;
        if(grid == null || grid.length == 0) return totalIslands;

        for(int r=0; r< grid.length; r++){
            for(int c=0; c< grid[0].length; c++){
                if(grid[r][c] == '1'){
                    ++totalIslands;
                    traverseNeighbours(r,c,grid);
                }
            }
        }

        return totalIslands;
    }

    private void traverseNeighbours(int row, int column, char[][] grid){
        if(row<0 || column<0 || row>=grid.length || column>=grid[0].length || grid[row][column] == '0' || grid[row][column] == 'v'){
            return;
        }

        if(grid[row][column] == '1'){
            grid[row][column] = 'v';
        }

        traverseNeighbours(row+1, column, grid);
        traverseNeighbours(row-1, column, grid);
        traverseNeighbours(row, column+1, grid);
        traverseNeighbours(row, column-1, grid);
    }

    public static void main(String[] args){
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        var numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(grid));
    }
}
