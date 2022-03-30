package com.github.hanyaeger.tutorial.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.tutorial.RabbitSurvival;

import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight; 

public class sceneChangeButton extends TextEntity implements MouseButtonPressedListener {
    int scene;
    RabbitSurvival rabbitsurvival;
  
public sceneChangeButton(Coordinate2D initialLocation,int scene,String Buttontext,RabbitSurvival rabbitsurvival){
    super(initialLocation,Buttontext);
    setFill(Color.PURPLE);
    setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    setAnchorPoint(AnchorPoint.CENTER_CENTER);
    this.scene=scene;
    this.rabbitsurvival=rabbitsurvival;
}

@Override
public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
    // TODO Auto-generated method stub
    rabbitsurvival.setActiveScene(scene);
}


}
