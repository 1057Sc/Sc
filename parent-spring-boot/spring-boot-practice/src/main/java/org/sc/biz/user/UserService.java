package org.sc.biz.user;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.sql.Wrapper;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 如果method逻辑复杂，对应的单测编写也会复杂
     *
     * @param name
     * @return
     */
    public User retrieve(String name) {
        User user = userMapper.selectFoo(name);
        if (Objects.isNull(user)) {
            System.out.println("用户不存在");
            throw new RuntimeException(name + "用户不存在");
        }

        // 以下模拟业务逻辑
        if (StrUtil.equals("sc", name)) {
            // 场景逻辑1
            System.out.println("Hello Sc");
        }

        if (StrUtil.equals("odd", name)) {
            // 场景逻辑2
            System.out.println("Hello odd !");
        }

        preReetrieve();

        return user;
    }

    private void preReetrieve() {
        System.out.println("priRetrieve");
    }

    public long update(long id) {
        // 以下模拟业务逻辑
        if (id == 1) {
            System.out.println(id);
        }

        if (id == 2) {
            System.out.println(id);
        }

        if (id == 3) {
            System.out.println(id);
        }

        return userMapper.fooUpdate(1);
    }

    /**
     * 模拟业务逻辑和数据逻辑在一起，但是不好拆分的情况，
     * 为了提高自测效率避免过多单测代码产生，可以直接进行测试
     *
     *
     * @param updateCondition 更新条件
     * @return
     */
    public long update(User updateCondition) {
        if (Objects.isNull(updateCondition)) {
            return 0;
        }
        long id = updateCondition.getId();
        if (id == 1) {
            System.out.println(id);
        }

        if (id == 2) {
            System.out.println(id);
        }

        if (id == 3) {
            System.out.println(id);
        }
        return userMapper.fooUpdate(id);
    }

    public long create(String name) {
        return userMapper.fooAdd(name);
    }

    public long delete(long id) {
        // 以下模拟业务逻辑
        if (id == 1) {
            System.out.println(id);
        }

        if (id == 2) {
            System.out.println(id);
        }

        if (id == 3) {
            System.out.println(id);
        }
        return userMapper.fooDelete(1);
    }

    public void selectExample() {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(,)
    }

}
