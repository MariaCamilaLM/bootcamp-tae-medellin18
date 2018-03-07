package com.glb.bootcamp.tae.testng;

import org.testng.annotations.Test;

public class ThreadLocalTest {

    private ThreadLocal<String> myThreadLocal = new ThreadLocal<>();

    private ThreadLocal<UserAccount> userAccounts = new ThreadLocal<>();

    private UserAccount userAccount;

    @Test
    public void myTest1(){
        myThreadLocal.set(String.valueOf(Thread.currentThread().getId()));
        System.out.println("myTest1 - " + myThreadLocal.get());
    }

    @Test
    public void myTest2(){
        myThreadLocal.set(String.valueOf(Thread.currentThread().getId()));
        System.out.println("myTest2 - " + myThreadLocal.get());
    }

    @Test
    public void myTest3(){
        userAccount = new UserAccount();
        userAccount.setName("Damian");
        userAccount.setMoney(1);
        userAccounts.set(userAccount);
    }

    @Test
    public void myTest4(){
        UserAccount userAccount = userAccounts.get();
        if (userAccount == null){
            System.out.println("Yeah is null, because UserAccount is set in a different thread instance.");
        }
    }

    class UserAccount {

        private String name;

        private int money;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }
    }

}
