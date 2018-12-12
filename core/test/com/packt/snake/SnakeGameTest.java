package com.packt.snake;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;

import com.badlogic.gdx.Graphics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SnakeGameTest {

    @InjectMocks
    SnakeGame snakeGame;

    @Mock
    Graphics graphics;

    @Test
    public void screenCreationAtStartup() {
        snakeGame.create();
        assertThat(snakeGame.getScreen(), notNullValue());
        assertThat(snakeGame.getScreen(), instanceOf(GameScreen.class));
    }
}