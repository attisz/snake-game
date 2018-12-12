package com.packt.snake;

import static com.google.common.collect.Lists.newArrayList;

import com.badlogic.gdx.ScreenAdapter;
import com.packt.snake.actor.Actor;
import com.packt.snake.actor.ActorFactory;
import com.packt.snake.actor.ActorType;
import java.util.Collection;

class GameScreen extends ScreenAdapter {

    private final ActorFactory actorFactory;
    private Collection<Actor> actors;

    public GameScreen(ActorFactory actorFactory) {
        this.actorFactory = actorFactory;
        this.actors = newArrayList();
    }

    @Override
    public void show() {
        createActors(actorFactory);
    }

    @Override
    public void render(float delta) {
        actors.forEach(Actor::stateUpdate);
    }

    private void createActors(ActorFactory actorFactory) {
        actors.add(actorFactory.createActor(ActorType.SNAKE));
    }

    public Collection<Actor> getActors() {
        return actors;
    }
}
