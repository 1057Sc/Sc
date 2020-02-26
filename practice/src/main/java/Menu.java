import java.util.List;

/**
 * Created by Sc on 2019/3/7.
 *
 * @Description:
 */
public class Menu {
    // 菜单id
    private String id;
    // 菜单名称
    private String name;
    // 父菜单id
    private String parentId;
    // 菜单url
    private String url;
    // 菜单图标
    private String icon;
    // 菜单顺序
    private int order;
    // 子菜单
    private List<Menu> childMenus;

    public Menu(String id, String name, String parentId) {
        super();
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Menu [id=" + id + ", name=" + name + ", parentId=" + parentId
                + ", url=" + url + ", icon=" + icon + ", order=" + order
                + ", childMenus=" + childMenus + "]";
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public List<Menu> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<Menu> childMenus) {
        this.childMenus = childMenus;
    }


}
