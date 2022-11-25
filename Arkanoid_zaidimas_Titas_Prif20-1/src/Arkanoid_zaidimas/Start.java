package Arkanoid_zaidimas;

import javax.swing.JFrame;
public class Start extends JFrame
{
    public Start()
    {
        add(new Board());
        setTitle("Arkanoid");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        pack();

    }

    public static void main(String[] args)
    {
        Start game = new Start();
        game.setVisible(true);
    }
}
