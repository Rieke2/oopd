package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.RabbitSurvival;
import com.github.hanyaeger.tutorial.entities.buttons.sceneChangeButton;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StartScreen extends StaticScene {

    private RabbitSurvival rabbitsurvival;

    public StartScreen(RabbitSurvival rabbitsurvival){
        this.rabbitsurvival = rabbitsurvival;
    }


    @Override
    public void setupScene(){
        // setBackgroundImage("backgrounds/background1.jpg");
        setBackgroundColor(Color.DIMGREY);
    }


    @Override
    public void setupEntities(){
        var rabbitsurvivalText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 4), "Rabbit Survival");

        rabbitsurvivalText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        rabbitsurvivalText.setFill(Color.DARKSEAGREEN);
        rabbitsurvivalText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 50));
        addEntity(rabbitsurvivalText);
        Coordinate2D location = new Coordinate2D(0,0);
        sceneChangeButton button2 = new sceneChangeButton(new Coordinate2D(getWidth() / 2 , getHeight() / 2),1, "Start game", rabbitsurvival);
        addEntity(button2);
    }

    public void method(Coordinate2D initialLocation,String text){
        System.out.println(text);
    }


}
