package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest));
        }
        Cell[] steps = null;
        if (source.x < dest.x && source.y < dest.y) {
            int size = dest.x - source.x;
            steps = new Cell[size];
            for (int index = 0; index < size; index++) {
                steps[index] = Cell.findBy(source.x + index + 1, source.y + index + 1);
            }
        } else if (source.x > dest.x && source.y > dest.y) {
            int size = source.x - dest.x;
            steps = new Cell[size];
            for (int index = 0; index < size; index++) {
                steps[index] = Cell.findBy(source.x - index - 1, source.y - index - 1);
            }
        } else if (dest.x < source.x && dest.y > source.y) {
            int size = source.x - dest.x;
            steps = new Cell[size];
            for (int index = 0; index < size; index++) {
                steps[index] = Cell.findBy(source.x - index - 1, source.y + index + 1);
            }
        } else if (dest.x > source.x && dest.y < source.y) {
            int size = dest.x - source.x;
            steps = new Cell[size];
            for (int index = 0; index < size; index++) {
                steps[index] = Cell.findBy(source.x + index + 1, source.y - index - 1);
            }
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        if (dest.x - source.x == dest.y - source.y)
            return true;
        else if (-dest.x + source.x == dest.y - source.y)
            return true;
        else
            return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
