import java.util.*;

public class Grid {
    //change to obj
    private ShootingSpace[][] grid;
    
    public Grid() {

        grid = new ShootingSpace[10][10];
        //grid information
        
        final int SQUARE_SIZE = 10;    // Each square is 10 cm by 10 cm
        final int GRID_COUNT = 10;     // 10 squares per row/column
        final int GRID_LENGTH = SQUARE_SIZE * GRID_COUNT;  // 100 cm total grid length
        double robotX = GRID_LENGTH / 2.0;
        double robotY = GRID_LENGTH / 2.0;
        for (int rows = 0; rows < 10; rows++) {
            for (int cols = 0; cols < 10; cols++) {
            	grid[rows][cols] = new ShootingSpace(rows, cols);
		        // Calculate the center coordinates of the target square
		        double targetX = (grid[rows][cols].getX() + 0.5) * SQUARE_SIZE;
		        double targetY = (grid[rows][cols].getY() + 0.5) * SQUARE_SIZE;
		
		        // Compute differences in x and y from the robot to the target square
		        double deltaX = targetX - robotX;
		        double deltaY = targetY - robotY;
		
		        // Calculate the Euclidean distance using the Pythagorean theorem
		        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
		        grid[rows][cols].setDistance(distance);
		        // Calculate the angle to the target using atan2 (returns the angle in radians)
		        double angleRadians = Math.atan2(deltaY, deltaX);
		        // Optionally, convert the angle to degrees for easier interpretation
		        double angleDegrees = Math.toDegrees(angleRadians);
		        grid[rows][cols].setTurn(angleDegrees);
            }
        }
    }

    public Grid(int size) {
	    grid = new ShootingSpace[size][size];
	    //grid information
	    
	    final int SQUARE_SIZE = size;    // Each square is 10 cm by 10 cm
	    final int GRID_COUNT = size;     // 10 squares per row/column
	    final int GRID_LENGTH = SQUARE_SIZE * GRID_COUNT;  // 100 cm total grid length
	    double robotX = GRID_LENGTH / 2.0;
	    double robotY = GRID_LENGTH / 2.0;
	    for (int rows = 0; rows < 10; rows++) {
	        for (int cols = 0; cols < 10; cols++) {
	        	grid[rows][cols] = new ShootingSpace(rows, cols);
		        // Calculate the center coordinates of the target square
		        double targetX = (grid[rows][cols].getX() + 0.5) * SQUARE_SIZE;
		        double targetY = (grid[rows][cols].getY() + 0.5) * SQUARE_SIZE;
		
		        // Compute differences in x and y from the robot to the target square
		        double deltaX = targetX - robotX;
		        double deltaY = targetY - robotY;
		
		        // Calculate the Euclidean distance using the Pythagorean theorem
		        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
		        grid[rows][cols].setDistance(distance);
		        // Calculate the angle to the target using atan2 (returns the angle in radians)
		        double angleRadians = Math.atan2(deltaY, deltaX);
		        // Optionally, convert the angle to degrees for easier interpretation
		        double angleDegrees = Math.toDegrees(angleRadians);
		        grid[rows][cols].setTurn(angleDegrees);
	        }
	    }
	}

    //change to obj
    public ShootingSpace[][] getGrid() {
        return grid;
    }
}

