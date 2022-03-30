package com.github.hanyaeger.tutorial.entities.foliage;

import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Kropsla extends DynamicSpriteEntity implements Collider, Collided {
    /**
     * @Davey0485
     * @Rieke2
     * @param location plaats van de sla
     */
    public Kropsla(final Coordinate2D location) {
        super("sprites/lettuce.png", location,new Size(30,30));
    }
    
    /**
     * sla gaat naar een random nieuwe locatie
     */
    public void newLocation(){
        Random random = new Random();
        setAnchorLocation(new Coordinate2D(random.nextInt((int) getSceneWidth()),random.nextInt((int) getSceneHeight())));
    }

    /**
     * nodig voor collision
     */
    @Override
    public void onCollision(Collider collidingObject) {
        // TODO Auto-generated method stub
        
    }
}
