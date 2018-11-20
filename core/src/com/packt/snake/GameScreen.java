package com.packt.snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.packt.snake.sprite.Apple;
import com.packt.snake.sprite.Snake;

import static com.badlogic.gdx.graphics.Color.BLACK;
import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;

public class GameScreen extends ScreenAdapter {

    private static final float TIME_WAIT = 0.2F;

    private SpriteBatch batch;
    private Snake snake;
    private Apple apple;

    private float timer;

    @Override
    public void show() {
        timer = TIME_WAIT;
        batch = new SpriteBatch();
        snake = new Snake();
        apple = new Apple();
    }

    @Override
    public void render(float delta) {
        timer -= delta;

        if (timer < 0) {
            timer = TIME_WAIT;
            render();
        }
    }

    private void render() {
        clearScreen();
        snake.update();

        batch.begin();
        snake.draw(batch);
        //apple.draw(batch);
        batch.end();
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(BLACK.r, BLACK.g, BLACK.b, BLACK.a);
        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);
    }
}
