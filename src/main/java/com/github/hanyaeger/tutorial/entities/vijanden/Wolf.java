package com.github.hanyaeger.tutorial.entities.vijanden;

import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.entities.player.rabbit.Rabbit;

import com.github.hanyaeger.api.Size;

public class Wolf extends Vijand implements Collider,Collided,UpdateExposer{
    Rabbit rabbit;
    final int RANGE = 100;
    final int SPEED = 2;
    final int WALKSPEED = 1;
    Coordinate2D idleGoal = new Coordinate2D(100,100);

    public Wolf(Coordinate2D location,Rabbit rabbit) {
        super("sprites/hanny.png", location, new Size(20,40), 1, 2);
        this.rabbit = rabbit;
    }

    @Override
    public void onCollision(Collider collidingObject) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void move() {
        if(rabbit.getAnchorLocation().distance(getAnchorLocation())<RANGE&&!rabbit.inHol()){
            setMotion(SPEED,angleTo(rabbit));
        } else {
            idle();
        }
    }

    private void idle(){
        if(getAnchorLocation().distance(idleGoal)<20){
            idleGoal = getRandomLocation();
        }
        setMotion(WALKSPEED,angleTo(idleGoal));
    }

    private Coordinate2D getRandomLocation(){
        Random random = new Random();
        return new Coordinate2D(random.nextInt((int)getSceneWidth()),random.nextInt((int)getSceneHeight()));
    }

    @Override
    public void explicitUpdate(long timestamp) {
        // TODO Auto-generated method stub
        move();
    }
    
}
