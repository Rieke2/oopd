package com.github.hanyaeger.tutorial.entities.buttons;

import java.util.Optional;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.tutorial.Waterworld;

import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight; 

public class sceneChangeButton extends TextEntity implements MouseButtonPressedListener {
    int scene;
    Waterworld waterworld;
  
public sceneChangeButton(Coordinate2D initialLocation,int scene,Waterworld waterworld){
    super(initialLocation,"Play game");
    setFill(Color.PURPLE);
    setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    this.scene=scene;
    this.waterworld=waterworld;
}

@Override
public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
    // TODO Auto-generated method stub
    waterworld.setActiveScene(scene);
}


}
