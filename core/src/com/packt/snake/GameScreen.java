package com.packt.snake;

import static com.google.common.collect.Lists.newArrayList;
import static com.packt.snake.SnakeGame.DEFAULT_STATE_UPDATE_RATE;

import com.badlogic.gdx.ScreenAdapter;
import com.packt.snake.actor.Actor;
import com.packt.snake.actor.ActorFactory;
import com.packt.snake.actor.ActorType;
import com.packt.snake.render.ActorRenderer;
import java.util.Collection;

class GameScreen extends ScreenAdapter {

    private final ActorFactory actorFactory;
    private final ActorRenderer actorRenderer;
    private Collection<Actor> actors;
    private Scheduler scheduler = new Scheduler(DEFAULT_STATE_UPDATE_RATE);

    public GameScreen(ActorFactory actorFactory, ActorRenderer actorRenderer) {
        this.actorFactory = actorFactory;
        this.actorRenderer = actorRenderer;
        this.actors = newArrayList();
    }

    @Override
    public void show() {
        createActors(actorFactory);
        actors.forEach(actor -> scheduler.addTask(actor::stateUpdate));
    }

    @Override
    public void render(float delta) {
        scheduler.tick(delta);
        actors.forEach(actorRenderer::render);
    }

    private void createActors(ActorFactory actorFactory) {
        actors.add(actorFactory.createActor(ActorType.SNAKE));
    }

    public Collection<Actor> getActors() {
        return actors;
    }

    public void setRate(float rate) {
        scheduler.setRate(rate);
    }
}
