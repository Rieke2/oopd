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
    /**
     * @Davey0485
     * @Rieke2
     * @param location locatie
     * @param rabbit speler
     */
    public RodeSlang(Coordinate2D location,Rabbit rabbit) {
        super("sprites/rodeSlang.png", location, new Size(40,40),rabbit,walkSpeed);
    }

    /**
     * beweegt de slang
     */
    @Override
    void move() {
        double distance = rabbit.getAnchorLocation().distance(getAnchorLocation());
        if((distance<range&&!rabbit.inHol()&&!rabbit.inStruik())||(distance<struikRange&&!rabbit.inHol())){
            setMotion(speed,angleTo(rabbit));
        } else {
            idle();
        }
    }

    /**
     * nodig voor collision
     */
    @Override
    public void onCollision(Collider collidingObject) {
        // TODO Auto-generated method stub
        
    }

    /**
     * beweegt
     */
    @Override
    public void explicitUpdate(long timestamp) {
        // TODO Auto-generated method stub
        move();
    }
    
    /**
     * 
     * @return range
     */
    public int getRange(){
        return range;
    }

    /**
     * 
     * @return spittingRange
     */
    public int getSpittingRange(){
        return spittingRange;
    }
}
