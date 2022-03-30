package com.github.hanyaeger.tutorial.entities.vijanden;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Gif extends DynamicSpriteEntity implements Collider,Collided{
    int speed = 3;

    /**
     * @Davey0485
     * @Rieke2
     * @param initialLocation locatie
     * @param i
     * @param angle hoek waar hij naartoe moeot
     */
    public Gif(Coordinate2D initialLocation, int i,double angle) {
        super("sprites/gif.png",initialLocation,new Size(20,20));
        setMotion(speed,angle);
    }

    /**
     * nodig voor collision
     */
    @Override
    public void onCollision(Collider collidingObject) {
        // TODO Auto-generated method stub
        
    }
    
}
