package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell expected = bishopBlack.position();
        assertThat(expected, is(Cell.C1));
    }

    @Test
    public void wayXPlusYPlus() {
        BishopBlack bishopBlack = new BishopBlack(Cell.G5);
        Cell[] out = bishopBlack.way(Cell.G5, Cell.C1);
        Cell[] expected = new Cell[]{Cell.F4, Cell.E3, Cell.D2, Cell.C1};
        assertThat(expected, is(out));
    }

    @Test
    public void wayXMinusYMinus() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] out = bishopBlack.way(Cell.C1, Cell.G5);
        Cell[] expected = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(expected, is(out));
    }

    @Test
    public void wayXPlusYMinus() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A7);
        Cell[] out = bishopBlack.way(Cell.A7, Cell.G1);
        Cell[] expected = new Cell[]{Cell.B6, Cell.C5, Cell.D4, Cell.E3, Cell.F2, Cell.G1};
        assertThat(expected, is(out));
    }

    @Test
    public void wayXMinusYPlus() {
        BishopBlack bishopBlack = new BishopBlack(Cell.G1);
        Cell[] out = bishopBlack.way(Cell.G1, Cell.A7);
        Cell[] expected = new Cell[]{Cell.F2, Cell.E3, Cell.D4, Cell.C5, Cell.B6, Cell.A7};
        assertThat(expected, is(out));
    }

    @Test(expected = IllegalStateException.class)
    public void isDiagonalOne() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        bishopBlack.way(Cell.A1, Cell.G8);
    }

    @Test(expected = IllegalStateException.class)
    public void isDiagonalTwo() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D2);
        bishopBlack.way(Cell.D2, Cell.E2);
    }

    @Test
    public void copy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Figure figure = bishopBlack.copy(Cell.E3);
        Cell expected = figure.position();
        assertThat(expected, is(Cell.E3));
    }

}