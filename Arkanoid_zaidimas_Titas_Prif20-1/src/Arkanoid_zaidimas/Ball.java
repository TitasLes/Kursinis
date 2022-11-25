package Arkanoid_zaidimas;

import javax.swing.ImageIcon;

public class Ball extends Sprite
{
    private int xDirection;
    private int yDirection;

    public Ball()
    {
        xDirection = 1;
        yDirection = -1;
        loadImage();
        getImageHeightWidth();
        StartPos();
    }

    private void loadImage()
    {
        var imageIcon = new ImageIcon("src/resources/ball.png");
        image = imageIcon.getImage();
    }

    void move()
    {
        x =x + xDirection;
        y =y + yDirection;
        if (x == 0)
        {
            setXDirection(1);
        }
        if (y == 0)
        {
            setYDirection(1);
        }
        if (x == Interface.Width - imageWidth)
        {
            setXDirection(-1);
        }

    }

    private void StartPos()
    {
        x = Interface.Ball_X;
        y = Interface.Ball_Y;
    }
    void setXDirection(int x)
    {
        xDirection = x;
    }
    void setYDirection(int y)
    {
        yDirection = y;
    }
}
