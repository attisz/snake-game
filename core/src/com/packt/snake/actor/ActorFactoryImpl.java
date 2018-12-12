package com.packt.snake.actor;

public class ActorFactoryImpl implements ActorFactory {
    @Override
    public Actor createActor(ActorType actorType) {
        return () -> {
        };
    }
}
