package com.github.hanyaeger.tutorial.entities.player.rabbit;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;

import javafx.scene.paint.Color;

public class FOV extends DynamicCircleEntity{

    public FOV(Coordinate2D initialLocation) {
        super(initialLocation);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setRadius(60);
        setOpacity(0.3);
        setFill(Color.RED);
        setStrokeColor(Color.BLACK);
        setStrokeWidth(1);
    }
    
    public void updateLocation(Coordinate2D location){
        setAnchorLocation(location);
    }
}
