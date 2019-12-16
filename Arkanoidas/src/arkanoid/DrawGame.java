package arkanoid;

import static arkanoid.Constants.*;
import java.awt.*;

public class DrawGame
{
    private Bricks bricks;
    private Ball ball;
    private Paddle paddle;

    public DrawGame(Bricks bricks, Ball ball, Paddle paddle)
    {
        this.bricks = bricks;
        this.ball = ball;
        this.paddle = paddle;
    }

    void drawAllElements(Graphics2D g, int score)
    {
        drawBackground(g);
        drawBorders(g);
        drawScore(g, score);
        drawBall(g);
        drawBricks(g);
        drawPaddle(g);
    }

    void drawBackground (Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(0,0, SCREEN_WIDTH, SCREEN_HEIGHT);
    }

    void drawBorders (Graphics g)
    {
        g.setColor(Color.yellow);
        g.fillRect(0,0,3,SCREEN_HEIGHT - 8);
        g.fillRect(0,0,SCREEN_WIDTH - 8,3);
        g.fillRect(SCREEN_WIDTH - 18,0,3,SCREEN_HEIGHT - 8);
    }

    void drawBall(Graphics g)
    {
        g.setColor(Color.green);
        g.fillOval((int) ball.getX(),(int) ball.getY(), BALL_RADIUS, BALL_RADIUS);
    }

    void drawPaddle (Graphics g)
    {
        g.setColor(Color.green);
        g.fillRect((int) paddle.getX(), PADDLE_Y, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

    void drawBricks(Graphics2D g)
    {
        for (int i = 0; i < bricks.getMapHeight(); i++)
        {
            for (int j = 0; j < bricks.getMapWidth(); j++)
            {
                if (bricks.getMap()[i][j] > 0)
                {
                    g.setColor(Color.white);
                    g.fillRect(j * bricks.getBrickWidth() + BRICKS_WIDTH, i * bricks.getBrickHeight() + BRICKS_HEIGHT, bricks.getBrickWidth(), bricks.getBrickHeight());
                    g.setStroke(new BasicStroke(5));
                    g.setColor(Color.black);
                    g.drawRect(j * bricks.getBrickWidth() + BRICKS_WIDTH, i * bricks.getBrickHeight() + BRICKS_HEIGHT, bricks.getBrickWidth(), bricks.getBrickHeight());
                }
            }
        }
    }

    void drawScore (Graphics g, int score)
    {
        g.setColor(Color.green);
        g.setFont(new Font(FONT, Font.BOLD, 25));
        g.drawString(""+score, 590, 30);
    }

    void drawGameOver (Graphics g, int score)
    {
        g.setColor(Color.red);
        g.setFont(new Font(FONT, Font.BOLD, 30));
        g.drawString("Game over! Score : "+score, 200, 300);
        g.setFont(new Font(FONT, Font.BOLD, 30));
        g.drawString("Press ENTER to play again", 170, 340);
    }

    void drawGameWon (Graphics g, int score)
    {
        g.setColor(Color.red);
        g.setFont(new Font(FONT, Font.BOLD, 30));
        g.drawString("You won! Score : "+score, 200, 300);
        g.setFont(new Font(FONT, Font.BOLD, 30));
        g.drawString("Press ENTER to play again", 170, 340);
    }



}
