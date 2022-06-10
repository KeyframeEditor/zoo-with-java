package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import res.map.*;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    public Tile[] bgArray = new Tile[2];
    public int bgIndex = 0;

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[10];

        getTileImage();
    }

    public void getTileImage(){
        try{
            tile[0] = new Tile();

            bgArray[0] = new Tile();
            bgArray[0].image = ImageIO.read(getClass().getResourceAsStream(Map.grassTest));

            bgArray[1] = new Tile();
            bgArray[1].image = ImageIO.read(getClass().getResourceAsStream(Map.beast));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(bgArray[bgIndex].image, 0,0,768,576,null);
    }
}