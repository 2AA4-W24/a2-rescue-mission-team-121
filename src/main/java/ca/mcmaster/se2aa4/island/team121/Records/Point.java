package ca.mcmaster.se2aa4.island.team121.Records;

public record Point(int x, int y) {
    public Double getDistance(Point other) {
        return Math.sqrt(Math.pow(this.x() - other.x(), 2) + Math.pow(this.y() - other.y(), 2));
    }
}
