package leetCode.grid;

import lombok.ToString;

@ToString
public class Grid {
    Integer[][] values;

    int rows = 0;

    int columns;

    public Grid(String lines){
        boolean init = false;
        String[] allLines = lines.split(System.lineSeparator());


        for(int i = 0; i< allLines.length;i++){
            String[] line = allLines[i].split(",");
            if (init == false) {
                values = new Integer[allLines.length][line.length];
                init = true;
            }
            for(int j = 0; j< line.length;j++){
                values[i][j] = Integer.valueOf(line[j]);
            }
        }
    }

}
