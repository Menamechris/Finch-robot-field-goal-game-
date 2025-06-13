public class ShootingSpace {
    
    String Diraction;
    double distance;
    double speed;
    double turn;
    int x;
    int y;

    public ShootingSpace(int x, int y) {
        this.Diraction = null;
        this.distance = 0;
        this.speed = 50;
        this.turn = 0;
        this.x = x;
        this.y = y;
        
    }

    public double getDistance() {
        return distance;
    }

    public double getSpeed() {
        return speed;
    }

    
    public double getTurn() {
        return turn;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    public void setDistance(double distance1) {
        distance1 = distance;
    }

    public void setSpeed(double speed1) {
        speed1 = speed;
    }
    
    public void setTurn(double turn1) {
        turn1 = turn;
    }
    
    public void setX(int X1) {
        X1 = x;
    }
    
    public void setY(int Y1) {
        Y1 = y;
    }
}
