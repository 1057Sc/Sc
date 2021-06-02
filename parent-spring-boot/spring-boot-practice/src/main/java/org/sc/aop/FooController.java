package org.sc.aop;

import org.sc.config.FooEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foo_query")
public class FooController {

    @Autowired
    private FooService fooService;
    @Autowired
    private FooMapper fooMapper;

    @RequestMapping("/get")
    public FooEntity getFoo(Integer id) {

        return fooService.selectFoo(id);
    }

    @RequestMapping("/add")
    public boolean addFoo(String name) {
        return fooService.addFoo(name);
    }

    @RequestMapping("/add_three")
    public boolean add_three(String name) {
        return fooService.addFooThree(name);
    }

    // 可以回滚
    @RequestMapping("/add_one")
    public int addFoo(String name, int i) {
        fooService.addFoo(name, i);
        return 1;
    }

    @RequestMapping("/add_one_1")
    public int addFoo1(String name, int i) {
        fooService.addFoo1(name, i);
        return 1;
    }

    @RequestMapping("/add_one_3")
    public int addFoo3(String name, int i) {
        fooService.addFoo3(name, i);
        return 1;
    }

    @RequestMapping("/add_two")
    public int addFooTwo(String name, int i) {
        fooService.addFooTwo(name, i);
        return 1;
    }

    @RequestMapping("/bar_add")
    public int barAdd(String name) {
        fooService.barAdd(name);
        return 1;
    }

    @RequestMapping("/foo_update")
    public int fooUpdate() {
        fooMapper.fooUpdate();
        return 1;
    }


}
