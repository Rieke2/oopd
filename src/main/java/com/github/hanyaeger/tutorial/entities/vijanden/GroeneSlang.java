package com.github.hanyaeger.tutorial.entities.vijanden;

import java.util.ArrayList;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.entities.Hol;
import com.github.hanyaeger.tutorial.entities.player.rabbit.Rabbit;

public class GroeneSlang extends Vijand implements Collider,Collided,UpdateExposer{
    static double walkSpeed = 0.5;
    int range = 200;
    double speed = 1;
    Coordinate2D idleGoal;
    int struikRange = 100;
    boolean inHol = false;
    ArrayList<Hol> holen;

    /**
     * @Davey0485
     * @Rieke2
     * @param location locatie van de slang
     * @param rabbit speler
     * @param holen alle holen in het spel
     */
    public GroeneSlang(Coordinate2D location, Rabbit rabbit,ArrayList<Hol> holen) {
        super("sprites/groeneSlang.png", location, new Size(40,40), rabbit, walkSpeed);
        this.holen = holen;
    }

    /**
     * nodig voor collision
     */
    @Override
    public void onCollision(Collider collidingObject) {
        // TODO Auto-generated method stub
        
    }

    /**
     * beweegt de slang
     */
    @Override
    public void move() {
        double distance = rabbit.getAnchorLocation().distance(getAnchorLocation());
        if((distance<range&&!rabbit.inStruik())||(distance<struikRange)){
            if(rabbit.inHol()&&!inHol){
                setMotion(speed,angleTo(holen.get(dichstbijzijndeHol())));
                if(getAnchorLocation().distance(holen.get(dichstbijzijndeHol()).getAnchorLocation())<30){
                    inHol = true;
                }
            } else if(!rabbit.inHol()&&inHol){
                setMotion(speed,angleTo(holen.get(dichstbijzijndeHol())));
                if(getAnchorLocation().distance(holen.get(dichstbijzijndeHol()).getAnchorLocation())<30){
                    inHol = false;
                }
            } else {
                setMotion(speed,angleTo(rabbit));
            }
        } else {
            idle();
        }
    }
    
    /**
     * 
     * @return het dichstbijzijndste hol
     */
    private int dichstbijzijndeHol(){
        int h = 0;
        double a = 100000;
        double distance = 0;
        for(int i=0;i<holen.size();i++){
            distance = getAnchorLocation().distance(holen.get(i).getAnchorLocation());
            if(distance<a){
                a = distance;
                h = i;
            }
        }
        return h;
    }

    /**
     * regelt de opacity
     */
    @Override
    public void explicitUpdate(long timestamp) {
        move();
        if(inHol){
            setOpacity(0.3);
        } else {
            setOpacity(1);
        }
    }

    /**
     * 
     * @return inHol
     */
    public boolean inHol(){
        return inHol;
    }
}
