package com.github.hanyaeger.tutorial.entities.foliage;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Struik extends DynamicSpriteEntity implements Collider,Collided {

    public Struik(Coordinate2D initialLocation) {
        super("sprites/coral1.png", initialLocation, new Size(40,40));
        //TODO Auto-generated constructor stub
    }

    @Override
    public void onCollision(Collider collidingObject) {
        // TODO Auto-generated method stub
        
    }
    
}