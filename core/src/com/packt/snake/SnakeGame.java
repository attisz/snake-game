package com.packt.snake;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Screen;

public class SnakeGame extends Game {

    private Graphics graphics;

    @Override
    public void create() {
        setScreen(new GameScreen());
    }

    @Override
    public void setScreen(Screen screen) {
        if (this.screen != null) this.screen.hide();
        this.screen = screen;
        if (this.screen != null) {
            this.screen.show();
            this.screen.resize(graphics.getWidth(), graphics.getHeight());
        }
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }
}
