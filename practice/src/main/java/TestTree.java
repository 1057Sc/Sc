import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sc on 2019/3/7.
 *
 * @Description:
 */
public class TestTree {


    public static List<Menu> initData() {
        List<Menu> treeData = new ArrayList<Menu>();
        treeData.add(new Menu("1", "1", "0"));
        treeData.add(new Menu("2", "2", "1"));
        treeData.add(new Menu("3", "3", "1"));
        treeData.add(new Menu("4", "4", "2"));
        treeData.add(new Menu("5", "5", "0"));
        treeData.add(new Menu("6", "6", "2"));
        treeData.add(new Menu("7", "7", "2"));
        treeData.add(new Menu("8", "8", "3"));
        treeData.add(new Menu("9", "9", "10"));
        treeData.add(new Menu("10", "10", "6"));
        treeData.add(new Menu("11", "11", "7"));
        return treeData;
    }

    private static List<Menu> getChild(String id, List<Menu> rootMenu) {
        // 子菜单
        List<Menu> childList = new ArrayList();
        for (Menu menu : rootMenu) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (menu.getParentId().equals(id)) {
                childList.add(menu);
            }
        }

        // 把子菜单的子菜单再循环一遍
        for (Menu menu : childList) {
            menu.setChildMenus(getChild(menu.getId(), rootMenu));// 递归
        }

        // 判断递归结束
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Menu> treeData = initData(); // 原始数据

        // 查看结果
        for (Menu menu : treeData) {
            //System.out.println(menu.toString());
        }

        List<Menu> menuList = new ArrayList<Menu>(); // 树递归

        // 先找到所有的一级菜单
        for (int i = 0; i < treeData.size(); i++) {
            // 一级菜单父ID为0
            if (treeData.get(i).getParentId().equals("0")) {
                menuList.add(treeData.get(i));
            }
        }

        // 为一级菜单设置子菜单，getChild是递归调用的
        for (Menu menu : menuList) {
            menu.setChildMenus(getChild(menu.getId(), treeData));
        }

        Map<String,Object> jsonMap = new HashMap<String,Object>();
        jsonMap.put("menu", menuList);
        System.out.println(jsonMap);
    }



}
