package com.github.hanyaeger.tutorial.entities.vijanden;

import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.tutorial.entities.player.rabbit.Rabbit;
import com.github.hanyaeger.api.Size;

public abstract class Vijand extends DynamicSpriteEntity{
    Rabbit rabbit;
    Coordinate2D idleGoal = getAnchorLocation();
    double walkSpeed;

    protected Vijand(String resource, Coordinate2D location, Size size, int i, int j,Rabbit rabbit,double walkSpeed) {
        super(resource, location, size,i,j);
        
        this.rabbit = rabbit;
        this.walkSpeed = walkSpeed;
    }

    abstract void move();

    
    protected Coordinate2D getRandomLocation(){
        Random random = new Random();
        return new Coordinate2D(random.nextInt((int)getSceneWidth()),random.nextInt((int)getSceneHeight()));
    }

    
    protected void idle(){
        if(getAnchorLocation().distance(idleGoal)<20){
            idleGoal = getRandomLocation();
        }
        setMotion(walkSpeed,angleTo(idleGoal));
    }
}
