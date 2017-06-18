package mazesolver.domain;

import mazesolver.core.LabEscape;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MazeRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Maze.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Maze maze = (Maze) target;

        if (!LabEscape.validateChars(maze.getMaze())) {
            errors.reject("Char error in the maze");
        }
    }
}
