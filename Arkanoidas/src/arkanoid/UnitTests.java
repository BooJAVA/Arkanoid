package arkanoid;

import static arkanoid.Constants.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class UnitTests
{
    private Bricks bricks = new Bricks(BRICKS_ROW, BRICKS_COL);
    private Ball ball = new Ball(SCREEN_WIDTH / 2 - BALL_RADIUS / 2, SCREEN_HEIGHT - 80);
    private Paddle paddle = new Paddle(SCREEN_WIDTH / 2 - PADDLE_WIDTH / 2);
    private GameLogic gameLogic = new GameLogic(bricks, ball, paddle);

    @Test
    public void testPaddleMovement() {
        //Paddle shouldn't be able to move out of the left side of the screen
        paddle.setX(1);
        gameLogic.movePaddleLeft();
        assertEquals(0, paddle.getX());

        //Paddle shouldn't be able to move out of the right side of the screen
        paddle.setX(SCREEN_WIDTH - PADDLE_WIDTH - 1);
        gameLogic.movePaddleRight();
        assertEquals(SCREEN_WIDTH - PADDLE_WIDTH,paddle.getX());
    }

    @Test
    public void testIsGameOver()
    {
        //New game shouldn't be over
        assertFalse(gameLogic.isGameOver());

        //Ball below the screen should result in game over
        ball.setY(SCREEN_HEIGHT - BALL_RADIUS + 1);
        assertTrue(gameLogic.isGameOver());

        //Ball above bottom of the screen shouldn't result in game over
        ball.setY(SCREEN_HEIGHT - BALL_RADIUS - 1);
        assertFalse(gameLogic.isGameOver());
    }

    @Test
    public void testIsGameWon()
    {
        //New game shouldn't be won
        assertFalse(gameLogic.isGameWon());

        //Destroying all the bricks should result in a victory
        for (int i = 0; i < bricks.getMapHeight(); i++) {
            for (int j = 0; j < bricks.getMapWidth(); j++) {
                bricks.BrickIsDestroyed(i, j, true);
            }
        }
        assertTrue(gameLogic.isGameWon());

        //Destroying not all the bricks shouldn't result in a victory
        for (int i = 1; i < bricks.getMapHeight(); i++) {
            for (int j = 1; j < bricks.getMapWidth(); j++) {
                bricks.BrickIsDestroyed(i, j, true);
            }
        }
        assertTrue(gameLogic.isGameWon());
    }

    @Test
    public void testBallDirection() {
        //Ball should bounce from the left side of the screen
        ball.setX(0);
        gameLogic.moveBall();
        assertEquals(1, (int) ball.getX());

        //Ball should bounce from the top of the screen
        ball.setY(0);
        gameLogic.moveBall();
        assertEquals(1, (int) ball.getY());

        //Ball should bounce from the right side of the screen
        ball.setX(SCREEN_WIDTH - BALL_RADIUS);
        gameLogic.moveBall();
        assertEquals(SCREEN_WIDTH - BALL_RADIUS - 1, (int) ball.getX());

        //Ball should bounce from the paddle
        ball.setX(paddle.top());
        gameLogic.moveBall();
        assertEquals((int)paddle.top() - 1, (int) ball.getX());
    }
}