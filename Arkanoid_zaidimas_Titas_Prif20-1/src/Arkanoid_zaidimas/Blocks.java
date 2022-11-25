package Arkanoid_zaidimas;

import javax.swing.ImageIcon;
public class Blocks extends Sprite
{
    private boolean isTouched;
    public Blocks(int x, int y)
    {
        initBrick(x, y);
    }
    
  private void initBrick(int x, int y)
    {
        this.x = x;
        this.y = y;
        isTouched = false;
        loadImage();
        getImageHeightWidth();
    }
    private void loadImage()
    {
        var imageIcon = new ImageIcon("src/resources/brick.png");
        image = imageIcon.getImage();
    }

    boolean isTouched()
    {
        return isTouched;
    }
    void setTouched(boolean val)
    {
        isTouched = val;
    }
}
