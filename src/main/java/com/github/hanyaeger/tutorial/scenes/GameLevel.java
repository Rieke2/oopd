package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.RabbitSurvival;
import com.github.hanyaeger.tutorial.entities.Hol;
import com.github.hanyaeger.tutorial.entities.foliage.Kropsla;
import com.github.hanyaeger.tutorial.entities.player.rabbit.Rabbit;
import com.github.hanyaeger.tutorial.entities.vijanden.Vijand;
import com.github.hanyaeger.tutorial.entities.vijanden.Wolf;

import javafx.scene.paint.Color;

public class GameLevel extends DynamicScene {
    int swordfishX = 3;
    int swordfishY = 2;
    RabbitSurvival rabbitSurvival;

    public GameLevel(RabbitSurvival rabbitSurvival) {
        this.rabbitSurvival = rabbitSurvival;
    }

    @Override
    public void setupScene() {
        // TODO Auto-generated method stub
        setBackgroundColor(Color.GREEN);   
        System.out.println("leve");     
    }

    @Override
    public void setupEntities() {
        // TODO Auto-generated method stub
        
        Hol hol = new Hol(new Coordinate2D(200,200));
        addEntity(hol);
        Rabbit player = new Rabbit(new Coordinate2D(100,100),rabbitSurvival);
        addEntity(player);
        Kropsla sla = new Kropsla(new Coordinate2D(0,0));
        addEntity(sla);
        Vijand wolf = new Wolf(new Coordinate2D(300,300),player);
        addEntity(wolf);
    }  
    
}

