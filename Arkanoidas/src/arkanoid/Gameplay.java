package arkanoid;

import static arkanoid.Constants.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Gameplay extends JPanel implements KeyListener, ActionListener
{
    private boolean play = false;
    private Timer timer;

    private List<Brick> bricks = new ArrayList<arkanoid.Brick>();
    /*private Bricks bricks = new Bricks (50,50);*/
    private Ball ball = new Ball(SCREEN_WIDTH / 2 - BALL_RADIUS / 2, SCREEN_HEIGHT - 80);
    private Paddle paddle = new Paddle(SCREEN_WIDTH / 2 - PADDLE_WIDTH / 2);
    private DrawGame drawGame = new DrawGame(bricks, ball, paddle);
    private GameLogic gameLogic = new GameLogic(bricks, ball, paddle);

    public Gameplay()
    {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(BALL_VELOCITY, this);
        timer.start();
    }



    @Override
    public void paint(Graphics g)
    {
        drawGame.drawAllElements((Graphics2D)g, gameLogic.score);

        if (gameLogic.isGameOver())
        {
            play = false;
            drawGame.drawGameOver(g,gameLogic.score);
        }

        if (gameLogic.isGameWon())
        {
            play = false;
            drawGame.drawGameWon(g,gameLogic.score);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (play)
        {
            gameLogic.initializeBricks(bricks);
            gameLogic.moveBall();
            gameLogic.testBallPaddleCollision(paddle, ball);
            gameLogic.testBallBrickCollision(bricks, ball);
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }
    @Override
    public void keyReleased(KeyEvent e)
    {

    }
    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            play = true;
            gameLogic.movePaddleRight();


        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            play = true;
            gameLogic.movePaddleLeft();
        }

        /*if (e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            if (!play)
            {
                play = true;
                ball.setX(SCREEN_WIDTH / 2 - BALL_RADIUS / 2);
                ball.setY(SCREEN_HEIGHT - 80);
                ball.setyDir(-1);
                paddle.setX(SCREEN_WIDTH / 2 - PADDLE_WIDTH / 2);
                gameLogic.setScore(0);
                bricks.setAmountOfBricks(BRICKS_ROW * BRICKS_COL);
                for (int i = 0; i < bricks.getMapHeight(); i++)
                {
                    for (int j = 0; j < bricks.getMapWidth(); j++)
                    {
                        bricks.getMap()[i][j] = 1;
                    }
                }
            }
        }*/

    }
}

