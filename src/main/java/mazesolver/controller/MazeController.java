package mazesolver.controller;

import mazesolver.core.LabEscape;
import mazesolver.domain.Maze;
import mazesolver.exceptions.NoEscapeException;
import mazesolver.exceptions.NoSolutionFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MazeController {

    @PostMapping("/solve")
    public ResponseEntity<?> solveMaze(@Valid @RequestBody Maze maze) throws NoEscapeException, NoSolutionFound {

        char[][] solution = LabEscape.drawPathForEscape(maze.getMaze(), maze.getStartX(), maze.getStartY());
        return new ResponseEntity<>(solution, HttpStatus.OK);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map handleException(Exception ex) {

        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return error;
    }

}
