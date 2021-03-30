package zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;

/**
 * @author zhuqingxin
 * @date 2021/3/29
 */
public class ZkDemo {

    public void lock() throws Exception {
        CuratorFramework client = null;
        String lockPath1 = "123";
        String lockPath2 = "1234";
        InterProcessLock lock1 = new InterProcessMutex(client, lockPath1); // 可重入锁
        InterProcessLock lock2 = new InterProcessSemaphoreMutex(client, lockPath2); // 不可重入锁


        lock1.acquire();
        lock1.release();
        lock1.acquire();

    }
}
