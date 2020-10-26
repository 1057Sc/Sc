package reflect.generic;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BeanTransform<ENTITY, DTO> extends GenericsDemo<ENTITY, DTO> {


    public List<DTO> toDTOList(List<ENTITY> entityList) {

        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.emptyList();
        }

        // Class.forName(DTO.class);

        List<DTO> dtos = new ArrayList<>();
        for (ENTITY entity : entityList) {
            DTO dto = this.newDTO();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        }
        return dtos;
    }


    public DTO newDTO() {
        DTO newD;
        try {
            // 通过反射获取model的真实类型
            ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class<DTO> clazz = (Class<DTO>) pt.getActualTypeArguments()[1];
            // 通过反射创建model的实例
            newD = clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return newD;
    }


    public static void main(String[] args) {

        BeanTransform<BarOne, FooOne> beanTransform = new BeanTransform();

        BarOne barOne = new BarOne();
        FooOne fooOne = new FooOne();

        List list = beanTransform.toDTOList(Collections.singletonList(barOne));
        System.out.println(list);
    }
}