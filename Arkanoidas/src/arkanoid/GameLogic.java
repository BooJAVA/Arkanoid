package arkanoid;

import java.awt.*;
import java.util.List;

import static arkanoid.Constants.*;

public class GameLogic
{
    public int score = 0;

    private Brick brick;
    private Ball ball;
    private Paddle paddle;

    public GameLogic(Brick bricks, Ball ball, Paddle paddle)
    {
        this.brick = bricks;
        this.ball = ball;
        this.paddle = paddle;
    }

    void initializeBricks(List<Brick> bricks)
    {
        bricks.clear();
        for (int i = 0; i < BRICKS_ROW; i++)
        {
            for (int j = 0; j < BRICKS_COL; j++)
            {
                bricks.add(new Brick((i + 1) * (BRICKS_WIDTH + 3) + 22,(j + 2) * (BRICKS_HEIGHT + 3) + 20));
            }
        }
    }

    public void movePaddleRight()
    {
        if (paddle.getX() >= 590)
        {
            paddle.setX(590);;
        } else
        {
            paddle.setX((int) paddle.getX() + PADDLE_VELOCITY);
        }
    }

    public void movePaddleLeft()
    {
        if (paddle.getX() <= 3)
        {
            paddle.setX(3);
        } else
        {
            paddle.setX((int) paddle.getX() - PADDLE_VELOCITY);
        }
    }

    public void moveBall()
    {
        ball.setX((int) ball.getX() + ball.getxDir());
        ball.setY((int) ball.getY() + ball.getyDir());
        if (ball.getX() < 0)
        {
            ball.invertXDir();
        }
        if (ball.getY() < 0)
        {
            ball.invertYDir();
        }
        if (ball.getX() > 665)
        {
            ball.invertXDir();
        }


        /*if (ball.intersects(paddle))
        {
            ball.invertYDir();
        }*/
    }

    boolean isIntersecting(GameObject objectA, GameObject objectB)
    {
        return objectA.right() > objectB.left() && objectA.left() < objectB.right()
                && objectA.bottom() > objectB.top() && objectA.top() < objectB.bottom();
    }

    void testBallPaddleCollision(Paddle paddle, Ball ball) {
        if (isIntersecting(paddle, ball))
        {
            ball.invertYDir();
        }
    }

    void testBallBrickCollision(Brick bricks, Ball ball)
    {

        if (!isIntersecting(brick, ball))
            return;

            brick.BrickIsDestroyed(true);
            countScore();



            if (ball.right() < brick.left() || ball.left() > brick.right()) {
                ball.invertXDir();
            } else {
                ball.invertYDir();
            }


    }

    /*public void checkCollision()
    {
        for(int i = 0; i < bricks.getMapHeight(); i++)
        {
            for(int j = 0; j < bricks.getMapWidth(); j++)
            {
                if (bricks.getMap()[i][j] > 0)
                {
                    int brickX = j * bricks.getBrickWidth() + 80;
                    int brickY = i * bricks.getBrickHeight() + 50;
                    Rectangle brickRect = new Rectangle(brickX, brickY, bricks.getBrickWidth(), bricks.getBrickHeight());

                    if (ball.intersects(brickRect))
                    {
                        bricks.BrickIsDestroyed(i, j, true);
                        countScore();

                        if (ball.getX() + 19 <= brickRect.x || ball.getX() + 1 >= brickRect.x + bricks.getBrickWidth())
                        {
                            ball.invertXDir();
                        } else {
                            ball.invertYDir();
                        }

                    }
                }
            }
        }
    }
*/
    public void countScore()
    {
        score += 10;
    }

    public boolean isGameOver()
    {
        return ball.getY() > 570;
    }

    public boolean isGameWon()
    {
        return brick.getAmountOfBricks() <= 0;
    }

    public void setScore(int score)
    {
        this.score = score;
    }




}
