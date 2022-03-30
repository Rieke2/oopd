package com.github.hanyaeger.tutorial.entities.vijanden;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.entities.player.rabbit.Rabbit;

import com.github.hanyaeger.api.Size;

public class Wolf extends Vijand implements Collider,Collided,UpdateExposer{
    int range = 200;
    int struikRange = 50;
    double speed = 2;
    static double walkSpeed = 1;
    Coordinate2D idleGoal = new Coordinate2D(100,100);

    /**
     * @Davey0485
     * @Rieke2
     * @param location locatie
     * @param rabbit speler
     */
    public Wolf(Coordinate2D location,Rabbit rabbit) {
        super("sprites/Wolf.png", location, new Size(60,60),rabbit,1);
    }

    /**
     * doet niet zo veel
     */
    @Override
    public void onCollision(Collider collidingObject) {
        // TODO Auto-generated method stub
        
    }

    /**
     * beweegt de wolf
     */
    @Override
    public void move() {
        double distance = rabbit.getAnchorLocation().distance(getAnchorLocation());
        if((distance<range&&!rabbit.inHol()&&!rabbit.inStruik())||(distance<struikRange&&!rabbit.inHol())){
            setMotion(speed,angleTo(rabbit));
        } else {
            idle();
        }
    }

    /**
     * beweegt de wolf
     */
    @Override
    public void explicitUpdate(long timestamp) {
        // TODO Auto-generated method stub
        move();
    }
    
}
