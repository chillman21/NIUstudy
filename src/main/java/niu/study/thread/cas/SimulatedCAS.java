package niu.study.thread.cas;

/**
 * 模拟CAS操作等价代码
 * @author NIU
 * @createTime 2020/8/2 15:25
 */
public class SimulatedCAS {
    private volatile int value;
    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectedValue) {
            value = newValue;
        }
        return oldValue;
    }
}
