package exercise;

// BEGIN
public class Segment {
    Point startPoint;
    Point endPoint;

    public Segment(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
    public Point getBeginPoint() {
        return startPoint;
    }
    public Point getEndPoint() {
        return endPoint;
    }
    public Point getMidPoint() {
        return new Point((startPoint.getX() + endPoint.getX()) / 2,(startPoint.getY() + endPoint.getY()) / 2);
    }
}

// END
