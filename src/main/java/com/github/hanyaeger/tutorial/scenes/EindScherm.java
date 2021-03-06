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

    /**
     * @Davey0485
     * @Rieke2
     * @param rabbitsurvival de game
     */
    public EindScherm(RabbitSurvival rabbitsurvival){
        this.rabbitsurvival = rabbitsurvival;
    }

    /**
     * verandert achtergrondkleur
     */
    @Override
    public void setupScene() {
        setBackgroundColor(Color.DIMGREY);
    }

    /**
     * plaatst de tekst en de herstartknop
     */
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
        sceneChangeButton button1 = new sceneChangeButton(new Coordinate2D(getWidth() / 2 , getHeight() / 2),0, "Herstart spel", rabbitsurvival);
        addEntity(button1);
    }

    /**
     * 
     * @param score score gehaald
     * updates de score
     */
    public void setScore(int score){
        this.score = score;
    }

}
    

