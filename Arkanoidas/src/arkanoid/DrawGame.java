package arkanoid;

import static arkanoid.Constants.*;
import java.awt.*;
import java.util.List;

public class DrawGame
{

    public DrawGame(List<Brick> bricks, Ball ball, Paddle paddle)
    {

    }

    void drawAllElements(Graphics2D g, int score)
    {
        drawBackground(g);
        drawBorders(g);
        drawScore(g, score);
        drawBall(g);
        drawBrick(g);
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

    void drawBrick(Graphics2D g)
    {

        brick.drawBrick(g);

    }
    void drawBricks(List<Brick> bricklist, Graphics g)
    {
        for (Brick bricks : bricklist)
        {
            bricks.drawBrick(g);
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
