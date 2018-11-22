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

    @Override
    public boolean isCoordinatePartOf(float x, float y) {
        return this.x == x && this.y == y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void updatePosition(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
