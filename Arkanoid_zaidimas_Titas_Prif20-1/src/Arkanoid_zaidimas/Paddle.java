package Arkanoid_zaidimas;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Paddle extends Sprite
{
    private int positionX;

    public Paddle()
    {
        loadImage();
        getImageHeightWidth();
        StartPosition();
    }
    private void loadImage()
    {
        var imageIcon = new ImageIcon("src/resources/brick.png");
        image = imageIcon.getImage();
    }    

    void move()
    {
        x = x + positionX;

        if (x <= 0)
        {
            x = 0;
        }
        if (x >= Interface.Width - imageWidth)
        {
            x = Interface.Width - imageWidth;
        }
    }

    void pressedKey(KeyEvent e)
    {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT)
        {
            positionX = -2;
        }
        if (key == KeyEvent.VK_RIGHT)
        {
            positionX = 2;
        }
    }

    void releasedKey(KeyEvent e)
    {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT)
        {
            positionX = 0;
        }
        if (key == KeyEvent.VK_RIGHT)
        {
            positionX = 0;
        }
    }
    private void StartPosition()
    {
        x = Interface.Paddle_X;
        y = Interface.Paddle_Y;
    }
}
