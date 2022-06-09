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

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
        gamePanel.setupGame();

//        File asset_up1 = new File("src/res/player/down1.png");
//        System.out.println(asset_up1.exists());

//        File asset_up1 = new File("C://poop_java_assets/up1.png");
//        System.out.println("There is a file: "+asset_up1.exists());
    }
}
