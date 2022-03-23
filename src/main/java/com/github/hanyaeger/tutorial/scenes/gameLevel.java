package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.entities.foliage.foliageSpawner;
import com.github.hanyaeger.tutorial.entities.foliage.grass;
import com.github.hanyaeger.tutorial.entities.player.rabbit.FOV;
import com.github.hanyaeger.tutorial.entities.player.rabbit.rabbit;

import javafx.scene.paint.Color;

public class gameLevel extends DynamicScene implements EntitySpawnerContainer{
    final int SQUARES = 20;
    final int GRASS = 20;
    int swordfishX = 3;
    int swordfishY = 2;

    @Override
    public void setupScene() {
        // TODO Auto-generated method stub
        setBackgroundColor(Color.GREEN);        
    }

    @Override
    public void setupEntities() {
        // TODO Auto-generated method stub
        
        FOV fov = new FOV(new Coordinate2D((getWidth()/SQUARES)*swordfishX,(getHeight()/SQUARES)*swordfishY));
        addEntity(fov);
        rabbit player = new rabbit(new Coordinate2D((getWidth()/SQUARES)*swordfishX,(getHeight()/SQUARES)*swordfishY),fov);
        addEntity(player);
        grass grass = new grass(new Coordinate2D(100,100));
        addEntity(grass);
    }

    @Override
    public void setupEntitySpawners() {
        // TODO Auto-generated method stub
        //addEntitySpawner(new foliageSpawner(getWidth(),getHeight()));
    }
    
    
}
