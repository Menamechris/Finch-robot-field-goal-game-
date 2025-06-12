public class ShootingSpaces {
    
    String Diraction;
    double distance;
    double speed;

    public ShootingSpaces(String Diraction, int distance, int speed) {
        this.Diraction = Diraction;
        this.distance = distance;
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public double getSpeed() {
        return speed;
    }

    public String getDiraction {
        return Diraction;
    }
}
