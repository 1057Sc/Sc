package arithmetic;

import java.util.List;

/**
 * Created by Sc on 2019/3/11.
 *
 * @Description:
 */
public class Entity {

    private String id;

    private String pid;

    private String name;

    private List<Entity> childEntity;

    public Entity(String id, String pid, String name) {
        this.id = id;
        this.pid = pid;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Entity> getChildEntity() {
        return childEntity;
    }

    public void setChildEntity(List<Entity> childEntity) {
        this.childEntity = childEntity;
    }
}
