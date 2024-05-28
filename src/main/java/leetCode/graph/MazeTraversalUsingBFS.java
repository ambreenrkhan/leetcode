package leetCode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import static leetCode.graph.Maze.Coordinate;

/**
 * 1.Add the starting node in queue
 * 2.While the queue is not empty, pop a node, do following:
 *      a. If we reach the wall or the node is already visited, skip to next iteration
 *      b. If exit node is reached, backtrack from current node till start node to find the shortest path
 *      c. Else, add all immediate neighbors in the four directions in queue
 * One important thing here is that the nodes must keep track of their parent, i.e. from where they were added to the queue.
 * This is important to find the path once exit node is encountered.
 */
public class MazeTraversalUsingBFS {

    public static void findShortestRoute(Maze maze){
        Queue<Coordinate> coordinates = new LinkedList<>();
        coordinates.add(maze.getEntry());

        Coordinate current = null;

        while(!coordinates.isEmpty()){
            current = coordinates.poll();


            if( !maze.isValidLocation(current.getX(), current.getY()) || maze.isExplored(current.getX(), current.getY())){
                continue;
            }

            if(maze.isExit(current.getX(), current.getY())){
                break;
            }

            if(maze.isWall(current.getX(), current.getY())){
                maze.setVisited(current.getX(), current.getY(), true);
                continue;
            }

            Coordinate left = new Coordinate(current.getX()-1, current.getY(), current);
            Coordinate right = new Coordinate(current.getX()+1, current.getY(), current);;
            Coordinate up = new Coordinate(current.getX(), current.getY()-1, current);;
            Coordinate down = new Coordinate(current.getX(), current.getY()+1, current);;

            coordinates.add(left);
            coordinates.add(right);
            coordinates.add(up);
            coordinates.add(down);
            maze.setVisited(current.getX(), current.getY(), true);

        }

        List<Coordinate> path = backtrackPath(current);
        maze.printPath(path);
    }

    private static List<Coordinate> backtrackPath(
            Coordinate cur) {
        List<Coordinate> path = new ArrayList<>();
        Coordinate iter = cur;

        while (iter != null) {
            path.add(iter);
            iter = iter.parent;
        }

        return path;
    }


    public static void main(String args[]){
        String str = "S ########"+System.lineSeparator()+"#        #"+System.lineSeparator()+"# ###  # #"+System.lineSeparator()+"# #    # #"+System.lineSeparator()+"# #  # # #"+System.lineSeparator()+"####E#####";
        str = "S ###E####"+System.lineSeparator()+"#        #"+System.lineSeparator()+"# ###  # #"+System.lineSeparator()+"# #    # #"+System.lineSeparator()+"# #  # # #"+System.lineSeparator()+"#### #####";

        Maze maze = new Maze(str);
        maze.printMaze();
        findShortestRoute(maze);
    }
}
