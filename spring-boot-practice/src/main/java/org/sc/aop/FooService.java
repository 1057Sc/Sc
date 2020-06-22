package org.sc.aop;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class FooService {

    @Autowired
    private FooMapper fooMapper;

    @Autowired
    private ApplicationContextProvider applicationContextProvider;

    public FooEntity selectFoo(int id){

        return fooMapper.selectFoo(id);
    }

    public boolean addFoo(String name){
        try {
            TransactionStatus transactionStatus = TransactionAspectSupport.currentTransactionStatus();
            System.out.println(transactionStatus.isNewTransaction());
            fooMapper.fooAdd(name);
            this.exception();
        }catch (RuntimeException e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return true;
    }

    @Transactional
    public boolean addFoo(String name, int i){
        try {
            TransactionStatus transactionStatus = TransactionAspectSupport.currentTransactionStatus();
            System.out.println("dasdsadsadasdadasd"+transactionStatus.isNewTransaction());
            FooService fooService = applicationContextProvider.getBean(FooService.class);
            fooService.fooAdd(name);
            fooService.fooAdd(name);
            fooService.exception();
        }catch (RuntimeException e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return true;
    }

    @Transactional
    public boolean addFooTwo(String name, int i){
        try {
            this.fooAdd(name);
            this.fooAdd(name);
            this.exception();
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        return true;
    }

    @Transactional
    public boolean fooAdd(String name){
        fooMapper.fooAdd(name);
        return true;
    }

    public void exception(){
        throw new NullPointerException();
    }
}
