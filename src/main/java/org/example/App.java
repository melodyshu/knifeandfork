package org.example;

/**
 * Hello world!
 *
 */

/**
 * 会产生死锁问题
 */
public class App 
{
    public static void main( String[] args )
    {
        Tableware fork = new Tableware("fork");
        Tableware knife = new Tableware("knife");
        new EatNoodleTread("A",fork,knife).start();
        new EatNoodleTread("B",knife,fork).start();

    }
}
