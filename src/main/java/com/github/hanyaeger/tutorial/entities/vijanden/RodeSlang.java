package com.github.hanyaeger.tutorial.entities.vijanden;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.entities.player.rabbit.Rabbit;

public class RodeSlang extends Vijand implements Collider,Collided,UpdateExposer{
    int range = 200;
    double speed = 1;
    static double walkSpeed = 0.5;
    Coordinate2D idleGoal;
    int spittingRange = 100;
    int struikRange = 100;
    public RodeSlang(Coordinate2D location,Rabbit rabbit) {
        super("sprites/swordfish.png", location, new Size(20,40),1,2,rabbit,walkSpeed);
    }

    @Override
    void move() {
        double distance = rabbit.getAnchorLocation().distance(getAnchorLocation());
        if((distance<range&&!rabbit.inHol()&&!rabbit.inStruik())||(distance<struikRange&&!rabbit.inHol())){
            setMotion(speed,angleTo(rabbit));
        } else {
            idle();
        }
    }

    @Override
    public void onCollision(Collider collidingObject) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void explicitUpdate(long timestamp) {
        // TODO Auto-generated method stub
        move();
    }
    
    public int getRange(){
        return range;
    }

    public int getSpittingRange(){
        return spittingRange;
    }
}
