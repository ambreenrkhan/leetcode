package leetCode.arrayString;

public class SetMatrixZeroes {
    public void setZeros(int[][]matrix){
        if(matrix.length == 0 || matrix[0].length == 0) return;

        boolean[] nullableRows = new boolean[matrix.length];
        boolean[] nullableCols = new boolean[matrix[0].length];

        for(int r=0; r<matrix.length;r++){
            for(int c=0;c<matrix[0].length;c++){
                if(matrix[r][c]==0){
                    nullableRows[r]=true;
                    nullableCols[c] =true;
                }
            }
        }

        for(int r=0; r<matrix.length;r++){
            for(int c=0;c<matrix[0].length;c++){
                if(nullableRows[r] || nullableCols[c]) {
                    matrix[r][c] = 0;
                }
            }
        }
    }

}
