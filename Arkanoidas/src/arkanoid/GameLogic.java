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

    private boolean isIntersecting(GameObject objectA, GameObject objectB)
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
                    int brickX = j * BRICKS_WIDTH + BRICKS_WIDTH;
                    int brickY = i * BRICKS_HEIGHT + BRICKS_HEIGHT;
                    checkCollision(i, j, brickX, brickY);
                }
            }
        }
    }

    private boolean brickExists(int row, int col)
    {
        return bricks.getMap()[row][col] == 1;
    }

    private void checkCollision(int row, int col, int brickX, int brickY)
    {
        boolean overlapRight = ball.getX() + BALL_RADIUS >= brickX;
        boolean overlapLeft = ball.getX() + BALL_RADIUS <= brickX + BRICKS_WIDTH + 15;
        boolean overlapTop =  ball.getY() + BALL_RADIUS >= brickY;
        boolean overlapBottom = ball.getY() + BALL_RADIUS <= brickY + BRICKS_HEIGHT + 15;

        if (overlapRight && overlapLeft && overlapTop && overlapBottom)
        {
            bricks.BrickIsDestroyed(row, col, true);
            invertBallAfterCollision(row, col, brickX, brickY);
            countScore();
        }

    }

    private void invertBallAfterCollision(int row, int col, int brickX, int brickY)
    {
        boolean collideRight = ball.getX() + BALL_RADIUS <= brickX;
        boolean collideLeft = ball.getX() + BALL_RADIUS >= brickX + BRICKS_WIDTH + 15;
        if (collideRight || collideLeft)
        {
            ball.invertXDir();
        } else {
            ball.invertYDir();
        }
    }

    private void countScore()
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
