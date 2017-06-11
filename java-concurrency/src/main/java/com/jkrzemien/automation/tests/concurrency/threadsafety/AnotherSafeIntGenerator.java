package com.jkrzemien.automation.tests.concurrency.threadsafety;

import com.jkrzemien.automation.tests.concurrency.threadsafety.interfaces.IIntGenerator;

/**
 * @author Juan Krzemien
 */
class AnotherSafeIntGenerator implements IIntGenerator {
    private Integer i = 0;

    public synchronized Integer getNextInt() {
        return ++i;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
