package com.packt.snake.sprite;

import com.badlogic.gdx.graphics.g2d.Batch;

public interface Drawable {
    void updateState();
    void draw(Batch batch);

    boolean isCoordinatePartOf(float x, float y);
}
