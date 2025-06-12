import java.util.*;

public class Grid {
    //change to obj
    private int[][] grid;
    
    public Grid() {
        //change to obj
        grid = new int[10][10];
        //will no longer be needed
        int count = 1;
        for (int rows = 0; rows < 10; rows++) {
            for (int cols = 0; cols < 10; cols++) {
                //= new obj
                grid[rows][cols] = count;
                count++;
            }
        }
    }

    public Grid(int size) {
        //change to obj
        grid = new int[size][size];
        //will no longer be needed
        int count = 1;
        for (int rows = 0; rows < size; rows++) {
            for (int cols = 0; cols < size; cols++) {
                //= new obj
                grid[rows][cols] = count;
                count++;
            }
        }
    }

    //change to obj
    public int[][] getGrid() {
        return grid;
    }
}
