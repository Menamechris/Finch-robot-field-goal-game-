
import java.util.Scanner;

public class PlayGrid {
    // Define the dimensions of our simulated grid
    public static final int GRID_ROWS = 10;
    public static final int GRID_COLS = 10;
    public static final int MID_ROW = GRID_ROWS / 2;
    public static final int MID_COL = GRID_COLS / 2;
    
    // Simulated position on the grid
    private int pointRow;
    private int pointCol;
    
    // Finch robot object
    private Finch f;
    
    // Parameters for moving a single grid cell (adjust these as needed)
    private static final int MOVE_DURATION = 1000; // milliseconds for forward/backward movement
    private static final int TURN_DURATION = 500;    // milliseconds for turning
    private static final int SPEED = 150;            // speed value
    
    public PlayGrid() {
        f = new Finch();
        resetPoint();
    }
    
    // Resets the simulated point to the center and signals the action.
    public void resetPoint() {
        pointRow = MID_ROW;
        pointCol = MID_COL;

    }
    
    // Moves the simulated point based on the provided direction.
    public void movePoint(String direction) {
        int newRow = pointRow;
        int newCol = pointCol;
        
        switch(direction.toLowerCase()){
            case "up":
                newRow--;
                break;
            case "down":
                newRow++;
                break;
            case "left":
                newCol--;
                break;
            case "right":
                newCol++;
                break;
            default:
                System.out.println("Invalid direction. Use up, down, left, or right.");
                return;
        }
        
        // Check whether the new position is within the safe area (the inner grid).
        if(newRow > 0 && newRow < GRID_ROWS - 1 && newCol > 0 && newCol < GRID_COLS - 1) {
            // If valid, update the internal coordinates and move the Finch.
            pointRow = newRow;
            pointCol = newCol;
            driveRobot(direction);
        } else {
            // If the move would hit a virtual wall, signal and reset.
            System.out.println("You've hit the wall! Resetting to the middle of the grid.");
            // Alternative signaling method: you might have a buzz or LED alert on your Finch
            resetPoint();
        }
    }
    
    // Moves the Finch physically corresponding to one step in the grid.
    public void driveRobot(String direction) {
        try {
            switch(direction.toLowerCase()){
                case "up":  
                    // Move forward
                    f.setMotors(SPEED, SPEED);
                    Thread.sleep(MOVE_DURATION);
                    f.stop();
                    break;
                case "down":  
                    // Move backward
                	f.setMotors(-SPEED, -SPEED);
                    Thread.sleep(MOVE_DURATION);
                    f.stop();
                    break;
                case "left":
                    // Turn left then move forward
                    f.setMotors(-SPEED, SPEED);
                    Thread.sleep(TURN_DURATION);
                    f.setMotors(SPEED, SPEED);
                    Thread.sleep(MOVE_DURATION);
                    f.stop();
                    break;
                case "right":
                    // Turn right then move forward
                    f.setMotors(SPEED, -SPEED);
                    Thread.sleep(TURN_DURATION);
                    f.setMotors(SPEED, SPEED);
                    Thread.sleep(MOVE_DURATION);
                    f.stop();
                    break;
                default:
                    System.out.println("Unknown direction command.");
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        PlayGrid gridSim = new PlayGrid();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Control the Finch by entering: up, down, left, or right (type exit to quit).");
        
        while(true) {
            System.out.print("Enter a direction: ");
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("exit")) {
                break;
            }
            gridSim.movePoint(input);
        }
        

        PlayGrid.gridSim.stopWheels();
        PlayGrid.gridSim.quit();
        scanner.close();
        System.out.println("Goodbye!");
    }
}
