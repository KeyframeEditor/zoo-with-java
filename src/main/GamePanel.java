package main;

import entity.Player;
import tile.TileManager;


import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    // SCREEN SETTINGS
    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    // Screen FPS
    int FPS = 60;

    // move amount counter
    static long moveCounter = 0;

    // game border
    public int borderTop = 7;
    public int borderBottom = 523;
    public int borderLeft = 1;
    public int borderRight = 718;

    // system
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Sound sound = new Sound();
    Thread gameThread;

    // entity and object
    Player player = new Player(this,keyH);


    //player default position and rules
//    int playerX = 100;
//    int playerY = 100;
//    int playerSpeed = 10;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame(){
        playMusic(0);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        long drawTiming = 1000/FPS;
        while (gameThread != null){

            // 1. Update information on character position
            update();
            // 2. Draw the screen with the updated information
            repaint();

            // set of game rules
            if (player.x > 400 && player.x < 700 && player.y > 300 && player.y < 500){
//                System.out.println("player is around 400-700");
                if (keyH.interactPressed){
                    playSE(3);
                    keyH.interactPressed = false;
                }
            }

            try {
                Thread.sleep(drawTiming);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(){
        player.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileM.draw(g2);
        player.draw(g2);
        g2.dispose();
    }
    public void playMusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();
    }
    public void stopMusic(){
        sound.stop();
    }
    public void playSE(int i){
        sound.setFile(i);
        sound.play();
    }
}