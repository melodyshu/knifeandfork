package org.example;

import java.util.concurrent.TimeUnit;

public class EatNoodleTread extends Thread {
    private final String name;
    private final Tableware leftTool;
    private final Tableware rightTool;

    public EatNoodleTread(String name,Tableware leftTool,Tableware rightTool){
        this.name=name;
        this.leftTool=leftTool;
        this.rightTool=rightTool;
    }

    @Override
    public void run() {
        while (true){
            this.eat();
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void eat() {
        synchronized (leftTool){
            System.out.println(name+" 拿起了 "+leftTool+"(left)");
            synchronized (rightTool){
                System.out.println(name+" 拿起了 "+rightTool+"(right)");
                System.out.println(name+" is eating now.");
                System.out.println(name+" 放下了 "+rightTool+"(right)");
            }
            System.out.println(name+" 放下了 "+leftTool+"(left)");
        }
    }
}
