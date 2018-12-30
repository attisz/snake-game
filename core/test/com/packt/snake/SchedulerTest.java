package com.packt.snake;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.stream.IntStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SchedulerTest {

    @InjectMocks
    private Scheduler scheduler = new Scheduler(1.0F);

    @Mock
    private Runnable runnable1;

    @Mock
    private Runnable runnable2;

    @Test
    public void noExecutionSinceRateNotReached() {
        scheduler.addTask(runnable1);
        scheduler.setRate(1.0F);

        scheduler.tick(0.2F);
        scheduler.tick(0.2F);
        scheduler.tick(0.2F);
        verify(runnable1, never()).run();
    }

    @Test
    public void oneExecutionSinceDelayEqualsRate() {
        scheduler.addTask(runnable1);
        scheduler.setRate(1.0F);

        scheduler.tick(1.0F);
        verify(runnable1, times(1)).run();
    }

    @Test
    public void oneExecutionTwoTicksDelaysReachedRate() {
        scheduler.addTask(runnable1);
        scheduler.setRate(1.0F);

        scheduler.tick(0.5F);
        scheduler.tick(0.5F);
        verify(runnable1, times(1)).run();
    }

    @Test
    public void executionsHappenedOnlyWithGivenRate() {
        scheduler.addTask(runnable1);
        scheduler.setRate(10F);

        scheduler.tick(5F);
        verify(runnable1, never()).run();
        scheduler.tick(5F);
        verify(runnable1, times(1)).run();
        scheduler.tick(5F);
        verify(runnable1, times(1)).run();
        scheduler.tick(5F);
        verify(runnable1, times(2)).run();
    }

    @Test
    public void remainderValues() {
        float rate = 1F;
        float tickDelay = 0.7f;

        scheduler.addTask(runnable1);
        scheduler.setRate(rate);

        IntStream.range(1, 10)
            .forEach(i -> {
                float allTimeElapsed = i * tickDelay;
                int expectedTimes = (int) Math.floor(allTimeElapsed / rate);
                scheduler.tick(tickDelay);
                verify(runnable1, times(expectedTimes)).run();
            });
    }

    @Test
    public void multipleTasks() {
        scheduler.addTask(runnable1);
        scheduler.addTask(runnable2);
        scheduler.setRate(1.0F);

        scheduler.tick(1.0F);
        verify(runnable1, times(1)).run();
        verify(runnable2, times(1)).run();
    }
}
