package com.packt.snake.actor;

public interface ActorFactory {
    Actor createActor(ActorType actorType);
}
