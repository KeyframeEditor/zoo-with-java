package main;

import java.awt.*;

public class UI {
    GamePanel gp;
    Font arial_40;
    Font arial_20;
    Font arial_20_bold;


    public String[] animalNames = new String[6];
    public String[] animalDesc = new String[6];
    private Graphics2D g2;

    public void animalTitle(){
        animalNames[0] = "Red Panda";
        animalNames[1] = "Antelope Saiga";
        animalNames[2] = "Rheas";
        animalNames[3] = "Wombat";
        animalNames[4] = "Shoebill";
        animalNames[5] = "Okapi Johnstoni";
    }

    public void animalDesc(){
        animalDesc[0] = "A small mammal native to the eastern Himalayas and southwestern\nChina. It has dense reddish-brown fur with a black belly and legs, \nwhite-lined ears,a mostly white muzzle and a ringed tail.";
        animalDesc[1] = "A critically endangered antelope which during antiquity inhabited\na vast area of the Eurasian steppe.";
        animalDesc[2] = "A large ratites in the order Rheiformes, native to South America,\ndistantly related to the ostrich and emu.";
        animalDesc[3] = "Short-legged, muscular quadrupedal marsupials that are native to\nAustralia. They are about 1 m (40 in) in length with small, stubby\ntails and weigh between 20 and 35 kg";
        animalDesc[4] = "A very large stork-like bird. It derives its name from its enormous\nshoe-shaped bill. It has a somewhat stork-like overall form";
        animalDesc[5] = "An artiodactyl mammal that is endemic to the northeast Democratic\nRepublic of the Congo in central Africa.";
    }

    public int animalIndex = 0;

    public void displayUI(int index){
        animalIndex = index;
        gp.displayUI = true;
    }

    public UI(GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_20 = new Font("Arial", Font.PLAIN, 20);
        arial_20_bold = new Font("Arial", Font.BOLD, 20);
    }
    public UI(){
    }

    public void drawInfoScreen(){
        int x = gp.tileSize;
        int y = gp.tileSize*8;
        int width = gp.screenWidth - (gp.tileSize*2);
        int height = gp.screenHeight - (gp.tileSize*9);
        int titlePos = y + gp.tileSize;
        int descPos = y + gp.tileSize*2 - 15;

        //InterractSoundUI locations
        int soundUI_x = gp.tileSize*11;
        int soundUI_y = gp.tileSize*10+38;
        int soundUI_width = gp.tileSize*4-10;
        int soundUI_height = gp.tileSize-10;

        drawSubWindow(x,y,width,height);
        drawText(x,titlePos,descPos,animalIndex);
        interractSoundUI(soundUI_x, soundUI_y,soundUI_width,soundUI_height);
    }

    public void drawText(int x, int titlePosition, int descPosition, int animalIndex){
        animalTitle();
        animalDesc();

        g2.setFont(arial_40);
        g2.setColor(Color.white);

        g2.drawString(animalNames[animalIndex], x+15,titlePosition);

        g2.setFont(arial_20);
        g2.setColor(Color.white);
        for (String word : animalDesc[animalIndex].split("\n")){
            g2.drawString(word,x+15,descPosition);
            descPosition += 23;
        }
    }

    public void drawSubWindow(int x, int y, int width, int height){
        Color blackColor = new Color(0,0,0,200);
        g2.setColor(blackColor);
        g2.fillRoundRect(x,y,width,height,35,35);

        Color borderColor = new Color(230, 141, 106);
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x,y,width,height,25,25);
    }

    public void interractSoundUI(int x, int y, int width, int height){


        Color blackColor = new Color(230, 141, 106);
        g2.setColor(blackColor);
        g2.fillRoundRect(x,y,width,height,35,35);

        Color borderColor = new Color(255,255,255);
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x,y,width,height,25,25);

        g2.setFont(arial_20_bold);
        g2.setColor(Color.black);
        g2.drawString("Press F to hear", x+18,y+25);
    }

    public void draw(Graphics2D g2){
        this.g2 = g2;
        drawInfoScreen();
    }
}