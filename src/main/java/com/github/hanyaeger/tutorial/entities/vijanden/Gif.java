package com.github.hanyaeger.tutorial.entities.vijanden;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Gif extends DynamicSpriteEntity implements Collider,Collided{
    int speed = 3;

    public Gif(Coordinate2D initialLocation, int i,double angle) {
        super("sprites/gif.png",initialLocation,new Size(20,20));
        setMotion(speed,angle);
    }

    @Override
    public void onCollision(Collider collidingObject) {
        // TODO Auto-generated method stub
        
    }
    
}
