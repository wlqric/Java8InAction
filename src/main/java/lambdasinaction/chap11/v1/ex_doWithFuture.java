package lambdasinaction.chap11.v1;

import java.util.concurrent.*;

public class ex_doWithFuture {
    private Double doWithFuture() {
        ExecutorService executor = Executors.newCachedThreadPool(); // 通过ExecutorService,可以向线程池提交任务
        Future<Double> future = executor.submit(new Callable<>() { // 提交一个Callable对象
            public Double call() {
                return doSomeLongComputation(); //以异步方式在新线程中执行耗时的操作
            }
        });

        // 上面异步操作进行的同时,可以做其他的事情
        // doSomeThingElse();

        /*
          获取异步操作的结果,如果结果没有准备好,那么这个方法会阻塞,最多1s后退出.
         */
        try {
            Double result = future.get(1, TimeUnit.SECONDS);
            System.out.println(result);
            return result;
        } catch (ExecutionException ee) {
            // 计算抛出一个异常
            ee.printStackTrace();
        } catch (InterruptedException ie) {
            // 当前线程在等待过程中被中断
            ie.printStackTrace();
        } catch (TimeoutException te) {
            // 在Future对象完成之前超过已过期
            System.out.println("Computation took too long.");
            te.printStackTrace();
        }
        return null;
    }

    private Double doSomeLongComputation() {
        // 模拟一个耗时的操作
        try {
            Thread.sleep(1000);
            return (double) 1;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ex_doWithFuture df = new ex_doWithFuture();
        df.doWithFuture();
    }
}
