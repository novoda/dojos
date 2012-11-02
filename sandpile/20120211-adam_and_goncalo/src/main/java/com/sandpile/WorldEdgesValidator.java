package com.sandpile;

public class WorldEdgesValidator {

    private final Point topLeftCorner;
    private final Point bottomRightCorner;

    public WorldEdgesValidator(Point topLeftCorner, Point bottomRightCorner) {
        this.topLeftCorner = topLeftCorner;
        this.bottomRightCorner = bottomRightCorner;
    }

    public boolean isInsideTheWorld(Point point) {
        return isBeforeTopLeftCorner(point) && isBeforeBottomRightCorner(point);
    }

    private boolean isBeforeBottomRightCorner(Point point) {
        return point.isToTheLeftOf(bottomRightCorner) && point.isAbove(bottomRightCorner);
    }

    private boolean isBeforeTopLeftCorner(Point point) {
        return point.isBelow(topLeftCorner) && point.isToTheRightOf(topLeftCorner);
    }

}
