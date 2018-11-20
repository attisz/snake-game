package com.packt.snake.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Apple extends Sprite {
    public Apple() {
        super(new Texture(Gdx.files.internal("apple.png")));
    }
}
