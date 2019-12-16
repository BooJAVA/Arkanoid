package arkanoid;

import static arkanoid.Constants.*;

public class GameLogic
{
    public int score = 0;

    private Bricks bricks;
    private Ball ball;
    private Paddle paddle;

    public GameLogic(Bricks bricks, Ball ball, Paddle paddle)
    {
        this.bricks = bricks;
        this.ball = ball;
        this.paddle = paddle;
    }

    public void movePaddleRight()
    {
        if (paddle.right() >= SCREEN_WIDTH - PADDLE_VELOCITY)
        {
            paddle.setX(SCREEN_WIDTH - PADDLE_WIDTH);
        }
        if (paddle.right() < SCREEN_WIDTH)
        {
            paddle.setX(paddle.getX() + PADDLE_VELOCITY);
        }
    }

    public void movePaddleLeft()
    {
        if (paddle.left() <= PADDLE_VELOCITY)
        {
            paddle.setX(0);
        }
        if (paddle.left() > PADDLE_VELOCITY)
        {
            paddle.setX(paddle.getX() - PADDLE_VELOCITY);
        }
    }

    public void moveBall()
    {
        if (ball.getX() <= 0)
        {
            ball.invertXDir();
        }
        if (ball.getY() <= 0)
        {
            ball.invertYDir();
        }
        if (ball.getX() >= SCREEN_WIDTH - BALL_RADIUS)
        {
            ball.invertXDir();
        }
        ball.setX((int) ball.getX() + ball.getxDir());
        ball.setY((int) ball.getY() + ball.getyDir());
    }

    boolean isIntersecting(GameObject objectA, GameObject objectB)
    {
        return objectA.right() >= objectB.left() && objectA.left() <= objectB.right()
                && objectA.bottom() >= objectB.top() && objectA.top() <= objectB.bottom();
    }



    void checkBallPaddleCollision(Paddle paddle, Ball ball) {
        if (isIntersecting(paddle, ball))
        {
            ball.invertYDir();
        }
    }

    public void checkBallBrickCollision() {
        for (int i = 0; i < bricks.getMapHeight(); i++) {
            for (int j = 0; j < bricks.getMapWidth(); j++) {
                if (brickExists(i, j))
                {
                    checkCollision(i, j);
                }
            }
        }
    }

    public void checkCollision(int row, int col)
    {
        int brickX = col * BRICKS_WIDTH + BRICKS_WIDTH;
        int brickY = row * BRICKS_HEIGHT + BRICKS_HEIGHT;

        boolean ballCollideRight = ball.getX() + BALL_RADIUS >= brickX;
        boolean ballCollideLeft = ball.getX() + BALL_RADIUS <= brickX + BRICKS_WIDTH + 15;
        boolean ballCollideTop =  ball.getY() + BALL_RADIUS >= brickY;
        boolean ballCollideBottom = ball.getY() + BALL_RADIUS <= brickY + BRICKS_HEIGHT + 15;

        if (ballCollideRight && ballCollideLeft && ballCollideTop && ballCollideBottom)
        {
            bricks.BrickIsDestroyed(row, col, true);
            invertBallAfterCollision(row, col);
            countScore();
        }

    }

    public void invertBallAfterCollision(int row, int col)
    {
        int brickX = col * BRICKS_WIDTH + BRICKS_WIDTH;
        int brickY = row * BRICKS_HEIGHT + BRICKS_HEIGHT;
        if (ball.getX() + BALL_RADIUS <= brickX || ball.getX() >= brickX + BRICKS_WIDTH)
        {
            ball.invertXDir();
        } else {
            ball.invertYDir();
        }
    }
    public boolean brickExists(int row, int col)
    {
        return bricks.getMap()[row][col] == 1;
    }

    public void countScore()
    {
        score += 10;
    }

    public boolean isGameOver()
    {
        return ball.getY() > SCREEN_HEIGHT - BALL_RADIUS;
    }

    public boolean isGameWon()
    {
        return bricks.getAmountOfBricks() <= 0;
    }

    public void setScore(int score)
    {
        this.score = score;
    }




}
