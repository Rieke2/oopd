package com.github.hanyaeger.tutorial.entities.foliage;

import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class grass extends DynamicSpriteEntity implements Collider, Collided {

    public grass(final Coordinate2D location) {
        super("sprites/coral2.png", location);
    }
    
    public void newLocation(){
    }

    @Override
    public void onCollision(Collider collidingObject) {
        // TODO Auto-generated method stub
        
    }
}
