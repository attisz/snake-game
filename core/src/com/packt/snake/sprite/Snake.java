package com.packt.snake.sprite;

import static com.packt.snake.GameScreen.GRID_SIZE;
import static com.packt.snake.sprite.Direction.RIGHT;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import java.util.ArrayList;
import java.util.List;

public class Snake implements Drawable {

    private SnakePart head;
    private List<SnakePart> body;
    private Direction direction = RIGHT;

    public Snake() {
        head = new SnakePart(new Texture(Gdx.files.internal("snakehead.png")));
        body = new ArrayList<>();
    }

    @Override
    public void updateState() {
        switch (direction) {
            case RIGHT:
                head.setX(head.getX() + GRID_SIZE);
                break;
            case LEFT:
                head.setX(head.getX() - GRID_SIZE);
                break;
            case UP:
                head.setY(head.getY() + GRID_SIZE);
                break;
            case DOWN:
                head.setY(head.getY() - GRID_SIZE);
                break;
        }
    }

    @Override
    public void draw(Batch batch) {
        head.draw(batch);
        body.forEach(snakePart -> snakePart.draw(batch));
    }

    @Override
    public boolean isCoordinatePartOf(float x, float y) {
        return head.isCoordinatePartOf(x, y) ||
            body.stream().anyMatch(p -> p.isCoordinatePartOf(x, y));
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
