/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patterns;

import Dice.*;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/**
 *
 * @author thomas.duppenthaler
 */
public class DiceRunnable extends DiceModel implements Runnable, Observable
{
    public String name;
    List<InvalidationListener> listeners = new ArrayList<>();

    public DiceRunnable()
    {

    }

    public DiceRunnable(String name)
    {
        this.name = name;
    }

    @Override
    public void addListener(InvalidationListener il)
    {
        listeners.add(il);
    }

    @Override
    public void removeListener(InvalidationListener il)
    {
        listeners.remove(il);
    }

    @Override
    public void run()
    {
        boolean x = false;

        do
        {
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException ex)
            {

            }

            roll();
            inform();
            System.out.print("|" + getValue());
        } while (x = true);

    }

    public void inform()
    {
        Platform.runLater(new Runnable()
        {

            @Override
            public void run()
            {
                for (InvalidationListener iL : listeners)
                {
                    iL.invalidated(DiceRunnable.this);
                }
            }
        });

    }

    public static void main(String[] args) throws InterruptedException
    {
        DiceRunnable c1 = new DiceRunnable("first");
        // CounterRunable c2 = new CounterRunable("second");
        // c1.setRange(10, 19);
        Thread t1 = new Thread(c1);
        // Thread t2 = new Thread(c2);
        t1.start();
        //t2.start();
    }

}
