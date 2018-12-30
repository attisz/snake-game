package com.packt.snake;

import static com.packt.snake.actor.ActorType.SNAKE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.packt.snake.actor.Actor;
import com.packt.snake.actor.ActorFactory;
import com.packt.snake.render.ActorRenderer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameScreenTest {

    @InjectMocks
    GameScreen gameScreen;

    @Mock
    ActorFactory actorFactory;

    @Mock
    Actor actor;

    @Mock
    ActorRenderer actorRenderer;

    @Test
    public void actorsCreatedOnlyOnShow() {
        assertThat(gameScreen.getActors(), empty());
        gameScreen.show();
        assertThat(gameScreen.getActors(), not(empty()));
    }

    @Test
    public void onRenderActorsStateUpdateCalled() {
        when(actorFactory.createActor(SNAKE)).thenReturn(actor);

        gameScreen.show();
        verify(actor, never()).stateUpdate();

        gameScreen.render(0f);
        gameScreen.render(0f);
        gameScreen.render(0f);

        verify(actor, times(3)).stateUpdate();
    }

    @Test
    public void onRenderActorsAreRendered() {
        when(actorFactory.createActor(SNAKE)).thenReturn(actor);

        gameScreen.show();

        gameScreen.render(0f);

        verify(actorRenderer, times(1)).render(actor);
    }
}
