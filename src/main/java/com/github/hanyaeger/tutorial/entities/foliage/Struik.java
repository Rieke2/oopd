package com.github.hanyaeger.tutorial.entities.foliage;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Struik extends DynamicSpriteEntity implements Collider,Collided {
    /**
     * @Davey0485
     * @Rieke2
     * @param initialLocation locatie van de struik
     */
    public Struik(Coordinate2D initialLocation) {
        super("sprites/Bush.png", initialLocation, new Size(80,80));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    /**
     * doet niet zo veel
     */
    @Override
    public void onCollision(Collider collidingObject) {
        // TODO Auto-generated method stub
        
    }
    
}
