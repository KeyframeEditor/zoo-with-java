package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;
import java.util.Objects;

import res.sound.*;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[5];
    URL soundAnimal[] = new URL[6];
    UI ui = new UI();


    public Sound(){
        //animal sounds
        soundAnimal[0] = getClass().getResource(SoundAssets.redPanda);
        soundAnimal[1] = getClass().getResource(SoundAssets.saiga);
        soundAnimal[2] = getClass().getResource(SoundAssets.rhea);
        soundAnimal[3] = getClass().getResource(SoundAssets.wombat);
        soundAnimal[4] = getClass().getResource(SoundAssets.shoebill);
        soundAnimal[5] = getClass().getResource(SoundAssets.okapi);

        //sound effects
        soundURL[0] = getClass().getResource(SoundAssets.excuse);
        soundURL[1] = getClass().getResource(SoundAssets.step1);
        soundURL[2] = getClass().getResource(SoundAssets.step2);
        soundURL[3] = getClass().getResource(SoundAssets.itemdrop);
        soundURL[4] = getClass().getResource(SoundAssets.beast);
    }

//    public void setFile(int i){
//        try{
//            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
//            clip = AudioSystem.getClip();
//            clip.open(ais);
//        }catch (Exception e){
//
//        }
//    }

    public void setFile(String animalSound){
        try{
            ui.animalTitle();
            if (isNumeric(animalSound)){
                AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[Integer.parseInt(animalSound)]);
                clip = AudioSystem.getClip();
                clip.open(ais);
            }else{
                for(int j = 0; j <= soundAnimal.length; j++){
                    if (Objects.equals(ui.animalNames[j], animalSound)){
                        AudioInputStream ais = AudioSystem.getAudioInputStream(soundAnimal[j]);
                        clip = AudioSystem.getClip();
                        clip.open(ais);
                    }
                }
            }

        }catch (Exception e){
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
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