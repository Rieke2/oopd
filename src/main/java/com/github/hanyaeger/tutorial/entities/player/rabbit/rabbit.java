package com.github.hanyaeger.tutorial.entities.player.rabbit;

import java.util.Random;
import java.util.Set;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.entities.hol;
import com.github.hanyaeger.tutorial.entities.foliage.grass;

import javafx.scene.input.KeyCode;

public class rabbit extends DynamicSpriteEntity implements KeyListener,SceneBorderTouchingWatcher,Collider,Collided{
    final int WALKSPEED = 2;
    final int RUNSPEED = 5;
    int speed = WALKSPEED;
    int score = 0;
    boolean inHol = false;
    hol hol;
    String naam = "speler";
    public rabbit(Coordinate2D location){
        super("sprites/hanny.png", location, new Size(20,40), 1, 2);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
public void onPressedKeysChange(Set<KeyCode> pressedKeys){
    double a = 0;
    double b = 0;
    boolean up = pressedKeys.contains(KeyCode.UP)||pressedKeys.contains(KeyCode.W);
    boolean down = pressedKeys.contains(KeyCode.DOWN)||pressedKeys.contains(KeyCode.S);
    boolean left = pressedKeys.contains(KeyCode.LEFT)||pressedKeys.contains(KeyCode.A);
    boolean right = pressedKeys.contains(KeyCode.RIGHT)||pressedKeys.contains(KeyCode.D);

    if(pressedKeys.contains(KeyCode.SPACE)&&touchesHol()){
        inHol = !inHol;
        setAnchorLocation(hol.getLocation());
        setSpeed(0);
    }

    if(pressedKeys.contains(KeyCode.SHIFT)){
   //     speed = RUNSPEED;
    } else {
        speed = WALKSPEED;
    }

    if(!inHol){
        if(left&&!right){
            a=270d;
        } else if(right&&!left){
            a=90d;
        }
        if(up&&!down){
            b=180d;
        } else if(down&&!up){
            b=360d;
        }

        if(a==0.0&&b!=0.0){
            setMotion(speed,b);
        }else if(a!=0.0&&b==0.0){
            setMotion(speed,a);
        }else if(a!=0.0&&b!=0.0){
            a = Math.toRadians(a);
            b = Math.toRadians(b);
            setMotion(speed,Math.toDegrees(Math.atan2((Math.sin(a)+Math.sin(b))/2,(Math.cos(a)+Math.cos(b))/2)));
        }else if(a==0.0&&b==0.0){
            setSpeed(0);
        }
    }

}

@Override
public void notifyBoundaryTouching(SceneBorder border){
    setSpeed(0);

    switch(border){
        case TOP:
            setAnchorLocationY(10);
            break;
        case BOTTOM:
            setAnchorLocationY(getSceneHeight() - getHeight() + 9);
            break;
        case LEFT:
            setAnchorLocationX(10);
            break;
        case RIGHT:
            setAnchorLocationX(getSceneWidth() - getWidth() + 9);
        default:
            break;
        }
}

private boolean touchesHol(){
    Coordinate2D location =  getAnchorLocation();
    if(hol != null){
        if(location.distance(hol.getLocation())<30){
            return true;
        }
    }
    return false;
}

@Override
public void onCollision(Collider object){
    if(object instanceof grass){
        ((grass) object).newLocation();
        score+=1;
    }if(object instanceof hol){
        hol = ((hol)object);
    }
}
    
}
