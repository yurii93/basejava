package com.java.webapp;

public class LazySingletonOnDemandHolder {
    private LazySingletonOnDemandHolder() {
    }

    private static class LazySingletonHolder {
        private static final LazySingletonOnDemandHolder INSTANCE = new LazySingletonOnDemandHolder();
    }

    public static LazySingletonOnDemandHolder getInstance() {
        return LazySingletonHolder.INSTANCE;
    }
}

class LazySingletonDoubleCheckLocking {
    private static volatile LazySingletonDoubleCheckLocking INSTANCE;

    private LazySingletonDoubleCheckLocking() {
    }

    public static LazySingletonDoubleCheckLocking getInstance() {
        if (INSTANCE == null) {
            synchronized (LazySingletonDoubleCheckLocking.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazySingletonDoubleCheckLocking();
                }
            }
        }
        return INSTANCE;
    }
}