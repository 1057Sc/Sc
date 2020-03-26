package concurrency.threadlocal;

public class Context {

    private String id;

    private String name;

    public Context() {
    }

    public Context(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Context{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
