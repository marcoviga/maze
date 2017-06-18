package mazesolver.core;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CellTest {

    @Test
    public void equalityCellTest() {
        Cell one = new Cell(1, 2, null);
        Cell two = new Cell(1, 2, null);
        Cell three = new Cell(1, 3, null);

        Assert.assertTrue(one.equals(two));

        List<Cell> cells = new ArrayList<>();
        cells.add(one);
        Assert.assertTrue(cells.contains(one));
        Assert.assertTrue(cells.contains(two));
        Assert.assertFalse(cells.contains(three));

    }
}
