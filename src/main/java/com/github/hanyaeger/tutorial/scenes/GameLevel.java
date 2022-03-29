package com.github.hanyaeger.tutorial.scenes;

import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.RabbitSurvival;
import com.github.hanyaeger.tutorial.entities.Hol;
import com.github.hanyaeger.tutorial.entities.foliage.Kropsla;
import com.github.hanyaeger.tutorial.entities.foliage.Struik;
import com.github.hanyaeger.tutorial.entities.player.rabbit.Rabbit;
import com.github.hanyaeger.tutorial.entities.vijanden.GifSpawner;
import com.github.hanyaeger.tutorial.entities.vijanden.RodeSlang;
import com.github.hanyaeger.tutorial.entities.vijanden.Vijand;
import com.github.hanyaeger.tutorial.entities.vijanden.Wolf;

import javafx.scene.paint.Color;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer{
    int aantalStruiken = 3;
    int aantalSla = 3;
    RabbitSurvival rabbitSurvival;
    Vijand rSlang;
    Rabbit player;

    public GameLevel(RabbitSurvival rabbitSurvival) {
        this.rabbitSurvival = rabbitSurvival;
    }

    @Override
    public void setupScene() {
        // TODO Auto-generated method stub
        setBackgroundColor(Color.GREEN);   
        System.out.println("leve");     
    }

    @Override
    public void setupEntities() {
        // TODO Auto-generated method stub
        
        Hol hol = new Hol(getRandomLocation());
        addEntity(hol);
        for(int i=0;i<aantalStruiken;i++){
            Struik struik = new Struik(getRandomLocation());
            addEntity(struik);
        }
        player = new Rabbit(new Coordinate2D(100,100),rabbitSurvival);
        addEntity(player);
        for(int i=0;i<aantalSla;i++){
            Kropsla sla = new Kropsla(getRandomLocation());
            addEntity(sla);
        }
        Vijand wolf = new Wolf(getRandomLocation(),player);
        addEntity(wolf);
        rSlang = new RodeSlang(getRandomLocation(),player);
        addEntity(rSlang);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new GifSpawner(rSlang,player));
    }  

    private Coordinate2D getRandomLocation(){
        Random random = new Random();
        return new Coordinate2D(random.nextInt((int)getWidth()),random.nextInt((int)getHeight()));
    }
    
}

