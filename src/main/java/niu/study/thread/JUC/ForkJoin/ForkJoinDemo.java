package niu.study.thread.JUC.ForkJoin;

import java.util.concurrent.RecursiveTask;

/**
 * 求和计算的任务！
 * 如何使用ForkJoin： 维护了一个双向队列 适合大数据量
 *      1.通过ForkJoinPool来执行
 *      2.计算任务 forkJoinPool.execute(ForkJoinTask task) 有返回值
 */
public class ForkJoinDemo extends RecursiveTask<Long> {
    private Long start;
    private Long end;
    //临界值
    private Long temp = 10000L;
    //计算方法
    @Override
    protected Long compute() {
        if((end-start)>temp){
            //分支合并计算
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum+=i;
            }
            return sum;
        }else{//forkJoin
            long middle = (start + end) / 2;//中间值
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            task1.fork();//拆分任务，把任务压入线程队列
            ForkJoinDemo task2 = new ForkJoinDemo(middle+1, end);
            task2.fork();
            return task1.join()+task2.join();
        }
    }

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }


}
