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
  /**
   * @Davey0485
   * @Rieke2
   * @param initialLocation locatie van de button
   * @param scene scene waarnaar je wil veranderen
   * @param Buttontext text op de button
   * @param rabbitsurvival de game
   */
public sceneChangeButton(Coordinate2D initialLocation,int scene,String Buttontext,RabbitSurvival rabbitsurvival){
    super(initialLocation,Buttontext);
    setFill(Color.PURPLE);
    setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    setAnchorPoint(AnchorPoint.CENTER_CENTER);
    this.scene=scene;
    this.rabbitsurvival=rabbitsurvival;
}

/**
 * @param button button
 * @param coordinate2d plaats
 */
@Override
public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
    // TODO Auto-generated method stub
    rabbitsurvival.setActiveScene(scene);
}


}
