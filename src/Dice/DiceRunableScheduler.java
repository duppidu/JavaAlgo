/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author thomas.duppenthaler
 */
public class DiceRunableScheduler extends DiceModel implements Runnable
{
    public String name;

    DiceRunableScheduler(String name)
    {
        this.name = name;
    }

    @Override
    public void run()
    {
        
            roll();
            System.out.println(getValue());
        

    }

    public static void main(String[] args) throws InterruptedException
    {
        DiceRunableScheduler c1 = new DiceRunableScheduler("first");
      
        
        int delay =0;
       int intervall =1;
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(c1, delay, intervall, TimeUnit.SECONDS);
    }
}
