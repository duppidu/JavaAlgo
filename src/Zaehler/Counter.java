/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zaehler;

/**
 *
 * @author thomas.duppenthaler
 */
public class Counter extends Thread
{
    public String name;

    Counter(String name)
    {
        this.name = name;
    }

    @Override
    public void run()
    {

        for (int i = 1; i <= 10; i++)
        {
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException ex)
            {

            }

            System.out.println(name + ": " + i);
        }

    }

    public static void main(String[] args) throws InterruptedException
    {
        Counter c1 = new Counter("first");
        Counter c2 = new Counter("second");
        c1.start();
        c2.start();
    }
}
