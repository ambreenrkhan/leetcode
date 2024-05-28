package leetCode.graph;

import java.util.*;

public class BFSMazeExit {
    private class Point{
        int x;
        int y;

        public Point(int x, int y){
         this.x = x;
         this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<Point> points = new LinkedList<>();
        Set<Point> visitedNodes = new HashSet<>();

        Point start = new Point(entrance[0],entrance[1]);
        points.add(start);
        visitedNodes.add(start);
        int steps = 0;

        while(!points.isEmpty()){
            Point point = points.poll();

            System.out.println("CUrrent point " + point.x + "=" + point.y);
            if(!point.equals(start) ){
                steps++;
          //      System.out.println("CUrrent point " + point.x + "=" + point.y);
                if(point.x == 0 || point.y == 0 || point.x == maze.length-1 || point.y == maze[0].length-1){
                    break;
                }
            }

            Point left = new Point(point.x, point.y-1);
            Point right = new Point(point.x, point.y+1);
            Point top = new Point(point.x-1, point.y);
            Point bottom = new Point(point.x+1, point.y);

            if(top.x>=0 &&  maze[top.x][top.y]=='.' && !visitedNodes.contains(top)){
                 System.out.println("Adding top " + top.x + "=" + top.y);

                points.add(top);
            }
            if(bottom.x<maze.length && maze[bottom.x][bottom.y]=='.' && !visitedNodes.contains(bottom)){
                System.out.println("Adding bottom " + bottom.x + "=" + bottom.y);

                points.add(bottom);
            }
            if(left.y>=0 && maze[left.x][left.y]=='.' && !visitedNodes.contains(left)){
                System.out.println("Adding left " + left.x + "=" + left.y);
                points.add(left);
            }
            if(right.y<maze[0].length && maze[right.x][right.y]=='.' && !visitedNodes.contains(right)){
                System.out.println("Adding right " + right.x + "=" + right.y);
                points.add(right);
            }
            visitedNodes.add(right);
            visitedNodes.add(top);
            visitedNodes.add(left);
            visitedNodes.add(bottom);

        }

        return steps > 0 ? steps : -1;
    }

    public static void main(String[] args){
        char[][] maze = {{'.','+','.'}};
        int [] entrance = {0,2};

        BFSMazeExit bme = new BFSMazeExit();
        System.out.println(bme.nearestExit(maze,entrance));
    }
}

