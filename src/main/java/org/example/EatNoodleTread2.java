package org.example;

import java.util.concurrent.TimeUnit;

public class EatNoodleTread2 extends Thread {
    private final String name;
    private final TablewarePair tablewarePair;

    public EatNoodleTread2(String name, TablewarePair tablewarePair){
        this.name=name;
        this.tablewarePair=tablewarePair;
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
        synchronized (tablewarePair){
            System.out.println(name+" 拿起了 "+tablewarePair.getLeftTool()+"(left)");
            System.out.println(name+" 拿起了 "+tablewarePair.getRightTool()+"(right)");
            System.out.println(name+" is eating now.");
            System.out.println(name+" 放下了 "+tablewarePair.getRightTool()+"(right)");
            System.out.println(name+" 放下了 "+tablewarePair.getLeftTool()+"(left)");
        }
    }
}
