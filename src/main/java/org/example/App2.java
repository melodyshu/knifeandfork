package org.example;

/**
 * Hello world!
 *
 */

/**
 * 不会产生死锁问题
 */
public class App2
{
    public static void main( String[] args )
    {

        Tableware fork = new Tableware("fork");
        Tableware knife = new Tableware("knife");
        TablewarePair tablewarePair = new TablewarePair(fork, knife);
        new EatNoodleTread2("A",tablewarePair).start();
        new EatNoodleTread2("B",tablewarePair).start();

    }
}
