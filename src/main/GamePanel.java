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

    // game border used in player class
    public int borderTop = 7;
    public int borderBottom = 523;
    public int borderLeft = 1;
    public int borderRight = 718;

    // is player is on the right spot?
    public boolean playerOnPosition = false;

    // display UI rules
    public boolean displayUI = false;

    // system
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Sound sound = new Sound();
    UI ui = new UI(this);
    Thread gameThread;

    // entity and object
    Player player = new Player(this,keyH);

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
            // check player coordinate
//            System.out.println("player x: "+player.x+" ,player y: "+player.y);

            // set of game rules
            displayUI = false;
            tileM.bgIndex = 0;

            if (player.x >= 700 && player.x <= 718 && player.y >= 4 && player.y <= 16){
                while(true){
                    tileM.bgIndex = 1;
                    playSE(4);
                    try {
                        Thread.sleep(5000);
                        player.x = 22;
                        player.y = 64;
                        break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

                //antelope saiga UI & Sound
            if (player.x >= 60 && player.x <= 70 && player.y >= 40 && player.y <= 142){
                ui.displayUI(1);
                playerOnPosition = true;
                if (keyH.interactPressed){
                    playAnimal("Antelope Saiga");
                    keyH.interactPressed = false;
                }
            }else{
                playerOnPosition = false;
            }

                //Rheas bird UI & Sound
            if (player.x >= 60 && player.x <= 70 && player.y >= 184 && player.y <= 256){
                ui.displayUI(2);
                playerOnPosition = true;
                if (keyH.interactPressed){
                    playAnimal("Rheas");
                    keyH.interactPressed = false;
                }
            }else{
                playerOnPosition = false;
            }

                //Wombat UI & Sound
            if (player.x >= 60 && player.x <= 70 && player.y >= 334 && player.y <= 412){
                ui.displayUI(3);
                playerOnPosition = true;
                if (keyH.interactPressed){
                    playAnimal("Wombat");
                    keyH.interactPressed = false;
                }
            }else{
                playerOnPosition = false;
            }

                //Red Panda UI & Sound
            if (player.x >= 406 && player.x <= 418 && player.y >= 148 && player.y <= 238){
                ui.displayUI(0);
                playerOnPosition = true;
                if (keyH.interactPressed){
                    playAnimal("Red Panda");
                    keyH.interactPressed = false;
                }
            }else{
                playerOnPosition = false;
            }

                //Shoebill UI & Sound
            if (player.x >= 406 && player.x <= 418 && player.y >= 280 && player.y <= 376){
                ui.displayUI(4);
                playerOnPosition = true;
                if (keyH.interactPressed){
                    playAnimal("Shoebill");
                    keyH.interactPressed = false;
                }
            }else{
                playerOnPosition = false;
            }

                //Okapi Johnstoni UI & Sound
            if (player.x >= 406 && player.x <= 418 && player.y >= 424 && player.y <= 520){
                ui.displayUI(5);
                playerOnPosition = true;
                if (keyH.interactPressed){
                    playAnimal("Okapi Johnstoni");
                    keyH.interactPressed = false;
                }
            }else{
                playerOnPosition = false;
            }

            //exit rule
            if (player.x >= 640 && player.x <= 718 && player.y >= 484 && player.y <= 526){
                System.exit(0);
            }

            //Game fps rule
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
        if (displayUI){
            ui.draw(g2);
        }
        g2.dispose();
    }

    //Sound method
    public void playMusic(int i){
        sound.setFile(String.valueOf(i));
        sound.play();
        sound.loop();
    }
    public void stopMusic(){
        sound.stop();
    }
    public void playSE(int i){
        sound.setFile(String.valueOf(i));
        sound.play();
    }
    public void playAnimal(String name){
        sound.setFile(String.valueOf(name));
        sound.play();
    }
}