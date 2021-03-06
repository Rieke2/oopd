package com.github.hanyaeger.tutorial.entities.vijanden;

import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.entities.player.rabbit.Rabbit;

public class GifSpawner extends EntitySpawner{
    RodeSlang slang;
    Rabbit rabbit;
    /**
     * @Davey0485
     * @Rieke2
     * @param slang slang waar de gifspawner bij hoort
     * @param rabbit speler
     */
    public GifSpawner(Vijand slang,Rabbit rabbit) {
        super(3000);
        //TODO Auto-generated constructor stub
        this.slang = (RodeSlang)slang;
        this.rabbit = rabbit;
    }

    /**
     * spawnt gif
     */
    @Override
    protected void spawnEntities() {
        if(slang.distanceTo(rabbit)<slang.getRange()&&!rabbit.inHol()){
            spawn(new Gif(slang.getAnchorLocation(), 1,slang.angleTo(rabbit)));
        }
        
    }
    
}
