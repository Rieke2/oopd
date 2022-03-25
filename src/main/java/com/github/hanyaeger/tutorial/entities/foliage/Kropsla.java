package com.github.hanyaeger.tutorial.entities.foliage;

import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Kropsla extends DynamicSpriteEntity implements Collider, Collided {

    public Kropsla(final Coordinate2D location) {
        super("sprites/coral2.png", location,new Size(20,20));
    }
    
    public void newLocation(){
        Random random = new Random();
        setAnchorLocation(new Coordinate2D(random.nextInt((int) getSceneWidth()),random.nextInt((int) getSceneHeight())));
    }

    @Override
    public void onCollision(Collider collidingObject) {
        // TODO Auto-generated method stub
        
    }
}
