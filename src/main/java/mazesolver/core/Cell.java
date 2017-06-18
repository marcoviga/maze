package mazesolver.core;

public class Cell {
    int x;
    int y;
    Cell parent;

    public Cell(int x, int y, Cell parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    Cell getParent() {
        return this.parent;
    }

    public String toString() {
        return "x : " + x + " y : " + y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return x == cell.x && y == cell.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

}