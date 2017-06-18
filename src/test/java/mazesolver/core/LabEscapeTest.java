package mazesolver.core;

import mazesolver.exceptions.NoSolutionFound;
import org.junit.Test;
import static org.junit.Assert.*;

public class LabEscapeTest {

    private char[][] mazeWithSolution = new char[][]{
            {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
            {'O', ' ', ' ', ' ', ' ', 'O', ' ', ' ', ' ', 'O'},
            {'O', ' ', 'O', 'O', ' ', 'O', ' ', 'O', ' ', 'O'},
            {'O', ' ', ' ', 'O', ' ', 'O', ' ', 'O', ' ', 'O'},
            {'O', ' ', 'O', 'O', ' ', ' ', ' ', 'O', ' ', ' '},
            {'O', ' ', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
            {'O', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}};


    private char[][] mazeWithOutSolution = new char[][]{
            {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
            {'O', ' ', ' ', ' ', ' ', 'O', ' ', ' ', ' ', 'O'},
            {'O', ' ', 'O', 'O', ' ', 'O', ' ', 'O', ' ', 'O'},
            {'O', ' ', ' ', 'O', ' ', 'O', ' ', 'O', ' ', 'O'},
            {'O', ' ', 'O', 'O', ' ', ' ', ' ', 'O', ' ', 'O'},
            {'O', ' ', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
            {'O', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}};

    private char[][] mazeWithError = new char[][]{
            {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
            {'O', ' ', ' ', ' ', ' ', 'O', ' ', ' ', ' ', 'O'},
            {'O', ' ', 'O', 'O', ' ', 'O', ' ', 'O', ' ', 'O'},
            {'O', ' ', ' ', 'X', ' ', 'O', ' ', 'O', ' ', 'O'},
            {'O', ' ', 'O', 'O', ' ', ' ', ' ', 'O', ' ', 'O'},
            {'O', ' ', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
            {'O', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}};


    @Test
    public void validateMaze(){
        assertTrue(LabEscape.validateChars(mazeWithSolution));
        assertFalse(LabEscape.validateChars(mazeWithError));

    }

    @Test
    public void isExitTest() {
        assertFalse(LabEscape.isExit(mazeWithSolution, 1, 1));
        assertTrue(LabEscape.isExit(mazeWithSolution, 4, 9));
        assertFalse(LabEscape.isExit(mazeWithSolution, 3, 9));
    }

    @Test
    public void isOutOfLabyrinthPositionTest() {
        assertFalse(LabEscape.isOutOfMazePosition(mazeWithSolution, 1, 1));
        assertTrue(LabEscape.isOutOfMazePosition(mazeWithSolution, 8, 1));
    }

    @Test
    public void isFreePositionTest() {
        assertTrue(LabEscape.isFreePosition(mazeWithSolution, 1, 1));
        assertFalse(LabEscape.isFreePosition(mazeWithSolution, 0, 0));
    }

    @Test
    public void testLabEscape() throws IllegalArgumentException, NoSolutionFound {
        char[][] result = LabEscape.drawPathForEscape(mazeWithSolution, 3, 1);
        assertEquals(result[4][9], '•');
    }

    @Test(expected = NoSolutionFound.class)
    public void testLabEscapeWithOutSolution() throws IllegalArgumentException, NoSolutionFound {
        LabEscape.drawPathForEscape(mazeWithOutSolution, 3, 1);
    }
}
