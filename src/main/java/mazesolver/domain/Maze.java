package mazesolver.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Maze {

    @NotNull
    private Integer startX;

    @NotNull
    private Integer startY;

    @NotNull
    private char[][] maze;

    public char[][] getMaze() {
        return maze;
    }

    public Integer getStartX() {
        return startX;
    }

    public Integer getStartY() {
        return startY;
    }

    @JsonCreator
    public Maze(@JsonProperty("startX") Integer startX,
                @JsonProperty("startY") Integer startY,
                @JsonProperty("maze") char[][] maze) {
        this.startX = startX;
        this.startY = startY;
        this.maze = maze;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("startX:").append(startX);
        sb.append(", startY:").append(startY);
        sb.append(", maze:").append(Arrays.toString(maze));
        sb.append('}');
        return sb.toString();
    }
}