package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import javafx.css.Size;

public class Swordfish extends DynamicSpriteEntity implements SceneBorderCrossingWatcher,Collider,Collided {

    public Swordfish(Coordinate2D location){
        super("sprites/hanny.png", location);
        setMotion(2, 270d);

    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border){
        setAnchorLocationX(getSceneWidth());
    }

    @Override
    public void onCollision(Collider collidingObject) {
        // TODO Auto-generated method stub
        System.out.println("sf coll");
    }

    
    
}
