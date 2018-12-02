package com.packt.snake;

import com.badlogic.gdx.Graphics;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.mock;

public class SnakeGameTest {

    @Test
    public void screenCreationAtStartup() {
        SnakeGame snakeGame = new SnakeGame();
        snakeGame.setGraphics(mock(Graphics.class));

        snakeGame.create();

        assertThat(snakeGame.getScreen(), notNullValue());
        assertThat(snakeGame.getScreen(), instanceOf(GameScreen.class));
    }
}