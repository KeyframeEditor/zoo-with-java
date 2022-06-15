package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import res.icon.*;
import res.icon.Icon;
import res.player.playerSprites;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Educational Zoo Tour");
        ImageIcon img = new ImageIcon("src/res/icon/icon.png");
        window.setIconImage(img.getImage());

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
        gamePanel.setupGame();
    }
}
