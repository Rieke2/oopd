package com.github.hanyaeger.tutorial.entities.vijanden;

import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.tutorial.entities.player.rabbit.Rabbit;
import com.github.hanyaeger.api.Size;

public abstract class Vijand extends DynamicSpriteEntity{
    public Rabbit rabbit;
    private Coordinate2D idleGoal = getAnchorLocation();
    private double walkSpeed;

    /**
     * @Davey0485
     * @Rieke2
     * @param resource plaatje van de vijand
     * @param location locatie
     * @param size grootte
     * @param rabbit speler
     * @param walkSpeed hoe snel de vijand loopt
     */
    protected Vijand(String resource, Coordinate2D location, Size size, Rabbit rabbit,double walkSpeed) {
        super(resource, location, size);
        
        this.rabbit = rabbit;
        this.walkSpeed = walkSpeed;
    }

    /**
     * beweegt de vijand
     */
    abstract void move();

    /**
     * 
     * @return random Coordinate2D
     */
    protected Coordinate2D getRandomLocation(){
        Random random = new Random();
        return new Coordinate2D(random.nextInt((int)getSceneWidth()),random.nextInt((int)getSceneHeight()));
    }

    /**
     * beweegt de vijand wanneer de speler niet in range is
     */
    protected void idle(){
        if(getAnchorLocation().distance(idleGoal)<20){
            idleGoal = getRandomLocation();
        }
        setMotion(walkSpeed,angleTo(idleGoal));
    }
}
