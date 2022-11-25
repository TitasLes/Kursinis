package Arkanoid_zaidimas;

import java.awt.Image;
import java.awt.Rectangle;

public class Sprite
{
    int x;
    int y;
    int imageHeight;
    int imageWidth;
    Image image;
    int getX()
    {
        return x;
    }
    protected void setY(int y)
    {
        this.y = y;
    }
    int getY()
    {
        return y;
    }
    int getImageHeight()
    {
        return imageHeight;
    }
    int getImageWidth()
    {
        return imageWidth;
    }
    Image getImage()
    {
        return image;
    }
    Rectangle getRectangle()
    {
        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }
    void getImageHeightWidth()
    {
        imageHeight = image.getHeight(null);
        imageWidth = image.getWidth(null);
    }
}
