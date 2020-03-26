package concurrency.threadlocal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ShareContext implements Runnable {

    public static Map<Integer, Context> shareContext = new ConcurrentHashMap<>();

    private Integer id;

    ShareContext(Integer id){
        this.id = id;
    }

    @Override
    public void run() {
        shareContext.put(id , new Context(id.toString(), id + "asdasd"));
    }
}
