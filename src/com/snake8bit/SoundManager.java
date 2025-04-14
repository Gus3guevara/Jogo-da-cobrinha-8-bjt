package com.snake8bit;

import javax.sound.sampled.*;
import java.io.File;

public class SoundManager {
    private Clip backgroundClip;

    public void playBackgroundMusic() {
        if (backgroundClip != null && backgroundClip.isRunning()) {
            return; // already playing
        }
        backgroundClip = play("assets/sounds/ambient_music.wav", true);
    }

    public void stopBackgroundMusic() {
        if (backgroundClip != null) {
            backgroundClip.stop();
            backgroundClip.close();
            backgroundClip = null;
        }
    }

    public void playSound(String soundFile) {
        play(soundFile, false);
    }

    private Clip play(String soundFile, boolean loop) {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(soundFile));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            if (loop) clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
            return clip;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}