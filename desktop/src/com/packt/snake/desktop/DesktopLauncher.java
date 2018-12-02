package com.packt.snake.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.packt.snake.SnakeGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		SnakeGame snakeGame = new SnakeGame();

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(snakeGame, config);

		snakeGame.setGraphics(Gdx.graphics);
	}
}
