package arithmetic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sc on 2019/3/11.
 *
 * @Description:
 */
public class JsonTree {

    public static void main(String[] args) {
        List<Entity> initList = init();
        List<Entity> rootList = new ArrayList<>();
        //寻找root节点
        for(Entity entity:initList){
            if("0".equals(entity.getPid())) {
                rootList.add(entity);
            }
        }
        //为每个节点寻找他的子节点
        for(Entity rootlist:rootList){
            rootlist.setChildEntity(getChild(rootlist.getId(),initList));
        }

        Map map = new HashMap();
        map.put("jsonMap",rootList);
        System.out.println(1);
    }


    public static List<Entity> init(){
        List<Entity> initList = new ArrayList<>();
        initList.add(new Entity("1","0","一级节点"));
        initList.add(new Entity("2","0","一级节点"));
        initList.add(new Entity("3","0","1级节点"));
        initList.add(new Entity("4","1","2级节点"));
        initList.add(new Entity("5","2","2级节点"));
        initList.add(new Entity("6","3","2级节点"));
        initList.add(new Entity("7","4","3级节点"));
        initList.add(new Entity("8","5","3级节点"));
        initList.add(new Entity("9","6","3级节点"));
/*        initList.add(new Entity("11","0","一级节点"));
        initList.add(new Entity("2","1","二级节点"));
        initList.add(new Entity("3","1","二级节点"));
        initList.add(new Entity("4","1","二级节点"));
        initList.add(new Entity("5","2","三级节点"));
        initList.add(new Entity("6","2","三级节点"));
        initList.add(new Entity("7","2","三级节点"));
        initList.add(new Entity("8","3","四级节点"));
        initList.add(new Entity("9","3","四级节点"));
        initList.add(new Entity("10","3","四级节点"));*/
        return initList;
    }
    /**
     *
     * @param pId 这个id为父id
     * @param pList
     * @return 为每一个对象设置他的子集
     */
    public static List<Entity> getChild(String pId,List<Entity> pList){
        List<Entity> childList = new ArrayList<>();
        for(Entity list:pList){
            if(pId.equals(list.getPid())){
                childList.add(list);
            }
        }

        for(Entity cList:childList){
            cList.setChildEntity(getChild(cList.getId(),pList));
        }
        return childList;
    }

}
