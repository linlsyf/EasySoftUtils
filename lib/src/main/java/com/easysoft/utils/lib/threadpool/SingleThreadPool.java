package com.easysoft.utils.lib.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 */
/*package*/class SingleThreadPool extends ThreadProxy {
    protected BaseThreadPool executor;

    public BaseThreadPool getExecutor() {
        if (executor == null) {
            synchronized (SingleThreadPool.class) {
                if (executor == null) {
                    executor = new BaseThreadPool(1, 1, 0, TimeUnit.SECONDS,
                            new LinkedBlockingQueue<Runnable>(),
                            new ThreadPoolExecutor.AbortPolicy());
                }
            }
        }
        return executor;
    }
}
