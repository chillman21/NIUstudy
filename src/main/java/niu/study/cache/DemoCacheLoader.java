package niu.study.cache;

import com.google.common.cache.CacheLoader;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 随机缓存加载,实际使用时应实现业务的缓存加载逻辑,例如从数据库获取数据
 */
public  class DemoCacheLoader extends CacheLoader<Integer, String> {
    @Override
    public String load(Integer key) throws Exception {
        System.out.println(Thread.currentThread().getName() + " 加载数据开始");
        TimeUnit.SECONDS.sleep(3);
        Random random = new Random();
        System.out.println(Thread.currentThread().getName() + " 加载数据结束");
        return "value:" + random.nextInt(10000);
    }
}