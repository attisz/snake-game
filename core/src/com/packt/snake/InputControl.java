package com.packt.snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.packt.snake.sprite.Direction;
import java.util.Optional;

public class InputControl {

    public Optional<Direction> getNewDirection() {
        boolean upPressed = Gdx.input.isKeyPressed(Input.Keys.UP);
        boolean downPressed = Gdx.input.isKeyPressed(Input.Keys.DOWN);
        boolean leftPressed = Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean rightPressed = Gdx.input.isKeyPressed(Input.Keys.RIGHT);

        Direction direction = null;

        if (upPressed) {
            direction = Direction.UP;
        } else if (downPressed) {
            direction = Direction.DOWN;
        } else if (leftPressed) {
            direction = Direction.LEFT;
        } else if (rightPressed) {
            direction = Direction.RIGHT;
        }

        return Optional.ofNullable(direction);
    }
}
