package leetCode.grid;

public class GridParser {
    public static void main(String args[]){
        String str = "1,2,3,4\\n23,56,7,3\n2,6,9,0\n23,33,44,11";
        Grid g = new Grid(str);
        System.out.println(g);
    }
}
