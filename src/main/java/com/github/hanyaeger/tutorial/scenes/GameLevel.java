package com.github.hanyaeger.tutorial.scenes;

import java.util.ArrayList;
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
import com.github.hanyaeger.tutorial.entities.vijanden.GroeneSlang;
import com.github.hanyaeger.tutorial.entities.vijanden.RodeSlang;
import com.github.hanyaeger.tutorial.entities.vijanden.Vijand;
import com.github.hanyaeger.tutorial.entities.vijanden.Wolf;

import javafx.scene.paint.Color;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer{
    int aantalStruiken = 3;
    int aantalSla = 3;
    int aantalHolen = 2;
    int aantalWolven = 1;
    int aantalRodeSlangen = 1;
    int aantalGroeneSlangen = 1;
    RabbitSurvival rabbitSurvival;
    Vijand rSlang;
    Rabbit player;
    ArrayList<Hol> holen = new ArrayList<Hol>();

    public GameLevel(RabbitSurvival rabbitSurvival) {
        this.rabbitSurvival = rabbitSurvival;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.GREEN); 
    }

    @Override
    public void setupEntities() {
        for(int i=0;i<aantalHolen;i++){
            Hol hol = new Hol(getRandomLocation());
            addEntity(hol);
            holen.add(hol);
        }

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

        for(int i=0;i<aantalWolven;i++){
            Vijand wolf = new Wolf(getRandomLocation(),player);
            addEntity(wolf);
        }

        for(int i=0;i<aantalRodeSlangen;i++){
            Vijand rSlang = new RodeSlang(getRandomLocation(),player);
            addEntity(rSlang);
            this.rSlang = rSlang;
        }

        for(int i=0;i<aantalGroeneSlangen;i++){
            Vijand gSlang = new GroeneSlang(getRandomLocation(),player,holen);
            addEntity(gSlang);
        }
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

