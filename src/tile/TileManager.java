package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import res.map.*;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    public int[] bgArray = new int[2];
    public int bgIndex = 0;

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[10];

        getTileImage(bgIndex);
    }

    public void getTileImage(int tileIndex){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream(Map.grassTest));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(tile[bgIndex].image, 0,0,768,576,null);
    }
}