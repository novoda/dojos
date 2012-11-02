package com.sandpile;

import java.util.HashMap;
import java.util.Map;

public class World implements AvalancheDetector {

    private final AvalancheDetector avalancheDetector;
    private final Map<Point, Cell> cells = new HashMap<Point, Cell>();
    private final WorldEdgesValidator validator;

    public World(AvalancheDetector avalancheDetector, WorldEdgesValidator validator) {
        this.avalancheDetector = avalancheDetector;
        this.validator = validator;
    }

    public void dropGrain(Point point) {
        if (validator.isInsideTheWorld(point)) {
            Cell cell = getCellAt(point);
            cell.dropGrain();
        }
    }

    private Cell getCellAt(Point point) {
        Cell cell = cells.get(point);
        if (cell == null) {
            cell = new Cell(point, this);
            cells.put(point, cell);
        }
        return cell;
    }

    @Override
    public void newAvalanche(Point point) {
        dropGrain(point.above());
        dropGrain(point.left());
        dropGrain(point.below());
        dropGrain(point.right());
        avalancheDetector.newAvalanche(point);
    }

}
