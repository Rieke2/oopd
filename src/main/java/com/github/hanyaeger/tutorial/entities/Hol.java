package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;

import javafx.scene.paint.Color;

public class Hol extends DynamicCircleEntity implements Collider,Collided{
    Coordinate2D location;
    int radius = 15;

    public Hol(Coordinate2D initialLocation) {
        super(initialLocation);
        this.location = initialLocation;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setRadius(radius);
        setOpacity(0.3);
        setFill(Color.BROWN);
        setStrokeColor(Color.BLACK);
        setStrokeWidth(4);
    }

    @Override
    public void onCollision(Collider collidingObject) {
        // TODO Auto-generated method stub
        
    }
}
