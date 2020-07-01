package org.sc.aop;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
@Transactional
public class FooService {

    @Autowired
    private PlatformTransactionManager txManager;

    @Autowired
    private FooMapper fooMapper;

    @Autowired
    private ApplicationContextProvider applicationContextProvider;

    public FooEntity selectFoo(int id){

        return fooMapper.selectFoo(id);
    }

    @Transactional
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
    public boolean addFooThree(String name){
        try {
            TransactionStatus transactionStatus = TransactionAspectSupport.currentTransactionStatus();
            System.out.println(transactionStatus.isNewTransaction());
            fooMapper.fooAdd(name);
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
        // TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition());
        try {
            TransactionStatus transactionStatus = TransactionAspectSupport.currentTransactionStatus();
            System.out.println("dasdsadsadasdadasd"+transactionStatus.isNewTransaction());
            FooService fooService = applicationContextProvider.getBean(FooService.class);
            fooService.fooAdd(name);
            fooService.fooAdd(name);
            fooService.exception();
            // txManager.commit(status);
        }catch (RuntimeException e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }finally {
            // txManager.rollback(status);
        }
        return true;
    }


    @Transactional
    public boolean addFoo1(String name, int i){
        // TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition());
        try {
            TransactionStatus transactionStatus = TransactionAspectSupport.currentTransactionStatus();
            System.out.println("dasdsadsadasdadasd"+transactionStatus.isNewTransaction());
            FooService fooService = applicationContextProvider.getBean(FooService.class);
            fooService.fooAdd(name);
            fooService.fooAdd(name);
            // fooService.exception();
            // txManager.commit(status);
        }catch (RuntimeException e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }finally {
            // txManager.rollback(status);
        }
        return true;
    }

    @Transactional
    public boolean addFoo3(String name, int i){
        // TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition());
        try {
            TransactionStatus transactionStatus = TransactionAspectSupport.currentTransactionStatus();
            System.out.println("dasdsadsadasdadasd"+transactionStatus.isNewTransaction());
            FooService fooService = applicationContextProvider.getBean(FooService.class);

            int l = 3;

            for (int i1 = 0; i1 < l; i1++) {
                fooService.fooAdd(name);
            }
            // fooService.exception();
            // txManager.commit(status);
        }catch (RuntimeException e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }finally {
            // txManager.rollback(status);
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

    public boolean barAdd(String name){
        fooMapper.fooAdd(name);
        exception();
        return true;
    }



    public void exception(){
        throw new NullPointerException();
    }
}
