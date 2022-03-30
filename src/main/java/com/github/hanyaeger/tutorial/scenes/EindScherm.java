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

public class EindScherm extends StaticScene{

    private RabbitSurvival rabbitsurvival;

    int score;

    public EindScherm(RabbitSurvival rabbitsurvival){
        this.rabbitsurvival = rabbitsurvival;
    }

    public EindScherm() {
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.DIMGREY);
    }

    @Override
    public void setupEntities() {
        var rabbitsurvivalText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 4), "Rabbit Survival");
    
        var ScoreText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 3), Integer.toString(score));
    
        rabbitsurvivalText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        rabbitsurvivalText.setFill(Color.DARKSEAGREEN);
        rabbitsurvivalText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 50));
        addEntity(rabbitsurvivalText);
        ScoreText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        ScoreText.setFill(Color.DARKSEAGREEN);
        ScoreText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 50));
        addEntity(ScoreText);
        Coordinate2D location = new Coordinate2D(0,0);
        sceneChangeButton button1 = new sceneChangeButton(new Coordinate2D(getWidth() / 2 , getHeight() / 2),0, "Herstart spel", rabbitsurvival);
        addEntity(button1);
    }

    public void method(Coordinate2D initialLocation,String text){
        System.out.println(text);
    }
    public void setScore(int score){
        this.score = score;
    }

}
    

