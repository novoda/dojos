package com.sandpile;

public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Point point = (Point) o;
        return this.x == point.x && this.y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }

    public Point above() {
        return new Point(x, y - 1);
    }

    public Point below() {
        return new Point(x, y + 1);
    }

    public Point right() {
        return new Point(x + 1, y);
    }

    public Point left() {
        return new Point(x - 1, y);
    }

    public boolean isToTheLeftOf(Point point) {
        return this.x < point.x;
    }

    public boolean isToTheRightOf(Point point) {
        return point.x < this.x;
    }

    public boolean isAbove(Point point) {
        return this.y < point.y;
    }

    public boolean isBelow(Point point) {
        return point.y < this.y;
    }
}
