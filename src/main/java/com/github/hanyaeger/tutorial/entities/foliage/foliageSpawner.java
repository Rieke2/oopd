package com.github.hanyaeger.tutorial.entities.foliage;

import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.entities.Swordfish;
import com.github.hanyaeger.tutorial.entities.player.rabbit.rabbit;

public class foliageSpawner extends EntitySpawner {

    private final double sceneWidth;
    private final double sceneHeight;

    public foliageSpawner(double sceneWidth, double sceneHeight) {
        super(100);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    public void spawnEntities() {
        spawn(new grass(randomLocation()));
        
    }

    private Coordinate2D randomLocation() {
        double x = new Random().nextInt((int) sceneWidth);
        return new Coordinate2D(x, sceneHeight);
    }
}

