package leetCode.graph;

import java.util.*;

public class BFSMazeExit {
    private static class Point{
        int x;
        int y;
        Point parent;

        public Point(int x, int y, Point parent){
            this.x = x;
            this.y = y;
            this.parent = parent;
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
        Queue<Point> points = new ArrayDeque<>();
        Set<Point> visitedNodes = new HashSet<>();

        Point start = new Point(entrance[0], entrance[1], null);
        points.add(start);

        while(!points.isEmpty()){
            Point point = points.poll();

            if(visitedNodes.contains(point) || isInvalid(point, maze)){
                continue;
            }

            if(maze[point.x][point.y]=='+'){
                visitedNodes.add(point);
                continue;
            }

            if((!point.equals(start))
                    &&(maze[point.x][point.y]=='.')
                    && (point.x == 0 || point.y == 0 || point.x == maze.length-1 || point.y == maze[0].length-1)){

                return backtrackPath(point);
            }

            Point left = new Point(point.x, point.y - 1, point);
            Point right = new Point(point.x, point.y + 1, point);
            Point top = new Point(point.x - 1, point.y, point);
            Point bottom = new Point(point.x + 1, point.y, point);

            points.add(bottom);
            points.add(right);
            points.add(top);
            points.add(left);

            visitedNodes.add(point);
        }

        return -1;

    }

    private int backtrackPath(
            Point cur) {
        Point iter = cur;
        int steps = 0;
        while (iter != null) {
            ++steps;
            iter = iter.parent;
        }

        return steps > 0 ? steps-1 : -1;
    }


    boolean isInvalid(Point point, char[][] maze){
        return point.x < 0 || point.y < 0 ||  point.x >= maze.length || point.y >= maze[0].length;
    }

    public static void main(String[] args){
        BFSMazeExit bme = new BFSMazeExit();

       char[][] maze = {{'+','+','+'},{'.','.','.','+'},{'+','+','+','.'}};
       int [] entrance = {1,2};
       System.out.println(bme.nearestExit(maze,entrance)); // should be -1

    }
}
