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

    private RabbitSurvival waterworld;

    public StartScreen(RabbitSurvival waterworld){
        this.waterworld = waterworld;
    }


    @Override
    public void setupScene(){
        setBackgroundImage("backgrounds/background1.jpg");
    }


    @Override
    public void setupEntities(){
        var waterworldText = new TextEntity(
            new Coordinate2D(getWidth() / 2, getHeight() / 2),
            "Waterworld"
        );
        waterworldText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        waterworldText.setFill(Color.DARKBLUE);
        waterworldText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(waterworldText);
        Coordinate2D location = new Coordinate2D(0,0);
        sceneChangeButton button1 = new sceneChangeButton(location,1,waterworld);
        System.out.println("dlsa");
        addEntity(button1);
    }

    public void method(Coordinate2D initialLocation,String text){
        System.out.println(text);
    }

    
}