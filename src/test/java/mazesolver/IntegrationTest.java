package mazesolver;

import io.restassured.RestAssured;
import mazesolver.domain.Maze;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @LocalServerPort
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void mazeValid() {
        char[][] labyrinth = {
                {'O', 'O', 'O'},
                {'O', ' ', ' '},
                {'O', 'O', 'O'}
        };

        Maze maze = new Maze(1, 1, labyrinth);
        System.out.print(maze.toString());
        given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(maze)
                .when()
                .post("/solve")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void mazeNoSolution() {
        char[][] labyrinth = {
                {'O', 'O', 'O'},
                {'O', ' ', 'O'},
                {'O', 'O', 'O'}
        };

        Maze maze = new Maze(0, 0, labyrinth);
        System.out.print(maze.toString());
        given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(maze)
                .when()
                .post("/solve")
                .then()
                .assertThat()
                .statusCode(400);
    }

    @Test
    public void mazeInvalidChar() {
        char[][] labyrinth = {
                {'O', 'O', 'O'},
                {'O', ' ', 'O'},
                {'O', 'X', 'O'}
        };

        Maze maze = new Maze(0, 0, labyrinth);
        System.out.print(maze.toString());
        given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(maze)
                .when()
                .post("/solve")
                .then()
                .assertThat()
                .statusCode(400);
    }
}
