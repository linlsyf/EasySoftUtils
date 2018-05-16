package com.easysoft.utils.lib.threadpool;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 */
/*package*/class ComputationThreadPool extends ThreadProxy {
    protected BaseThreadPool executor;

    public BaseThreadPool getExecutor() {
        if (executor == null) {
            synchronized (ComputationThreadPool.class) {
                if (executor == null) {
                    executor = new BaseThreadPool(0, Integer.MAX_VALUE,
                            60L, TimeUnit.SECONDS,
//                            new LinkedBlockingQueue<Runnable>());
                            new SynchronousQueue<Runnable>(true));
                }
            }
        }
        return executor;
    }
}
