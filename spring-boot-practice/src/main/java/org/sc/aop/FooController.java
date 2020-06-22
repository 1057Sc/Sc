package org.sc.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foo_query")
public class FooController {

    @Autowired
    private FooService fooService;

    @RequestMapping("/get")
    public FooEntity getFoo(Integer id) {

        return fooService.selectFoo(id);
    }

    @RequestMapping("/add")
    public boolean addFoo(String name) {
        return fooService.addFoo(name);
    }

    @RequestMapping("/add_one")
    public int addFoo(String name, int i) {
        fooService.addFoo(name, i);
        return 1;
    }

    @RequestMapping("/add_two")
    public int addFooTwo(String name, int i) {
        fooService.addFooTwo(name, i);
        return 1;
    }
}
