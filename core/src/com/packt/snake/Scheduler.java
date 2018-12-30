package com.packt.snake;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

public class Scheduler {

    private List<Runnable> tasks = newArrayList();
    private float rate;
    private float timeElapsed;

    public Scheduler(float rate) {
        this.rate = rate;
    }

    public void addTask(Runnable runnable) {
        tasks.add(runnable);
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public void tick(float timeElapsed) {
        this.timeElapsed += timeElapsed;
        if (this.timeElapsed >= rate) {
            tasks.forEach(Runnable::run);
            this.timeElapsed -= rate;
        }
    }
}
