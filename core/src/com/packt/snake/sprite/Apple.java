package com.packt.snake.sprite;

import static com.packt.snake.GameScreen.GRID_SIZE;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

public class Apple extends Sprite {

    public Apple() {
        super(new Texture(Gdx.files.internal("apple.png")));
    }

    @Override
    public void updateState() {
        updatePosition(
            MathUtils.random((Gdx.graphics.getWidth() / GRID_SIZE - 1) * GRID_SIZE),
            MathUtils.random((Gdx.graphics.getHeight() / GRID_SIZE - 1) * GRID_SIZE)
        );
    }
}
