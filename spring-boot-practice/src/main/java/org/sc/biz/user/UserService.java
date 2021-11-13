package org.sc.biz.user;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        priRetrieve();

        return user;
    }

    private void priRetrieve() {
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
}
