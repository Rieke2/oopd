package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.entities.Hol;
import com.github.hanyaeger.tutorial.entities.foliage.Kropsla;
import com.github.hanyaeger.tutorial.entities.player.rabbit.Rabbit;

import javafx.scene.paint.Color;

public class GameLevel extends DynamicScene {
    int swordfishX = 3;
    int swordfishY = 2;

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
        Rabbit player = new Rabbit(new Coordinate2D(100,100));
        addEntity(player);
        Kropsla sla = new Kropsla(new Coordinate2D(0,0));
        addEntity(sla);
    }  
    
}

