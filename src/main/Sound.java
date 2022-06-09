package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;
import res.sound.*;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[4];

    public Sound(){
        soundURL[0] = getClass().getResource(SoundAssets.excuse);
        soundURL[1] = getClass().getResource(SoundAssets.step1);
        soundURL[2] = getClass().getResource(SoundAssets.step2);
        soundURL[3] = getClass().getResource(SoundAssets.itemdrop);
    }

    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch (Exception e){

        }
    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}
