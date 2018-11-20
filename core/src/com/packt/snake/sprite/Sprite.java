package com.packt.snake.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public abstract class Sprite implements Drawable {

    private final Texture texture;
    private float x, y;

    Sprite(Texture texture) {
        this.texture = texture;
    }

    @Override
    public void draw(Batch batch) {
        batch.draw(texture, x, y);
    }

    public void updatePosition(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
