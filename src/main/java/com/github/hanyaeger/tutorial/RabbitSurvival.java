package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.tutorial.scenes.StartScreen;
import com.github.hanyaeger.tutorial.scenes.EindScherm;
import com.github.hanyaeger.tutorial.scenes.GameLevel;

public class RabbitSurvival extends YaegerGame {
    public static void main(String[]args){
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Rabbit Survival");
        setSize(new Size(800, 600));
    }


    @Override
    public void setupScenes(){
        addScene(0, new StartScreen(this));
        addScene(1, new GameLevel(this));
        addScene(2, new EindScherm(this));
    }
    
}
