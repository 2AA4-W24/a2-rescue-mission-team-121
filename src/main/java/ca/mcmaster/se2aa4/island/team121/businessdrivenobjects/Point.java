package ca.mcmaster.se2aa4.island.team121.businessdrivenobjects;

public record Point(double x, double y) {
    public double getDistance(Point other) {
        return Math.sqrt(Math.pow(this.x() - other.x(), 2) + Math.pow(this.y() - other.y(), 2));
    }
}
