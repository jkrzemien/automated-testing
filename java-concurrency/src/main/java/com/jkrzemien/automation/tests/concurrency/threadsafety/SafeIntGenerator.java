package com.jkrzemien.automation.tests.concurrency.threadsafety;

import com.jkrzemien.automation.tests.concurrency.threadsafety.interfaces.IIntGenerator;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Juan Krzemien
 */
class SafeIntGenerator implements IIntGenerator {
    private final AtomicInteger i = new AtomicInteger(0);

    public Integer getNextInt() {
        return i.incrementAndGet();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
