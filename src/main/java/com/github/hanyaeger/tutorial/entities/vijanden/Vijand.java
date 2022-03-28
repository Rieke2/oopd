package com.github.hanyaeger.tutorial.entities.vijanden;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;


import com.github.hanyaeger.api.Size;

public abstract class Vijand extends DynamicSpriteEntity{
    protected Vijand(String resource, Coordinate2D location, Size size, int i, int j) {
        super(resource, location, size,i,j);
        //TODO Auto-generated constructor stub
    }

    abstract void move();
}
