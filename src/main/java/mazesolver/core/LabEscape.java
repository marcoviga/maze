package mazesolver.core;

import mazesolver.exceptions.NoEscapeException;
import mazesolver.exceptions.NoSolutionFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Please implement your solution here
 */
@Service
public class LabEscape {

    private final static Logger LOGGER = LoggerFactory.getLogger(LabEscape.class);
    private static final char WALL = 'O';
    private static final char FREE = ' ';
    private static final char PATH = '•';

    /**
     * @param maze   A labyrinth drawn on a matrix of characters. It's at least 4x4, can be a rectangle or a square.
     *               Walkable areas are represented with a space character, walls are represented with a big O character.
     *               The escape point is always on the border (see README)
     * @param startX Starting row number for the escape. 0 based.
     * @param startY Starting column number for the escape. 0 based.
     * @return A char matrix with the same maze and a path drawn from the starting point to the escape
     * @throws NoEscapeException when no path exists to the outside, from the selected starting point
     * @throws IllegalArgumentException when the startX and startY position is out of boundaries
     * @throws mazesolver.exceptions.NoSolutionFound when a solution is not found
     */
    public static char[][] drawPathForEscape(final char[][] maze, final int startX, final int startY) throws IllegalArgumentException, NoSolutionFound {

        if (isOutOfMazePosition(maze, startX, startY)) {
            throw new IllegalArgumentException("Wrong position it's out of boundaries");
        }

        if (maze[startX][startY] != FREE) {
            throw new IllegalArgumentException("Wrong Position, position is not empty");
        }

        Optional<Cell> result = getPathToExit(maze, startX, startY);

        Cell cell = result.orElseThrow(() -> new NoSolutionFound("No Solution Found for this maze"));

        maze[cell.x][cell.y] = PATH;
        while (cell.getParent() != null) {
            cell = cell.getParent();
            maze[cell.x][cell.y] = PATH;
        }

        printMaze(maze);
        return maze;
    }

    public static Optional<Cell> getPathToExit(final char[][] maze, final int xStart, final int yStart) {
        Set<Cell> explored = new HashSet<>();
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(xStart, yStart, null));

        while (!queue.isEmpty()) {
            Cell cell = queue.remove();
            int x = cell.x;
            int y = cell.y;

            if (isExit(maze, x, y)) {
                LOGGER.info("found the exit!!! at position x : {} and y : {}", x, y);

                return Optional.of(cell);
            }

            addCell(maze, x + 1, y, queue, explored, cell);
            addCell(maze, x - 1, y, queue, explored,  cell);
            addCell(maze, x, y + 1, queue, explored, cell);
            addCell(maze, x, y - 1, queue, explored, cell);
        }
        return Optional.empty();
    }

    public static void addCell(final char[][] maze, final int x, final int y, Queue<Cell> queue, Set<Cell> explored, final Cell currentCell) {
        Cell newCell = new Cell(x, y, currentCell);
        if (isFreePosition(maze, x, y) && !explored.contains(newCell)) {
            LOGGER.info("new cell discovered {}", newCell.toString());
            queue.add(newCell);
            explored.add(newCell);
        }

    }

    public static boolean isExit(final char[][] maze, final int x, final int y) {
        return x == maze.length - 1 && maze[x][y] == FREE ||
                y == maze[0].length - 1 && maze[x][y] == FREE ||
                x == 0 && maze[x][y] == FREE ||
                y == 0 && maze[x][y] == FREE;
    }

    public static boolean isFreePosition(final char[][] maze, final int x, final int y) {
        return !isOutOfMazePosition(maze, x, y) && maze[x][y] == FREE;
    }

    public static boolean isOutOfMazePosition(final char[][] labryrinth, final int x, final int y) {
        return x >= labryrinth.length || y >= labryrinth[0].length;
    }

    public static boolean validateChars(char[][] maze) {
        for (char[] aMaze : maze) {
            for (int j = 0; j < maze[0].length; j++) {
                char elt = aMaze[j];
                if (!('•' == elt || ' ' == elt || 'O' == elt)) {
                    return false;
                }
            }
        }
        LOGGER.info("this is a valid maze");
        return true;
    }

    public static void printMaze(final char[][] maze) {
        for (char[] aMaze : maze) {
            for (int j = 0; j < maze[0].length; j++) {

                System.out.print(aMaze[j]);
            }
            System.out.println();
        }
        System.out.println();
    }


}

