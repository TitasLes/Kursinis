package Arkanoid_zaidimas;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class Board extends JPanel
{
    private Timer timer;
    private String message = "Game Over";
    private Ball ball;
    private Paddle paddle;
    private Blocks[] blocks;
    private boolean alive = true;


    public Board()
    {
        addKeyListener(new PaddleController());
        setFocusable(true);
       setPreferredSize(new Dimension(Interface.Width, Interface.Height));
        gameInit();
    }

    private void gameInit() {

        blocks = new Blocks[Interface.NumberOfBlocks];
        ball = new Ball();
        paddle = new Paddle();
        int sk = 0;

        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                blocks[sk] = new Blocks(j * 40 + 80, i * 10 );
                sk++;
            }
        }
        timer = new Timer(Interface.Delay, new GameCycle());
        timer.start();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D draw = (Graphics2D) g;

        if (alive)
        {
            drawObjects(draw);
        } else {

            gameFinished(draw);
        }
    }

    private void drawObjects(Graphics2D draw) {

        draw.drawImage(paddle.getImage(), paddle.getX(), paddle.getY(),
                paddle.getImageWidth(), paddle.getImageHeight(), this);

        draw.drawImage(ball.getImage(), ball.getX(), ball.getY(),
                ball.getImageWidth(), ball.getImageHeight(), this);


        for (int i = 0; i < Interface.NumberOfBlocks; i++)
        {
            if (!blocks[i].isTouched())
            {
                draw.drawImage(blocks[i].getImage(), blocks[i].getX(),
                        blocks[i].getY(), blocks[i].getImageWidth(),
                        blocks[i].getImageHeight(), this);
            }
        }
    }

    private void gameFinished(Graphics2D graphics2D) {

        Font font = new Font("Verdana", Font.BOLD, 20);
        FontMetrics fontMetrics = this.getFontMetrics(font);

        graphics2D.setColor(Color.BLACK);
        graphics2D.setFont(font);
        graphics2D.drawString(message,
                (Interface.Width - fontMetrics.stringWidth(message)) / 2,
                Interface.Height / 2);
    }

    private class PaddleController extends KeyAdapter {

        public void keyReleased(KeyEvent e) {

            paddle.releasedKey(e);
        }

        public void keyPressed(KeyEvent e) {

            paddle.pressedKey(e);
        }
    }

    private class GameCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            doGameCycle();
        }
    }

    private void doGameCycle()
    {
        paddle.move();
        ball.move();
        checkCollision();
        repaint();
    }

    private void stopGame()
    {
        alive = false;
        timer.stop();
    }

    private void checkCollision()
    {
        if (ball.getRectangle().getMaxY() > Interface.BottomEdge)
        {
            stopGame();
        }

        for (int i = 0, j = 0; i < Interface.NumberOfBlocks; i++)
        {
            if (blocks[i].isTouched())
            {
                j++;
            }
            if (j == Interface.NumberOfBlocks)
            {
                message = "You Won!";
                stopGame();
            }
        }
        if ((ball.getRectangle()).intersects(paddle.getRectangle()))
        {
            ball.setYDirection(-1);
        }
        for (int i = 0; i < Interface.NumberOfBlocks; i++)
        {
            if ((ball.getRectangle()).intersects(blocks[i].getRectangle()))
            {
                if (!blocks[i].isTouched())
                {
                    if(ball.getRectangle().getMaxX() > blocks[i].getRectangle().getX())
                    {
                        ball.setXDirection(-1);
                    }
                    if(ball.getRectangle().getMinX() < blocks[i].getRectangle().getX() + blocks[i].getImageWidth())
                    {
                        ball.setXDirection(1);
                    }
                    if(ball.getRectangle().getMaxY() > blocks[i].getRectangle().getCenterY())
                    {
                        ball.setYDirection(1);
                    }
                    if(ball.getRectangle().getMinY() < blocks[i].getRectangle().getY() + blocks[i].getImageHeight())
                    {
                        ball.setYDirection(1);
                    }
                    blocks[i].setTouched(true);

                }
            }
        }
    }
}
