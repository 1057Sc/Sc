/**
 * @author zhuqingxin
 * @date 2021/3/30
 */
public class ConcurrentProblem{

    private static ConcurrentProblem concurrentProblem = new ConcurrentProblem();
    private static int count;


    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> concurrentProblem.demo());
        Thread thread2 = new Thread(() -> concurrentProblem.demo());
        thread1.start();
        thread2.start();
        try {
            // 等待两个线程都运行结束后，再打印结果
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //期待结果是20000，但是结果会小于这个值
        System.out.println(count);
    }

    private void demo(){
        for (int k = 0; k < 10000; k++) {
            count++;
        }
    }

    /**
     * 多线程问题原因：count++这行代码要分三步执行；1：读取；2：修改；3：写入。
     * 在这三步中，任何一步都可能被其他线程打断，导致值还没来得及写入，就被其他线程读取或写入，这就是多线程并行操作统一变量导致的问题。
     */
/*    @Override
    public void run() {
        for (int k = 0; k < 10000; k++) {
            count++;
        }
    }*/
}
