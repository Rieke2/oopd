package com.github.hanyaeger.tutorial.entities.player.rabbit;

import java.util.ArrayList;
import java.util.List;
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
import com.github.hanyaeger.tutorial.entities.Hol;
import com.github.hanyaeger.tutorial.entities.foliage.Kropsla;

import javafx.scene.input.KeyCode;

public class Rabbit extends DynamicSpriteEntity implements KeyListener,Collider,Collided,SceneBorderTouchingWatcher{
    final int WALKSPEED = 2;
    final int RUNSPEED = 5;
    int speed = WALKSPEED;
    int score = 0;
    boolean inHol = false;
    List<Hol> holen = new ArrayList<Hol>();
    String naam = "speler";
    public Rabbit(Coordinate2D location){
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

    if(pressedKeys.contains(KeyCode.SPACE)&&touchesHol()!=-1){
        int i = touchesHol();
        inHol = !inHol;
        setAnchorLocation(holen.get(i).getAnchorLocation());
        setSpeed(0);
    }else if(pressedKeys.contains(KeyCode.SPACE)){
        System.out.println(touchesHol());
    }

    if(pressedKeys.contains(KeyCode.SHIFT)){
   //     speed = RUNSPEED;
    } else {
        speed = WALKSPEED;
    }

    if(!inHol){
        setOpacity(1);
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
    } else {
        setOpacity(0.3);
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

private int touchesHol(){
    Coordinate2D location =  getAnchorLocation();
    for(int i=0;i<holen.size();i++){
        if(location.distance(holen.get(i).getAnchorLocation())<30){
            return i;
        }
    }
    return -1;
}

@Override
public void onCollision(Collider object){
    if(object instanceof Kropsla){
        ((Kropsla) object).newLocation();
        score+=1;
    }if(object instanceof Hol){
        boolean h = false;
        for(Hol hol : holen){
            if(object.equals(hol)){
                h = true;
            }
        }
        if(!h){
            holen.add((Hol)object)  ;
        }
    }
}
}
