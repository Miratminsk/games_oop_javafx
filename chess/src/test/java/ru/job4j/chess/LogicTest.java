package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void WhenMoveThanTrue() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = logic.move(Cell.C1, Cell.H6);
        assertThat(rsl, is(true));
    }

    @Test(expected = IllegalStateException.class)
    public void WhenMoveThanFalse() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.G6);
    }
}