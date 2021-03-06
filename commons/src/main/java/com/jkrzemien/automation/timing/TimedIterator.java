package com.jkrzemien.automation.timing;

import java.time.Duration;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

import static java.lang.System.nanoTime;

/**
 * @author Juan Krzemien
 */
public class TimedIterator implements Spliterator<Long> {

    private final long end;
    private final AtomicLong counter = new AtomicLong(1);

    public TimedIterator(Duration duration) {
        long start = nanoTime();
        this.end = start + duration.toNanos();
    }

    @Override
    public boolean tryAdvance(Consumer<? super Long> action) {
        if (nanoTime() > end) {
            return false;
        }
        action.accept(counter.getAndIncrement());
        return true;
    }

    @Override
    public Spliterator<Long> trySplit() {
        return this;
    }

    @Override
    public long estimateSize() {
        return Long.MAX_VALUE;
    }

    @Override
    public int characteristics() {
        return ORDERED | DISTINCT | SORTED | IMMUTABLE;
    }
}
