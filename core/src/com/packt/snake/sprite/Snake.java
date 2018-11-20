package com.packt.snake.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.ArrayList;
import java.util.List;

import static com.packt.snake.sprite.Direction.RIGHT;

public class Snake implements Drawable {

    private SnakePart head;
    private List<SnakePart> body;
    private Direction direction = RIGHT;

    public Snake() {
        head = new SnakePart(new Texture(Gdx.files.internal("snakehead.png")));
        body = new ArrayList<>();
    }

    @Override
    public void draw(Batch batch) {
        head.draw(batch);
        body.forEach(snakePart -> snakePart.draw(batch));
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void update() {

    }
}
