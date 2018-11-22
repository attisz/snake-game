package com.packt.snake;

import static com.badlogic.gdx.graphics.Color.BLACK;
import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.packt.snake.sprite.Apple;
import com.packt.snake.sprite.Snake;

public class GameScreen extends ScreenAdapter {

    private static final float TIME_WAIT = 1F;
    public static final int GRID_SIZE = 32;

    private SpriteBatch batch;
    private Snake snake;
    private Apple apple;

    private float timer;

    @Override
    public void show() {
        batch = new SpriteBatch();
        snake = new Snake();
        apple = new Apple();
    }

    @Override
    public void render(float delta) {
        timer -= delta;
        if (timer <= 0) {
            timer = TIME_WAIT;
            reCalculate();
        }
        draw();
    }

    private void reCalculate() {
        snake.updateState();

        if (snakeEatApple()) {
            updateApple();
        }

    }

    private void draw() {
        clearScreen();
        batch.begin();
        snake.draw(batch);
        apple.draw(batch);
        batch.end();
    }

    private boolean snakeEatApple() {
        return snake.isCoordinatePartOf(apple.getX(), apple.getY());
    }

    private void updateApple() {
        do {
            apple.updateState();
        } while (snake.isCoordinatePartOf(apple.getX(), apple.getY()));
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(BLACK.r, BLACK.g, BLACK.b, BLACK.a);
        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);
    }
}
