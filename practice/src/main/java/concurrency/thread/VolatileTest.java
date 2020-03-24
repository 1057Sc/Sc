package concurrency.thread;

/**
 * Created by Sc on 2018/7/19.
 */
public class VolatileTest {

    public static volatile int race = 0;

    public static void increase(){
        race ++;
    }

    private static final int threads_count = 20 ;

    public static void main(String[] args){
        Thread[] threads = new Thread[threads_count];
        for(int i=0;i<threads_count;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<10;i++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        while(Thread.activeCount()>1) {
            Thread.yield();
        }
        System.out.println(race);

    }

}
