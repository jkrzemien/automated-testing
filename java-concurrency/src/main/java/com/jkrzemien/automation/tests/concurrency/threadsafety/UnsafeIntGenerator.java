package com.jkrzemien.automation.tests.concurrency.threadsafety;

import com.jkrzemien.automation.tests.concurrency.threadsafety.interfaces.IIntGenerator;

/**
 * @author Juan Krzemien
 */
class UnsafeIntGenerator implements IIntGenerator {
    private Integer i = 0;

    public Integer getNextInt() {
        return ++i;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}
