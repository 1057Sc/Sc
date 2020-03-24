package concurrency.thread.volatiletodo;

class VolatileExample {
    int x = 0;
    volatile boolean v = false;
    public void writer() {
        x = 42;
        v = true;
    }

    public void reader() {
        if (v == true) {
            //uses x - guaranteed to see 42.
        }
    }
}