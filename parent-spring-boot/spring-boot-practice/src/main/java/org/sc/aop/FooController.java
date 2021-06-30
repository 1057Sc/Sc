package org.sc.aop;

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
    @Autowired
    private BarService barServices;
    @Autowired
    private SpringContext springContext;

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

    @RequestMapping("/manymany")
    public void man(){
        Object barService = SpringContext.getBean("barService");
        System.out.println(barService);
        System.out.println(barServices);
        Object barService1 = SpringContext.getBean(BarService.class);
        System.out.println(barService1);
    }


    @RequestMapping("/manymanytwo")
    public void mant(){
        Object barService = SpringContext.getBean("fooService");
        System.out.println(barService);
    }


}
