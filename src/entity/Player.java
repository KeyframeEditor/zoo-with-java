package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import res.player.*;

public class Player extends entity{

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 6;
        direction = "down";
    }

    public void getPlayerImage(){
        try {
//            up1 = ImageIO.read(getClass().getResourceAsStream   ("up1.png"));
//            up2 = ImageIO.read(getClass().getResourceAsStream   ("up2.png"));
//            right1 = ImageIO.read(getClass().getResourceAsStream("right1.png"));
//            right2 = ImageIO.read(getClass().getResourceAsStream("right2.png"));
//            left1 = ImageIO.read(getClass().getResourceAsStream ("left1.png"));
//            left2 = ImageIO.read(getClass().getResourceAsStream ("left2.png"));
//            down1 = ImageIO.read(getClass().getResourceAsStream ("down1.png"));
//            down2 = ImageIO.read(getClass().getResourceAsStream ("down2.png"));

            up1 = ImageIO.read(getClass().getResourceAsStream   (playerSprites.up1));
            up2 = ImageIO.read(getClass().getResourceAsStream   (playerSprites.up2));
            right1 = ImageIO.read(getClass().getResourceAsStream(playerSprites.right1));
            right2 = ImageIO.read(getClass().getResourceAsStream(playerSprites.right2));
            left1 = ImageIO.read(getClass().getResourceAsStream (playerSprites.left1));
            left2 = ImageIO.read(getClass().getResourceAsStream (playerSprites.left2));
            down1 = ImageIO.read(getClass().getResourceAsStream (playerSprites.down1));
            down2 = ImageIO.read(getClass().getResourceAsStream (playerSprites.down2));

        }
        catch (IOException e){
            e.printStackTrace();
        }
//        catch (IllegalArgumentException il){
//            System.out.println("illegal argument detected");
//            if (up1 == null){
//                System.out.println("up 1 is null");
//            } else{
//                System.out.println("Not null, theres data");
//            }
//        }
    }

    public void update(){
        direction = "down";
        if (keyH.upPressed || keyH.downPressed || keyH.rightPressed || keyH.leftPressed){
            stepCounter++;
            if (stepCounter > 14){
                if(stepNum == 1){
                    stepNum = 2;
                    gp.playSE(1);
                }else if (stepNum == 2){
                    stepNum = 1;
                    gp.playSE(2);
                }
                stepCounter = 0;
            }

            if(keyH.upPressed && y > gp.borderTop){
                direction = "up";
                y = y - speed;
            }
            else if(keyH.downPressed && y < gp.borderBottom){
                direction = "down";
                y = y + speed;
            }
            else if(keyH.rightPressed && x < gp.borderRight){
                direction = "right";
                x = x + speed;
            }
            else if(keyH.leftPressed && x > gp.borderLeft){
                direction = "left";
                x = x - speed;
            }

            spriteCounter++;
            if (spriteCounter > 10){
                if(spriteNum == 1){
                    spriteNum = 2;
                }else if (spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2){
//        g2.setColor(Color.white);
//        g2.fillRect(x,y,gp.tileSize,gp.tileSize);

        BufferedImage image = null;

        switch (direction){
            case "up":
                if(spriteNum == 1);
        }

        if (direction == "up") {
            if (spriteNum == 1){
                image = up1;
            }if (spriteNum == 2){
                image = up2;
            }
        }else if (direction == "down") {
            if (spriteNum == 1){
                image = down1;
            }if (spriteNum == 2){
                image = down2;
            }
        }else if (direction == "right") {
            if (spriteNum == 1){
                image = right1;
            }if (spriteNum == 2){
                image = right2;
            }
        }else if (direction == "left") {
            if (spriteNum == 1){
                image = left1;
            }if (spriteNum == 2){
                image = left2;
            }
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}