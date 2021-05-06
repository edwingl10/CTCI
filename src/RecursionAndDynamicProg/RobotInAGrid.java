package RecursionAndDynamicProg;
import java.awt.*;
import java.util.ArrayList;

public class RobotInAGrid {
    /**
     * Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
     * The robot can only move in two directions, right and down, but certain cells are "off limits"
     * such that the robot cannot step on them. Design an algorithm to find a path for the robot from
     * the top left to the bottom right.
     */

    ArrayList<Point> getPath(boolean[][] maze){
        if(maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<Point>();
        if(getPath(maze, maze.length-1, maze[0].length-1, path))
            return path;
        return null;
    }
    boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path){
        // if out of bounds or not available
        if(col <0 || row<0 || !maze[row][col])
            return false;

        boolean isAtOrigin = (row ==0) && (col==0);

        if(isAtOrigin || getPath(maze, row, col-1, path) || getPath(maze ,row-1, col, path)){
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        RobotInAGrid r = new RobotInAGrid();
    }

}
